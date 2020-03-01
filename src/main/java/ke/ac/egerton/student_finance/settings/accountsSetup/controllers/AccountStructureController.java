package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountStructureRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountStructureService;
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
@RequestMapping(path = "settings/accountStructure")
public class AccountStructureController {

    //Autowired Repositories
    @Autowired
    AccountStructureRepository accountStructureRepository;


    //Autowired Services
    @Autowired
    AccountStructureService accountStructureService;

    @RequestMapping(path = "accountStructureList", method = RequestMethod.GET)
    public  String accountStructureList(Model model ){
        List<AccountStructure> structure = accountStructureRepository.findAll();
        model.addAttribute("structure", structure);
        return "settings/accountSetup/structure";
    }

    @RequestMapping(path = "addAccountStructure", method = RequestMethod.GET)
    public String addAccountStructure(){
        return "Settings/accountSetup/addAccountStructure";
    }

    @RequestMapping(path="addAccountStructure", method = RequestMethod.POST)
    public String saveAccountStructure(@Valid @ModelAttribute("accountStructure") AccountStructure accountStructure, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/accountStructure/addAccountStructure";
        }
        model.addAttribute("accountStructure", new AccountStructure());
        accountStructureService.saveAccountStructure(accountStructure);
        return "redirect:/settings/accountStructure/accountStructureList";
    }

    @RequestMapping(path="/editAccountStructure/{id}", method = RequestMethod.GET)
    public String editAccountStructure(@PathVariable("id") long id, Model model){
        AccountStructure accountStructure = accountStructureRepository.findOne(id);
        model.addAttribute("accountStructure", accountStructure);
        return "settings/accountSetup/editAccountStructure";
    }

    @RequestMapping(path="/editAccountStructure/{id}", method = RequestMethod.POST)
    public String updateAccountStructure(@PathVariable("id") long id, @Valid AccountStructure accountStructure, BindingResult result, Model model){
        if (result.hasErrors()) {
            accountStructure.setId(id);
            return "/settings/accountStructure/editAccountStructure";
        }
        accountStructureService.saveAccountStructure(accountStructure);
        return "redirect:/settings/accountStructure/accountStructureList";
    }

}
