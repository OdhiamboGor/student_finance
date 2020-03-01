package ke.ac.egerton.student_finance.settings.coreSetup.controllers;

import ke.ac.egerton.models.academic.StudentCategory;
import ke.ac.egerton.models.dao.academic.StudentCategoryRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FeePaymentPlanRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.FeePaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ke.ac.egerton.student_finance.settings.coreSetup.models.FeePaymentPlan;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "settings/feesPaymentPlan")
public class FeePaymentPlanController {

    //Autowired Repositories
    @Autowired
    FeePaymentPlanRepository feePaymentPlanRepository;
    @Autowired
    StudentCategoryRepository studentCategoryRepository;

    //Autowired Services
    @Autowired
    FeePaymentPlanService feePaymentPlanService;

    @RequestMapping(path = "paymentPLan", method= RequestMethod.GET)
    public String paymentPlan(Model model){
        List <FeePaymentPlan> plan = feePaymentPlanRepository.findAll();
        List<StudentCategory> category = studentCategoryRepository.findAll();
        model.addAttribute("plan", plan);
        model.addAttribute("category", category);
        return "settings/coreSetup/paymentPlan";
    }

    @RequestMapping(value = "addPaymentPlan", method = RequestMethod.GET)
    public String addPaymentPlan(FeePaymentPlan feePaymentPlan, Model model){
        model.addAttribute("categories", studentCategoryRepository.findAll());
        return "settings/coreSetup/addPaymentPlan";
    }

    @RequestMapping(path="addPaymentPlan", method = RequestMethod.POST)
    public String savePaymentPlan(@Valid @ModelAttribute("feePaymentPlan") FeePaymentPlan feePaymentPlan, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/addFeePaymentPlan";
        }
        model.addAttribute("feePaymentPlan", new FeePaymentPlan());

        feePaymentPlanService.saveFeePaymentPlan(feePaymentPlan);
        return "redirect:/settings/feesPaymentPlan/paymentPLan";
    }
    @RequestMapping(path="/editFeePaymentPlan/{id}", method = RequestMethod.GET)
    public String editFeePaymentPlan(@PathVariable("id") long id, Model model){
        FeePaymentPlan feePaymentPlan = feePaymentPlanService.getFeePaymentPlanById(id);
        model.addAttribute("category", studentCategoryRepository.findAll());
        model.addAttribute("feePaymentPlan", feePaymentPlan);
        return "settings/coreSetup/editFeePaymentPlan";
    }

    @RequestMapping(path="/updateFeePaymentPlan/{id}", method = RequestMethod.POST)
    public  String updateFeePaymentPlan(@PathVariable("id") long id, @Valid FeePaymentPlan feePaymentPlan, BindingResult result, Model model){
        if (result.hasErrors()) {
            feePaymentPlan.setId(id);
            return "/editFeePaymentPlan";
        }

        feePaymentPlanService.saveFeePaymentPlan(feePaymentPlan);
        return "redirect:/settings/feesPaymentPlan/paymentPLan";

    }

}
