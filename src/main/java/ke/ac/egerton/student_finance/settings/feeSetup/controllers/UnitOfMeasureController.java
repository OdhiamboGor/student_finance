package ke.ac.egerton.student_finance.settings.feeSetup.controllers;

import ke.ac.egerton.student_finance.settings.feeSetup.models.UnitOfMeasure;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.UnitOfMeasureRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.UnitOfMeasureService;
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
@RequestMapping(path = "settings/unitOfMeasure")
public class UnitOfMeasureController {

    //Autowired Repositories
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    //Autowired Services
    @Autowired
    UnitOfMeasureService unitOfMeasureService;

    @RequestMapping(path = "unitOfMeasureList", method = RequestMethod.GET)
    public String unitOfMeasure(Model model){
        List<UnitOfMeasure> units = unitOfMeasureRepository.findAll();
        model.addAttribute("units", units);
        return "settings/feeSetup/unitsOfMeasure";
    }

    @RequestMapping(path = "addUnitsOfMeasure", method = RequestMethod.GET)
    public String addUnitOfMeasure(){
        return "settings/feeSetup/addUnitsOfMeasure";
    }

    @RequestMapping(path="addUnitsOfMeasure", method = RequestMethod.POST)
    public String saveUnitOfMeasure(@Valid @ModelAttribute("chargeType") UnitOfMeasure unitOfMeasure, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/unitOfMeasure/addUnitsOfMeasure";
        }
        model.addAttribute("unitOfMeasure", new UnitOfMeasure());
        unitOfMeasureService.saveUnitOfMeasure(unitOfMeasure);

        return "redirect:/settings/unitOfMeasure/unitOfMeasureList";
    }

    @RequestMapping(path="editUnitOfMeasure/{id}", method = RequestMethod.GET)
    public String editUnitOfMeasure(@PathVariable("id") long id, Model model){
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findOne(id);
        model.addAttribute("unitOfMeasure", unitOfMeasure);
        return "settings/feeSetup/editUnitOfMeasure";
    }

    @RequestMapping(path="editUnitOfMeasure/{id}", method = RequestMethod.POST)
    public String updateUnitOfMeasure(@PathVariable("id") long id, @Valid UnitOfMeasure unitOfMeasure, BindingResult result, Model model){

        if (result.hasErrors()) {
            unitOfMeasure.setId(id);
            return "settings/unitOfMeasure/editUnitOfMeasure";
        }
        unitOfMeasureService.saveUnitOfMeasure(unitOfMeasure);
        return "redirect:/settings/unitOfMeasure/unitOfMeasureList";
    }
}
