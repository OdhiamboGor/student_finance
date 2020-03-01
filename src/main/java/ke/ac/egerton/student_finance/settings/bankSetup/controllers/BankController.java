package ke.ac.egerton.student_finance.settings.bankSetup.controllers;

import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankRepository;
import ke.ac.egerton.student_finance.settings.bankSetup.service.BankService;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.ReceiptTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "settings/banks")
public class BankController {

    //Autowired repositories
    @Autowired
    BankRepository bankRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;
    @Autowired
    ReceiptTypeRepository receiptTypeRepository;


    //Autowired Services
    @Autowired
    BankService bankService;

    @RequestMapping(path ="bankList", method = RequestMethod.GET)
    public String bankList(Model model){
        List<Bank> banks = bankRepository.findAll();
        model.addAttribute("banks", banks);
        return "settings/bankSetup/bank";
    }

    @RequestMapping(path="addBank", method = RequestMethod.GET)
    public String addBank(Model model){
        model.addAttribute("gateway", paymentGatewayRepository.findAll());
        model.addAttribute("currency",currencyRepository.findAll());
        model.addAttribute("receiptType",receiptTypeRepository.findAll());
        return "settings/bankSetup/addBank";
    }

    @RequestMapping(path="addBank", method = RequestMethod.POST)
    public String saveBank (@Valid @ModelAttribute("bank") Bank bank, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/banks/addBank";
        }
        model.addAttribute("bank", new Bank());
        bankService.saveBank(bank);
        return "redirect:/settings/banks/bankList";
    }

    @RequestMapping(path="/editBank/{id}", method = RequestMethod.GET)
    public String editBank(@PathVariable("id") long id, Model model){
        Bank bank = bankService.getBankById(id);
        model.addAttribute("bank", bank);
        model.addAttribute("gateway", paymentGatewayRepository.findAll());
        model.addAttribute("currency",currencyRepository.findAll());
        model.addAttribute("receiptType",receiptTypeRepository.findAll());
        return "settings/bankSetup/editBank";
    }

    @RequestMapping(path="/updateBank/{id}", method = RequestMethod.POST)
    public String updateBank(@PathVariable("id") long id, @Valid Bank bank, BindingResult result, Model model){
        if (result.hasErrors()) {
            bank.setId(id);
            return "redirect:/settings/banks/editBank";
        }

        bankService.saveBank(bank);
        return "redirect:/settings/banks/bankList";
    }

}
