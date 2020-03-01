package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import ke.ac.egerton.student_finance.settings.payment.repository.PayeeGroupRepository;
import ke.ac.egerton.student_finance.settings.payment.services.PayeeGroupService;
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
@RequestMapping(path = "settings/payeeGroup")
public class PayeeGroupController {

    //Autowired Repositories
    @Autowired
    PayeeGroupRepository payeeGroupRepository;

    //Autowired Services
    @Autowired
    PayeeGroupService payeeGroupService;


    @RequestMapping(path = "payeeGroupList", method = RequestMethod.GET)
    public String payeeGroupList(Model model){
        List<PayeeGroup> group = payeeGroupRepository.findAll();
        model.addAttribute("group", group);
        return "settings/payment/payeeGroup";
    }

    @RequestMapping(path = "addPayeeGroup", method = RequestMethod.GET)
    public String addPayeeGroup(){
        return "settings/payment/addPayeeGroup";
    }

    @RequestMapping(path = "addPayeeGroup", method = RequestMethod.POST)
    public String savePayeeGroup(@ModelAttribute("payeeGroup") PayeeGroup payeeGroup, BindingResult result, Model model){
        String code = payeeGroup.getCode();
        String des = payeeGroup.getName();
        Boolean st = payeeGroup.getStudent();
        Boolean alm = payeeGroup.getAlumni();
        Boolean hs = payeeGroup.getAccountSets();


        if (result.hasErrors()) {
            return "redirect:/settings/payeeGroup/addPayeeGroup";
        }
        model.addAttribute("payeeGroup", new PayeeGroup());
        payeeGroupService.savePayeeGroup(payeeGroup);
        return "redirect:/settings/payeeGroup/payeeGroupList";
    }

    @RequestMapping(path="editPayeeGroup/{id}", method = RequestMethod.GET)
    public String editPayeeGroup(@PathVariable("id") long id, Model model){
        PayeeGroup payeeGroup = payeeGroupRepository.findOne(id);
        model.addAttribute("payeeGroup", payeeGroup);
        return "settings/payment/editPayeeGroup";
    }

    @RequestMapping(path="editPayeeGroup/{id}", method = RequestMethod.POST)
    public String updatePayeeGroup(@PathVariable("id") long id, @Valid PayeeGroup payeeGroup, BindingResult result, Model model){
        if (result.hasErrors()) {
            payeeGroup.setId(id);
            return "settings/payeeGroup/editPayeeGroup";
        }
        payeeGroupService.savePayeeGroup(payeeGroup);
        return "redirect:/settings/payeeGroup/payeeGroupList";
    }
}
