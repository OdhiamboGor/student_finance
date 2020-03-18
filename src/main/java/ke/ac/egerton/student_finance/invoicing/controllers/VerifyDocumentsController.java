package ke.ac.egerton.student_finance.invoicing.controllers;


import ke.ac.egerton.models.Student;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import ke.ac.egerton.student_finance.invoicing.repositories.VerifyDocumentsRepository;
import ke.ac.egerton.student_finance.invoicing.services.VerifyDocumentsService;
import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.student.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(path="invoicing/verifyDocuments")
public class VerifyDocumentsController {

    //Autowired Repositories
    @Autowired
    VerifyDocumentsRepository verifyDocumentsRepository;
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    ChargeItemRepository chargeItemRepository;

    //Autowired services
    VerifyDocumentsService verifyDocumentsService;

    @RequestMapping(path="verifyDocument", method = RequestMethod.GET)
    public String verifyDocumentForm(Model model){
        List<VerifyDocuments> verifyDocuments = verifyDocumentsRepository.findTopByDocumentStatus();
        model.addAttribute("documents", verifyDocuments);
        return "invoicing/verifyDocuments/verifyDocumentForm";
    }
    @RequestMapping(path="verifyDocument", method = RequestMethod.POST)
    public String getDocument(@RequestParam("documentNumber") String documentNumber,Model model) {

        VerifyDocuments documents = verifyDocumentsRepository.findByDocumentNumber(documentNumber);
        String documentType = documents.getDocumentType();

        switch (documentType) {
            case "RC":

                model.addAttribute("documents", documents);

                Receipt receipt = receiptRepository.findByReceiptNumber(documentNumber);
                model.addAttribute("receipt", receipt);

                Student student = studentsRepository.findByAccountNumber(receipt.getCustomerId());
                model.addAttribute("student", student);

                List<ChargeItem> chargeItems = chargeItemRepository.findAll();
                model.addAttribute("segment", chargeItems);

                return "invoicing/verifyDocuments/verifyDocumentResultForm";

            case "DN":

            case "CN":
                model.addAttribute("documents", documents);
                Student student1 = studentsRepository.findByAccountNumber(documents.getCustomerId());
                model.addAttribute("student", student1);

                List<ChargeItem> chargeItems1 = chargeItemRepository.findAll();
                model.addAttribute("segment", chargeItems1);
                return "invoicing/verifyDocuments/verifyDocumentsResultForm";
        }
        return "invoicing/verifyDocuments/verifyDocumentForm";
    }
    @RequestMapping(path="update", method = RequestMethod.POST)
    public String update(@RequestParam("documentNumber") String documentNumber, @RequestParam("amount") BigDecimal amount, Model model){

      /* System.out.println(documentNumber);
       System.out.println(amount);*/

        VerifyDocuments verifyDocuments = verifyDocumentsRepository.findByDocumentNumber(documentNumber);
       // System.out.println(verifyDocuments);

        verifyDocuments.setHomeAmount(amount);
        verifyDocumentsRepository.save(verifyDocuments);
        //verifyDocumentsService.updateVerifyInvoice(verifyDocuments,amount);

       return "redirect:/invoicing/verifyDocuments/verifyDocument";
    }
    @RequestMapping(path="delete", method = RequestMethod.POST)
    public String delete(@RequestParam("documentNumber") String documentNumber, Model model){
        VerifyDocuments verifyDocuments = verifyDocumentsRepository.findOne(documentNumber);

        Boolean documentStatus = verifyDocuments.getDocumentStatus();
        if (documentStatus = true){

            model.addAttribute("error", "Document once posted cannot be modified");

            return "invoicing/verifyDocuments/verifyDocumentForm";
        }

        verifyDocumentsRepository.delete(documentNumber);

        return "redirect:/invoicing/verifyDocuments/verifyDocument";
    }
}
