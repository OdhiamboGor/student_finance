package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountGroup;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountGroupRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountGroupService;
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
@RequestMapping(path = "settings/accountGroup")
public class AccountGroupController {

    //Autowired Repositories
    @Autowired
    AccountGroupRepository accountGroupRepository;

    //Autowired Services
    @Autowired
    AccountGroupService accountGroupService;

    @RequestMapping(path = "accountGroupList", method = RequestMethod.GET)
    public String accountGroupList(Model model){
        List<AccountGroup> group =  accountGroupRepository.findAll();
       model.addAttribute("group", group);
        return "settings/accountSetup/accountGroup";
    }

    @RequestMapping(path = "addAccountGroup", method = RequestMethod.GET)
    public String addAccountGroup(){
        return "settings/accountSetup/addAccountGroup";
    }

    @RequestMapping(path="addAccountGroup", method = RequestMethod.POST)
    public String saveAccountGroup(@Valid @ModelAttribute("accountSet") AccountGroup accountGroup, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "redirect:/settings/accountGroup/addAccountGroup";
        }
        model.addAttribute("accountGroup", new AccountGroup());
        accountGroupService.saveAccountGroup(accountGroup);
        return "redirect:/settings/accountGroup/accountGroupList";
    }

    @RequestMapping(path="/editAccountGroup/{id}", method = RequestMethod.GET)
    public String editAccountGroup(@PathVariable("id") long id, Model model){
        AccountGroup accountGroup = accountGroupService.getAccountGroupById(id);
        model.addAttribute("accountGroup", accountGroup);
        return "settings/accountSetup/editAccountGroup";
    }

    @RequestMapping(path="/updateAccountGroup/{id}", method = RequestMethod.POST)
    public String updateAccountGroup(@PathVariable("id") long id, @Valid AccountGroup accountGroup, BindingResult result, Model model){
        if (result.hasErrors()) {
            accountGroup.setId(id);
            return "redirect:/settings/accountGroup/editAccountGroup";
        }
        accountGroupService.saveAccountGroup(accountGroup);
        return "redirect:/settings/accountGroup/accountGroupList";
    }
}
