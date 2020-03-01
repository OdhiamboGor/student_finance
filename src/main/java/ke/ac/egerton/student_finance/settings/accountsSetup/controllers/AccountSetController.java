package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSetRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountStructureRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountSetService;
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
@RequestMapping(path = "settings/accountSet")
public class AccountSetController {

    //Autowired Repositories
    @Autowired
    AccountSetRepository acccountSetRepository;
    @Autowired
    AccountStructureRepository accountStructureRepository;

    //Autowired services
    @Autowired
    AccountSetService accountSetService;

    @RequestMapping(path = "accountSetList", method = RequestMethod.GET)
    public String accountSetList(Model model){
        List<AccountSet> account = acccountSetRepository.findAll();
        model.addAttribute("account", account);
        return "settings/accountSet/account";

    }
    @RequestMapping(path = "addAccountSet", method = RequestMethod.GET)
    public String addAccountSet(Model model){
        List<AccountStructure> accountStructure =accountStructureRepository.findAll();
        model.addAttribute("accountStructure", accountStructure);
        return "settings/accountSet/addAccountSet";
    }

    @RequestMapping(path="addAccountSet", method = RequestMethod.POST)
    public String saveAccountSet(@Valid @ModelAttribute("accountSet") AccountSet accountSet, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/accountSet/addAccountSet";
        }
        model.addAttribute("accountSet", new AccountSet());
        accountSetService.saveAccountSet(accountSet);
        return "redirect:/settings/accountSet/accountSetList";
    }

    @RequestMapping(path="/editAccountSet/{id}", method = RequestMethod.GET)
    public String editAccountSet(@PathVariable("id") long id, Model model){
        AccountSet accountSet = accountSetService.getAccountSetById(id);
        List<AccountStructure> accountStructure =accountStructureRepository.findAll();
        model.addAttribute("accountStructure", accountStructure);
        model.addAttribute("accountSet", accountSet);
        return "settings/accountSet/editAccountSet";
    }
}
