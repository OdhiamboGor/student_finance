package ke.ac.egerton.student_finance.receipting.controllers;


import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.StudentRepository;
import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.receipting.controllers.validation.ReceiptBatchDetails;
import ke.ac.egerton.student_finance.receipting.models.CancelReceipt;
import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import ke.ac.egerton.student_finance.receipting.models.VerifyReceipt;
import ke.ac.egerton.student_finance.receipting.repositories.CancelReceiptRepository;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptBatchRepository;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptRepository;
import ke.ac.egerton.student_finance.receipting.repositories.VerifyReceiptRepository;
import ke.ac.egerton.student_finance.receipting.services.VerifyReceiptService;
import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankRepository;
import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentModeRepository;
import ke.ac.egerton.student_finance.settings.receipts.models.CancelReason;
import ke.ac.egerton.student_finance.settings.receipts.repositories.CancelReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@Controller
@RequestMapping(path = "receipting/receipt")
public class ReceiptController {

    //Autowired Repositories
    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    BankRepository banksRepository;
    @Autowired
    PaymentModeRepository paymentModeRepository;
    @Autowired
    CancelReceiptRepository cancelReceiptRepository;
    @Autowired
    CancelReasonRepository cancelReasonRepository;
    @Autowired
    ReceiptBatchRepository receiptBatchRepository;
    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;
    @Autowired
    VerifyReceiptRepository verifyReceiptRepository;

    //Autowired Services
    @Autowired
    VerifyReceiptService verifyReceiptService;


    @RequestMapping(path = "cancelReceiptForm", method = RequestMethod.GET)
    public String cancelReceiptForm(){
        return "receipting/receipts/cancelReceipt";
    }

    //Finding Receipt using receipt number
    @RequestMapping(path="findReceipt", method = RequestMethod.GET)
    public String getReceipt(Receipt receipt,@RequestParam("receiptNumber") String receiptNumber, Model model) {

        //String rcptNo = receipt.getReceiptNumber();
        System.out.println(receiptNumber);

        Receipt receipt1 = receiptRepository.findByReceiptNumber(receiptNumber);

        //System.out.println(receipt1);

        if (receipt1 == null) {
            model.addAttribute("error", "No Record found");
            return "receipting/receipts/cancelReceipt";
        }
        else {
            String cId = receipt1.getCustomerId();

            Student student = studentRepository.findTopByStudentNumberIgnoreCase(cId);

            //Setting posted to read Yes/No
            Receipt rcpt = receiptRepository.findByReceiptNumber(receiptNumber);
            int post = rcpt.getPosted();
            String pst;
            switch (post) {
                case 0 :
                    pst = "No";
                    break;
                case 1:
                    pst= "Yes";
                    break;
                default:
                    pst = "";
            }
            String posts= pst;
            model.addAttribute("posts", posts);

            //Splitting receipt number into different parts
            //String rcptno = receipt1.getReceiptNumber();

            String[] parts = receiptNumber.split("-");

            String receiptNo1 = parts[0];
            String receiptNo2 = parts[1];

            //System.out.println(receiptNo1);
            //System.out.println(receiptNo2);

            //Searching for bank details
            Bank bank = banksRepository.findTopByCode(receiptNo1);
            model.addAttribute("bank", bank);

            //searching for payment mode
            PaymentGateway  paymentGateway  = paymentGatewayRepository.findTopById(bank.getId());
            Long id =  paymentGateway.getPaymentMode().getId();
            PaymentMode paymentMode = paymentModeRepository.findById(id);
            model.addAttribute("paymentMode", paymentMode);

            //Getting type of receipt
            ReceiptType receiptType = bank.getReceiptType();
            PayeeGroup payeeGroup = receiptType.getPayeeGroup();

            //Getting receipt cancel reason
            List<CancelReason> reason = cancelReasonRepository.findAll();
            //Getting batches
            List<ReceiptBatch> rBatches = receiptBatchRepository.findAll(new Sort(Sort.Direction.DESC, "batchDate"));

            model.addAttribute("payeeGroup", payeeGroup);
            model.addAttribute("receipt", rcpt);
            model.addAttribute("student", student);
            model.addAttribute("reason", reason);
            model.addAttribute("rBatches", rBatches);

            return "receipting/receipts/cancelReceiptResult";
        }
    }
    //Calling verify receipt form
    @RequestMapping(path="verifyReceiptForm", method = RequestMethod.GET)
    public String verifyReceiptForm(Model model){
        List <ReceiptBatch> receiptBatch = receiptBatchRepository.findByPostFalse();
        model.addAttribute("rBatch", receiptBatch);
        return "receipting/receipts/verifyReceipt";
    }

    @RequestMapping(path="transactions", method = RequestMethod.POST)
    public String transactions( ReceiptBatch receiptBatch, Model model){

        List <ReceiptBatch> receiptBtch = receiptBatchRepository.findByPostFalse();
        model.addAttribute("rBatch", receiptBtch);

        String batchId =receiptBatch.getBatchId();

        List <VerifyReceipt> verifyReceipt = verifyReceiptRepository.findAllByBatchId(batchId);
        if(verifyReceipt ==null){
            model.addAttribute("error", "No record found");
            return "receipting/receipts/verifyReceipt";
        }
        float amount = verifyReceiptRepository.selectTotals(batchId);

        DecimalFormat df = new DecimalFormat("0.00");
        String amnt = df.format(amount);
        model.addAttribute("amnt", amnt);

        model.addAttribute("verifyReceipt", verifyReceipt);

        ReceiptBatch rcptBatch = receiptBatchRepository.findByBatchId(batchId);
        String username = rcptBatch.getUsername();
        model.addAttribute("rcptBatch", rcptBatch);

        return "receipting/receipts/verifyReceiptResult";

    }

    @RequestMapping(path="verifyReceipt/{id}", method = RequestMethod.GET)
    public String postReceipts(@PathVariable("id") Long id, VerifyReceipt verifyReceipt,BindingResult result, Model model){

        verifyReceipt = verifyReceiptRepository.findById(id);

        Boolean posted  = verifyReceipt.getPosted();

        verifyReceipt.setPosted(true);

        verifyReceiptService.updateReceiptStatus(posted);

       // System.out.println(verifyReceipt);

        //System.out.println(posted);
        
        return "redirect:/receipting/receipt/verifyReceiptForm";
    }

}
