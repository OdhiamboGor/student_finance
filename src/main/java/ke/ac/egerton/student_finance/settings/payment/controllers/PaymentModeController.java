package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.payment.controllers.validation.PaymentModeDetails;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentMode;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentModeRepository;
import ke.ac.egerton.student_finance.settings.payment.services.PaymentModeService;
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
@RequestMapping(path = "settings/paymentMode")
public class PaymentModeController {

    //Autowired Repositories
    @Autowired
    PaymentModeRepository paymentModeRepository;

    //Autowired Services
    @Autowired
    PaymentModeService paymentModeService;

    @RequestMapping(path = "paymentModeList", method = RequestMethod.GET)
    public String paymentModeList(Model model){
        List<PaymentMode> paymentMode = paymentModeRepository.findAll();
        model.addAttribute("paymentMode", paymentMode);
        return "settings/payment/mode";
    }

    @RequestMapping(path = "addPaymentMode", method = RequestMethod.GET)
    public String addPaymentMode(){
        return "settings/payment/addPaymentMode";
    }

    @RequestMapping(path = "addPaymentMode", method = RequestMethod.POST)
    public String savePaymentMode(@ModelAttribute("paymentMode") PaymentModeDetails details, BindingResult result, Model model){

        String sys = details.getSysCode();
        String cod = details.getCode();
        String nam = details.getName();
        String ref = details.getReference();
        String lbl = details.getLabel();
        String lbd = details.getLabelDate();

        PaymentMode paymentMode =  new PaymentMode();

        paymentMode.setSysCode(sys);
        paymentMode.setCode(cod);
        paymentMode.setName(nam);
        paymentMode.setReference(ref);
        paymentMode.setLabel(lbl);
        paymentMode.setLabelDate(lbd);

        model.addAttribute("paymentMode", new PaymentMode());
        paymentModeService.savePaymentMode(paymentMode);
        return "redirect:/settings/paymentMode/paymentModeList";
    }

    @RequestMapping(path="editPaymentMode/{id}", method = RequestMethod.GET)
    public String editPaymentMode(@PathVariable("id") long id, Model model){
        PaymentMode paymentMode = paymentModeRepository.findOne(id);
        model.addAttribute("paymentMode", paymentMode);
        return "settings/payment/editPaymentMode";
    }

    @RequestMapping(path="editPaymentMode/{id}", method = RequestMethod.POST)
    public String updatePaymentMode(PaymentMode paymentMode, @PathVariable("id") long id, @Valid PaymentModeDetails details, BindingResult result, Model model){
        String sys = details.getSysCode();
        String cod = details.getCode();
        String nam = details.getName();
        String ref = details.getReference();
        String lbl = details.getLabel();
        String lbd = details.getLabelDate();

        paymentMode.setSysCode(sys);
        paymentMode.setCode(cod);
        paymentMode.setName(nam);
        paymentMode.setReference(ref);
        paymentMode.setLabel(lbl);
        paymentMode.setLabelDate(lbd);

        paymentModeService.savePaymentMode(paymentMode);

        return "redirect:/settings/paymentMode/paymentModeList";

    }

}

