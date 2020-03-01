package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSegment;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSegmentRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountSegmentService;
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
@RequestMapping(path = "settings/accountSegment")
public class AccountSegmentController {

    //Autowired Repositories
    @Autowired
    AccountSegmentRepository accountSegmentRepository;

    //Autowired Service
    @Autowired
    AccountSegmentService accountSegmentService;

    @RequestMapping(path = "accountSegmentList", method = RequestMethod.GET)
    public String accountSegmentList(Model model){
        List<AccountSegment> segment = accountSegmentRepository.findAll();
        model.addAttribute("segment", segment);
        return "settings/accountSetup/segment";
    }

    @RequestMapping(path = "addAccountSegment", method = RequestMethod.GET)
    public String addAccountSegment(){
        return "settings/accountSetup/addAccountSegment";
    }

    @RequestMapping(path = "addAccountSegment", method = RequestMethod.POST)
    public String saveAccountSegment(@Valid @ModelAttribute("accountSegment") AccountSegment accountSegment, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/AccountSegment/addAccountSegment";
        }
        model.addAttribute("accountSegment", new AccountSegment());
        accountSegmentService.saveAccountSegment(accountSegment);
        return "redirect:/settings/accountSegment/accountSegmentList";
    }

    @RequestMapping(path="/editAccountSegment/{id}", method = RequestMethod.GET)
    public String editAccountSegment(@PathVariable("id") Long id, Model model) {
        AccountSegment accountSegment = accountSegmentService.getAccountSegmentById(id);
        model.addAttribute("accountSegment", accountSegment);
        return "settings/accountSetup/editAccountSegment";
    }

    @RequestMapping(path="/editAccountSegment/{id}", method = RequestMethod.POST)
    public String updateAccountSegment(@PathVariable("id") long id, @Valid AccountSegment accountSegment, BindingResult result, Model model){

        if (result.hasErrors()) {
            accountSegment.setId(id);
            return "/settings/accountSegment/editAccountSegment";
        }
        accountSegmentService.saveAccountSegment(accountSegment);
        return "redirect:/settings/accountSegment/accountSegmentList";
    }


}
