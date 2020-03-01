package ke.ac.egerton.student_finance.settings.receipts.controllers;

import ke.ac.egerton.student_finance.settings.receipts.models.CancelReason;
import ke.ac.egerton.student_finance.settings.receipts.repositories.CancelReasonRepository;
import ke.ac.egerton.student_finance.settings.receipts.services.CancelReasonService;
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
@RequestMapping(path = "settings/cancelReason")
public class CancelReasonController {

    //Autowired Repositories
    @Autowired
    CancelReasonRepository cancelReasonRepository;

    //Autowired Services
    @Autowired
    CancelReasonService cancelReasonService;

    @RequestMapping(path = "cancelReasonList", method = RequestMethod.GET)
    public String cancelReasonList(Model model){
        List<CancelReason> cancelReason =  cancelReasonRepository.findAll();
        model.addAttribute("cancelReason", cancelReason);
        return "settings/receipts/reasons";
    }

    @RequestMapping(path = "addCancelReason", method = RequestMethod.GET)
    public String addCancelReason(){
        return "settings/receipts/addCancelReason";
    }

    @RequestMapping(path = "addCancelReason", method = RequestMethod.POST)
    public String saveCancelReason(@Valid @ModelAttribute("cancelReason") CancelReason cancelReason, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/cancelReason/addCancelReason";
        }
        model.addAttribute("cancelReason", new CancelReason());
        cancelReasonService.saveCancelReason(cancelReason);
        return "redirect:/settings/cancelReason/cancelReasonList";
    }

    @RequestMapping(path="editCancelReason/{id}", method = RequestMethod.GET)
    public String editCancelReason(@PathVariable("id") long id, Model model){
        CancelReason cancelReason = cancelReasonRepository.findOne(id);
        model.addAttribute("cancelReason", cancelReason);
        return "settings/receipts/editCancelReason";
    }

    @RequestMapping(path="editCancelReason/{id}", method = RequestMethod.POST)
    public String updateCancelReason(@PathVariable("id") long id, @Valid CancelReason cancelReason, BindingResult result, Model model){
        if (result.hasErrors()) {
            cancelReason.setId(id);
            return "redirect:/settings/cancelReason/editCancelReason";
        }

        cancelReasonService.saveCancelReason(cancelReason);
        return "redirect:/settings/cancelReason/cancelReasonList";
    }

    @RequestMapping(path = "deleteCancelReason/{id}", method = RequestMethod.GET)
    public String deleteCancelReason(@PathVariable("id") long id, Model model){
        CancelReason cancelReason = cancelReasonRepository.findOne(id);
        if(cancelReason==null){
            model.addAttribute("error", "No Record found");
        }
        cancelReasonService.deleteCancelReason(cancelReason);
        return "redirect:/settings/cancelReason/cancelReasonList";
    }
}
