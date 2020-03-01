package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.payment.controllers.validation.PaymentGatewayDetails;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentModeRepository;
import ke.ac.egerton.student_finance.settings.payment.services.PaymentGatewayService;
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
@RequestMapping(path = "settings/paymentGateway")
public class PaymentGatewayController {

    //Autowired Repositories
    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;
    @Autowired
    PaymentModeRepository paymentModeRepository;
    @Autowired
    CurrencyRepository currencyRepository;


    //Autowired Services
    @Autowired
    PaymentGatewayService paymentGatewayService;


    @RequestMapping(path = "paymentGatewayList", method = RequestMethod.GET)
    public String paymentGatewayList(Model model){
        List<PaymentGateway> paymentGateway = paymentGatewayRepository.findAll();
        model.addAttribute("paymentGateway", paymentGateway);
        return "settings/payment/gateway";
    }

    @RequestMapping(path = "addPaymentGateway", method = RequestMethod.GET)
    public String addPaymentGateway(Model model){
        List<PaymentMode> paymentMode = paymentModeRepository.findAll();
        List<Currency> currency = currencyRepository.findAll();

        model.addAttribute("paymentMode", paymentMode);
        model.addAttribute("currency", currency);
        return "settings/payment/addPaymentGateway";
    }

    @RequestMapping(path="addPaymentGateway", method = RequestMethod.POST)
    public String savePaymentGateway(@Valid @ModelAttribute("details") PaymentGatewayDetails details, BindingResult result, Model model){

        String cod = details.getCode();
        String nam = details.getName();
        String mode = details.getPaymentMode();
        String curr = details.getCurrency();
        Boolean pesa = details.getMpesa();
        Boolean pay = details.getPayBill();
        Boolean ppl = details.getPayPal();
        Boolean bank = details.getBank();

        PaymentMode payMode = paymentModeRepository.findByCode(mode);
        Currency curren = currencyRepository.findByCode(curr);

        PaymentGateway paymentGateway = new PaymentGateway();

        paymentGateway.setCode(cod);
        paymentGateway.setName(nam);
        paymentGateway.setPaymentMode(payMode);
        paymentGateway.setCurrency(curren);
        paymentGateway.setMpesa(pesa);
        paymentGateway.setPayBill(pay);
        paymentGateway.setPayPal(ppl);
        paymentGateway.setBank(bank);

        paymentGatewayService.savePaymentGateway(paymentGateway);

        return "redirect:/settings/paymentGateway/paymentGatewayList";
    }

    @RequestMapping(path="editPaymentGateway/{id}", method = RequestMethod.GET)
    public String editPaymentGateway(@PathVariable("id") long id, Model model){

        PaymentGateway paymentGateway = paymentGatewayRepository.findOne(id);

        List <PaymentMode> paymentMode = paymentModeRepository.findAll();
        List<Currency> currency = currencyRepository.findAll();

        model.addAttribute("paymentGateway", paymentGateway);
        model.addAttribute("paymentMode", paymentMode);

        model.addAttribute("currency", currency);

        return "settings/payment/editPaymentGateway";
    }

    @RequestMapping(path="editPaymentGateway/{id}", method = RequestMethod.POST)
    public String updatePaymentMode(@PathVariable("id") long id, @Valid PaymentGatewayDetails details, BindingResult result, Model model){

        PaymentGateway paymentGateway = paymentGatewayRepository.findOne(id);

        String cod = details.getCode();
        String nam = details.getName();
        String mode = details.getPaymentMode();
        String curr = details.getCurrency();
        Boolean pesa = details.getMpesa();
        Boolean pay = details.getPayBill();
        Boolean ppl = details.getPayPal();
        Boolean bank = details.getBank();

        System.out.println(cod);
        System.out.println(nam);
        System.out.println(mode);
        System.out.println(curr);
        System.out.print(pesa);
        System.out.print(pay);
        System.out.print(ppl);
        System.out.print(bank);
        System.out.println();

        PaymentMode payMode = paymentModeRepository.findByCode(mode);
        Currency curren = currencyRepository.findByCode(curr);

        paymentGateway.setCode(cod);
        paymentGateway.setName(nam);
        paymentGateway.setMpesa(pesa);
        paymentGateway.setPaymentMode(payMode);
        paymentGateway.setCurrency(curren);
        paymentGateway.setPayBill(pay);
        paymentGateway.setPayPal(ppl);
        paymentGateway.setBank(bank);

        paymentGatewayService.savePaymentGateway(paymentGateway);

        return "redirect:/settings/payment/paymentGatewayList";
    }
}
