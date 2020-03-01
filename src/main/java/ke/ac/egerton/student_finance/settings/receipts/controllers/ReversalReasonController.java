package ke.ac.egerton.student_finance.settings.receipts.controllers;

import ke.ac.egerton.student_finance.settings.receipts.models.ReversalReason;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReceiptingCriteriaRepository;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReversalReasonRepository;
import ke.ac.egerton.student_finance.settings.receipts.services.ReversalReasonService;
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
@RequestMapping(path = "settings/reverseReason")
public class ReversalReasonController {

    //Autowired Repositories
    @Autowired
    ReversalReasonRepository reversalReasonRepository;

    //Autowired Services
    @Autowired
    ReversalReasonService reversalReasonService;

    @RequestMapping(path = "reversalReasonList", method = RequestMethod.GET)
    public  String reversalReasonList(Model model){
        List<ReversalReason> reversalReason = reversalReasonRepository.findAll();
        model.addAttribute("reversalReason", reversalReason);
        return "settings/receipts/reversalReason";

    }

    @RequestMapping(path = "addReversalReason", method = RequestMethod.GET)
    public String addReversalReason(){
        return "settings/receipts/addReversalReason";
    }

    @RequestMapping(path = "addReversalReason", method = RequestMethod.POST)
    public String saveReversalReason(@Valid @ModelAttribute("reversalReason") ReversalReason reversalReason, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/reverseReason/addReversalReason";
        }
        model.addAttribute("reversalReason", new ReversalReason());
        reversalReasonService.saveReversalReason(reversalReason);
        return "redirect:/settings/reverseReason/reversalReasonList";
    }

    @RequestMapping(path="editReversalReason/{id}", method = RequestMethod.GET)
    public String editReversalReason(@PathVariable("id") long id, Model model){
        ReversalReason reversalReason = reversalReasonRepository.findOne(id);
        model.addAttribute("reversalReason", reversalReason);
        return "settings/receipts/editReversalReason";
    }

    @RequestMapping(path="editReversalReason/{id}", method = RequestMethod.POST)
    public String updateReversalReason(@PathVariable("id") long id, @Valid ReversalReason reversalReason, BindingResult result, Model model){
        if (result.hasErrors()) {
            reversalReason.setId(id);
            return "redirect:/settings/reverseReason/editReversalReason";
        }
        reversalReasonService.saveReversalReason(reversalReason);
        return "redirect:/settings/reverseReason/reversalReasonList";
    }

    @RequestMapping(path = "deleteReversalReason/{id}", method = RequestMethod.GET)
    public String deleteReversalReason(@PathVariable("id") long id, Model model) {
        ReversalReason reversalReason = reversalReasonRepository.findOne(id);
        if (reversalReason == null) {
            model.addAttribute("error", "No Record found");
        }
        reversalReasonService.updateReversalReason(reversalReason);
        return "redirect:/settings/reverseReason/reversalReasonList";
    }
}


