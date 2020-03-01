package ke.ac.egerton.student_finance.settings.bankSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSetRepository;
import ke.ac.egerton.student_finance.settings.bankSetup.models.BankApi;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankApiRepository;
import ke.ac.egerton.student_finance.settings.bankSetup.service.BankApiService;
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
@RequestMapping(path = "settings/bankApi")
public class BankApiController {

    //Autowired Repositories
    @Autowired
    BankApiRepository bankApiRepository;
    @Autowired
    AccountSetRepository accountSetRepository;

    //Autowired Services
    @Autowired
    BankApiService bankApiService;

    @RequestMapping(path = "bankApiList", method = RequestMethod.GET)
    public String bankApiList(Model model){
        List<BankApi> api = bankApiRepository.findAll();
        model.addAttribute("api", api);
        return "settings/bankSetup/api";
    }

    @RequestMapping(path = "addBankApi", method = RequestMethod.GET)
    public String addBankApi(Model model){
        List<AccountSet> accountSet = accountSetRepository.findAll();
        model.addAttribute("accountSet", accountSet);
        return "/settings/bankSetup/addBankApi";
    }

    @RequestMapping(path="addBankApi", method = RequestMethod.POST)
    public String saveBankApi(@Valid @ModelAttribute("bankApi") BankApi bankApi, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/bankApi/addBankApi";
        }
        model.addAttribute("bankApi", new BankApi());
        bankApiService.saveBankApi(bankApi);
        return "redirect:/settings/bankApi/bankApiList";
    }

    @RequestMapping(path="/editBankApi/{id}", method = RequestMethod.GET)
    public String editBankApi(@PathVariable("id") long id, Model model){
        BankApi bankApi = bankApiService.getBankApiById(id);
        List<AccountSet> accountSet = accountSetRepository.findAll();
        model.addAttribute("bankApi", bankApi);
        model.addAttribute("accountSet", accountSet);
        return "settings/bankSetup/editBankApi";
    }

    @RequestMapping(path="/updateBankApi/{id}", method = RequestMethod.POST)
    public String updateBankApi(@PathVariable("id") long id, @Valid BankApi bankApi, BindingResult result, Model model){

        if (result.hasErrors()) {
            bankApi.setId(id);
            return "redirect:/settings/bankApi/editBankApi";
        }
        bankApiService.saveBankApi(bankApi);
        return "redirect:/settings/bankApi/bankApiList";

    }
}