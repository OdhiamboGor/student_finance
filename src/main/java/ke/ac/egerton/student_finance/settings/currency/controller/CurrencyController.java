package ke.ac.egerton.student_finance.settings.currency.controller;

import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.currency.service.CurrencyService;
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
@RequestMapping(path = "settings/currency")
public class CurrencyController {

    //Autowired Repositories
    @Autowired
    CurrencyRepository currencyRepository;


    //AutoWired Services
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(path ="currencyList", method = RequestMethod.GET)
    public String currencyList(Model model){
       List<Currency> currencies = currencyRepository.findAll();
        model.addAttribute("currency", currencies);
        return "settings/currency/currency";
    }

    @RequestMapping(path="addCurrency", method = RequestMethod.GET)
    public String addCurrency(){
        return "settings/currency/addCurrency";
    }

    @RequestMapping(path="addCurrency", method = RequestMethod.POST)
    public String saveCurrency(@Valid @ModelAttribute("currency") Currency currency, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/currency/addCurrency";
        }
            model.addAttribute("currency", new Currency());

            currencyService.saveCurrency(currency);
            return "redirect:/settings/currency/currencyList";

    }
    @RequestMapping(path="/editCurrency/{id}", method = RequestMethod.GET)
    public String editCurrency(@PathVariable("id") long id, Model model){
        Currency currency = currencyService.getCurrencyById(id);
        model.addAttribute("currency", currency);
        return "settings/currency/editCurrency";
    }
    @RequestMapping(path="/updateCurrency/{id}", method = RequestMethod.POST)
    public String updateCurrency(@PathVariable("id") long id, @Valid Currency currency, BindingResult result, Model model){

        if (result.hasErrors()) {
            currency.setId(id);
            return "/editCurrency";
        }

        currencyService.saveCurrency(currency);
        return "redirect:/settings/currency/currencyList";
    }

}
