package ke.ac.egerton.student_finance.settings.receipts.controllers;

import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReceiptingCriteriaRepository;
import ke.ac.egerton.student_finance.settings.receipts.services.ReceiptingCriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "settings/receiptCriteria")
public class ReceiptingCriteriaController {

    //Autowired Repositories
    @Autowired
    ReceiptingCriteriaRepository receiptingCriteriaRepository;

    //Autowired Services
    @Autowired
    ReceiptingCriteriaService receiptingCriteriaService;


    @RequestMapping(path = "receiptCriteriaList", method = RequestMethod.GET)
    public String receiptCriteriaList(Model model){
        List<ReceiptingCriteria> criteria = receiptingCriteriaRepository.findAll();
        model.addAttribute("criteria", criteria);
        return "settings/receipts/criteria";
    }

    @RequestMapping(path = "addReceiptCriteria", method = RequestMethod.GET)
    public String addReceiptCriteria(){
        return "settings/receipts/addReceiptCriteria";
    }

    @RequestMapping(path = "addReceiptCriteria", method = RequestMethod.POST)
    public String saveReceiptingCriteria(@Valid @ModelAttribute("receiptingCriteria") ReceiptingCriteria receiptingCriteria, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/receiptCriteria/addReceiptCriteria";
        }
        model.addAttribute("receiptingCriteria", new ReceiptingCriteria());
        receiptingCriteriaService.saveReceiptingCriteria(receiptingCriteria);
        return "redirect:/settings/receiptCriteria/receiptCriteriaList";
    }

    @RequestMapping(path="editReceiptCriteria/{id}", method = RequestMethod.GET)
    public String editReceiptCriteria(@PathVariable("id") long id, Model model){
        ReceiptingCriteria criteria = receiptingCriteriaRepository.findOne(id);
        model.addAttribute("criteria", criteria);
        return "settings/receipts/editReceiptCriteria";
    }


    @RequestMapping(path="editReceiptCriteria/{id}", method = RequestMethod.POST)
    public String updateReceiptCriteria(@PathVariable("id") long id, @Valid ReceiptingCriteria criteria, BindingResult result, Model model) {


        String sys = criteria.getSysCode();
        String cod = criteria.getCode();
        String nam = criteria.getName();
        Boolean def = criteria.getDefaultValue();

        System.out.print(sys);
        System.out.print(cod);
        System.out.print(nam);
        System.out.print(def);

        if (result.hasErrors()) {
            criteria.setId(id);
            return "redirect:/settings/receiptCriteria/editReceiptCriteria";
        }

        receiptingCriteriaService.updateReceiptingCriteria(criteria);
        return "redirect:/settings/receiptCriteria/receiptCriteriaList";
    }
}
