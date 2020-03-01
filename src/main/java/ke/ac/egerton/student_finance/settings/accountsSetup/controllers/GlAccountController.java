package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.controllers.validation.GlAccountDetails;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountGroup;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.GlAccount;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountGroupRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountStructureRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.GlAccountRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.GlAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path= "settings/glAccount")
public class GlAccountController {

    //Autowired Repositories
    @Autowired
    GlAccountRepository glAccountRepository;
    @Autowired
    AccountStructureRepository accountStructureRepository;
   @Autowired
    AccountGroupRepository accountGroupRepository;

    //Autowired Services
    @Autowired
    GlAccountService glAccountService;


    @RequestMapping(path = "glAccountList", method = RequestMethod.GET)
    public String glAccountList(Model model){
        List<GlAccount> accounts = glAccountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "settings/accountSetup/glAccount";
    }

    @RequestMapping(path = "addGlAccount", method = RequestMethod.GET)
    public String addGlAccount(Model model){
        List<AccountStructure> accountStructure = accountStructureRepository.findAll();
        List<AccountGroup> accountGroup = accountGroupRepository.findAll();
        model.addAttribute("accountStructure", accountStructure);
        model.addAttribute("accountGroup", accountGroup);

        return "settings/accountSetup/addGlAccount";
    }

    @RequestMapping(path="addGlAccount", method = RequestMethod.POST)
    public String saveGlAccount(@Valid @ModelAttribute("details") GlAccountDetails details, BindingResult result, Model model){

        String number = details.getNumber();
        String name = details.getName();
        String acc = details.getAccountType();
        String str = details.getAccountStructure().toString();
        String gr =details.getAccountGroup();
        Boolean ac = details.getActive();

        GlAccount glAccount  = new GlAccount();

        glAccount.setNumber(number);
        glAccount.setName(name);
        glAccount.setActive(ac);
        glAccount.setAccountType(acc);
/*        glAccount.setAccountStructure(str);
        glAccount.setAccountGroup(gr);*/

        if (result.hasErrors()) {
            return "redirect:/settings/glAccount/addGlAccount";
        }
        model.addAttribute("glAccount", new GlAccount());

        glAccountService.saveGlAccount(glAccount);
        return "redirect:/settings/glAccount/glAccountList";

    }

    @RequestMapping(path="/editGlAccount/{id}", method = RequestMethod.GET)
    public String editGlAccount(@PathVariable("id") long id, Model model){
        GlAccount glAccount = glAccountService.getGlAccountById(id);
        List<AccountStructure> structures = accountStructureRepository.findAll();
        List<AccountGroup> groups = accountGroupRepository.findAll();
        model.addAttribute("glAccount", glAccount);
        model.addAttribute("structures", structures);
        model.addAttribute("groups", groups);
        return "settings/accountSetup/editGlAccount";
    }

    @RequestMapping(path="/updateGlAccount/{id}", method = RequestMethod.POST)
    public String updateGlAccount(@PathVariable("id") long id, @Valid GlAccountDetails details, BindingResult result, Model model) {

        GlAccount glAccount1 = glAccountService.getGlAccountById(id);
        if (glAccount1 == null) {

            String num = details.getNumber();
            String name = details.getName();
            String acc = details.getAccountType();
            String str = details.getAccountStructure().toString();
            String gr = details.getAccountGroup();
            Boolean ac = details.getActive();

            GlAccount glAccount = new GlAccount();

            glAccount.setNumber(num);
            glAccount.setName(name);
            glAccount.setActive(ac);
            glAccount.setAccountType(acc);

            glAccountService.saveGlAccount(glAccount);

        }
        return "redirect:/settings/glAccount/glAccountList";
    }
}
