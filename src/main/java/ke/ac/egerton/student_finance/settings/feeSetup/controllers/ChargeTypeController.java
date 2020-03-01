package ke.ac.egerton.student_finance.settings.feeSetup.controllers;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeType;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeTypeRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.ChargeTypeService;
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
@RequestMapping(path = "settings/chargeType")
public class ChargeTypeController {


    //Autowired Repositories
    @Autowired
    ChargeTypeRepository chargeTypeRepository;

    //Autowired Services
    @Autowired
    ChargeTypeService chargeTypeService;

    @RequestMapping(path = "chargeTypeList", method = RequestMethod.GET)
    public String chargeTypeList(Model model){
        List<ChargeType> charge = chargeTypeRepository.findAll();
        model.addAttribute("charge",charge);

        return "settings/feeSetup/chargeType";
    }

    @RequestMapping(path="addChargeType", method = RequestMethod.GET)
    public String addChargeType(){
        return "settings/feeSetup/addChargeType";
    }

    @RequestMapping(path="addChargeType", method = RequestMethod.POST)
    public String saveChargeType(@Valid @ModelAttribute("chargeType") ChargeType chargeType, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/chargeType/addChargeType";
        }
        model.addAttribute("chargeType", new ChargeType());
        chargeTypeService.saveChargeType(chargeType);
        return "redirect:/settings/chargeType/chargeTypeList";
    }

    @RequestMapping(path="editChargeType/{id}", method = RequestMethod.GET)
    public String editChargeType(@PathVariable("id") long id, Model model){
        ChargeType chargeType = chargeTypeRepository.findOne(id);
        model.addAttribute("chargeType", chargeType);
        return "settings/feeSetup/editChargeType";
    }

    @RequestMapping(path="/editChargeType/{id}", method = RequestMethod.POST)
    public String updateChargeType(@PathVariable("id") long id, @Valid ChargeType chargeType, BindingResult result, Model model){

        if (result.hasErrors()) {
            chargeType.setId(id);
            return "settings/chargeType/editChargeType";
        }
        chargeTypeService.saveChargeType(chargeType);
        return "redirect:/settings/chargeType/chargeTypeList";

    }
}
