package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.payment.models.MiscReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.MiscReceiptTypeRepository;
import ke.ac.egerton.student_finance.settings.payment.services.MiscReceiptTypeService;
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
@RequestMapping(path = "settings/miscReceiptType")
public class MiscReceiptTypeController {

    //Autowired Repositories
    @Autowired
    MiscReceiptTypeRepository miscReceiptTypeRepository;

    //Autowired Services
    @Autowired
    MiscReceiptTypeService miscReceiptTypeService;


@RequestMapping(path = "miscReceiptTypeList", method = RequestMethod.GET)
    public String miscReceiptTypeList(Model model){
      List<MiscReceiptType> receiptType = miscReceiptTypeRepository.findAll();
      model.addAttribute("receiptType", receiptType);
        return "settings/payment/miscReceipt";
    }

    @RequestMapping(path = "addMiscReceiptType", method = RequestMethod.GET)
    public String addMiscReceiptType(){
        return "settings/payment/addMiscReceiptType";
    }


    @RequestMapping(path = "addMiscReceiptType", method = RequestMethod.POST)
    public String saveMiscReceiptType(@ModelAttribute("miscReceiptType") MiscReceiptType miscReceiptType, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "redirect:/settings/miscReceiptType/addMiscReceiptType";
        }
        model.addAttribute("miscReceiptType", new MiscReceiptType());
        miscReceiptTypeService.saveMiscReceiptType(miscReceiptType);
        return "redirect:/settings/miscReceiptType/miscReceiptTypeList";
    }

    @RequestMapping(path="editMiscReceiptType/{id}", method = RequestMethod.GET)
    public String editMiscReceiptType(@PathVariable("id") long id, Model model){
        MiscReceiptType miscReceiptType = miscReceiptTypeRepository.findOne(id);
        model.addAttribute("miscReceiptType",miscReceiptType);
        return "settings/payment/editMiscReceiptType";
    }

    @RequestMapping(path="editMiscReceiptType/{id}", method = RequestMethod.POST)
    public String updateMiscReceiptType(@PathVariable("id") long id, @Valid MiscReceiptType miscReceiptType, BindingResult result, Model model){
        if (result.hasErrors()) {
            miscReceiptType.setId(id);
            return "settings/payment/editMiscReceiptType";
        }
        miscReceiptTypeService.saveMiscReceiptType(miscReceiptType);
        return "redirect:/settings/miscReceiptType/miscReceiptTypeList";
    }
}
