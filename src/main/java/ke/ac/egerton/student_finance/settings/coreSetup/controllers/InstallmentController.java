package ke.ac.egerton.student_finance.settings.coreSetup.controllers;

import ke.ac.egerton.student_finance.settings.coreSetup.models.Installment;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.InstallmentRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.InstallmentService;
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
@RequestMapping(path = "settings/installment")
public class InstallmentController {

    //Autowired Repositories
    @Autowired
    InstallmentRepository installmentRepository;

    //Autowired Services
    @Autowired
    InstallmentService installmentService;

    @RequestMapping(path = "installmentList", method = RequestMethod.GET)
    public String installmentList(Model model){
        List<Installment> installment = installmentRepository.findAll();
        model.addAttribute("installment", installment);
        return "settings/coreSetup/installment";
    }

    @RequestMapping(path="addInstallment", method = RequestMethod.GET)
    public String addInstallment(){
        return "/settings/coreSetup/addInstallment";
    }

    @RequestMapping(path="addInstallment", method = RequestMethod.POST)
    public String saveInstallment(@Valid @ModelAttribute("installment") Installment installment, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "settings/installment/addInstallment";
        }
        model.addAttribute("installment", new Installment());
        installmentService.saveInstallment(installment);
        return "redirect:/settings/installment/installmentList";
    }

    @RequestMapping(path="/editInstallment/{id}", method = RequestMethod.GET)
    public String editInstallment(@PathVariable("id") long id, Model model){
        Installment installment = installmentService.getInstallmentById(id);
        model.addAttribute("installment", installment);
        return "settings/coreSetup/editInstallment";
    }

    @RequestMapping(path="/updateInstallment/{id}", method = RequestMethod.POST)
    public String updateInstallment(@PathVariable("id") long id, @Valid Installment installment, BindingResult result, Model model){
        if (result.hasErrors()) {
            installment.setId(id);
            return "redirect:/settings/installment/editInstallment";
        }
        installmentService.saveInstallment(installment);
        return "redirect:/settings/installment/installmentList";
    }
}
