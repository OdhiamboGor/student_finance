package ke.ac.egerton.student_finance.settings.currency.controller;

import ke.ac.egerton.student_finance.settings.currency.model.ExchangeRate;
import ke.ac.egerton.student_finance.settings.currency.repository.ExchangeRateRepository;
import ke.ac.egerton.student_finance.settings.currency.service.ExchangeRateService;
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
@RequestMapping(path = "settings/exchangeRate")
public class ExchangeRateController {

    //Autowired Repositories
    @Autowired
    ExchangeRateRepository exchangeRateRepository;


    //AutoWired Services
    @Autowired
    ExchangeRateService exchangeRateService;


    @RequestMapping(path = "exchangeRateList", method = RequestMethod.GET)
    public String exchangeRateList(Model model){
        List<ExchangeRate> rate = exchangeRateRepository.findAll();
        model.addAttribute("rates", rate);
        return "settings/currency/rates";
    }

    @RequestMapping(path="addExchangeRate", method = RequestMethod.GET)
    public  String addExchangeRate(Model model){
        List <ExchangeRate> exchangeRate = exchangeRateRepository.findAll();
        model.addAttribute("rate", exchangeRate);
        return "settings/currency/addExchangeRate";
    }

    @RequestMapping(path="addExchangeRate", method = RequestMethod.POST)
    public String saveExchangeRate(@Valid @ModelAttribute("exchangeRate") ExchangeRate exchangeRate, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/exchangeRate/addExchangeRate";
        }
        model.addAttribute("exchangeRate", new ExchangeRate());

        exchangeRateService.saveExchangeRate(exchangeRate);
        return "redirect:/settings/exchangeRate/exchangeRateList";
    }

    @RequestMapping(path="/editExchangeRate/{id}", method = RequestMethod.GET)
    public String editExchangeRate(@PathVariable("id") long id, Model model){
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRateById(id);
        model.addAttribute("exchangeRate",exchangeRate);
        return "settings/currency/editExchangeRate";

    }

    @RequestMapping(path="/updateExchangeRate/{id}", method = RequestMethod.POST)
    public String updateExchangeRate(@PathVariable("id") long id, @Valid ExchangeRate exchangeRate, BindingResult result, Model model){
        if (result.hasErrors()) {
            exchangeRate.setId(id);
            return "/editExchangeRate";
        }

        exchangeRateService.saveExchangeRate(exchangeRate);
        return "redirect:/settings/exchangeRate/exchangeRateList";
    }
}
