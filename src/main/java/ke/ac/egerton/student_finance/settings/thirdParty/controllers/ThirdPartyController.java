package ke.ac.egerton.student_finance.settings.thirdParty.controllers;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.ChargeItemService;
import ke.ac.egerton.student_finance.settings.thirdParty.controllers.validation.ThirdPartyDetails;
import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.services.CategoryService;
import ke.ac.egerton.student_finance.settings.thirdParty.services.ThirdPartyService;
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
@RequestMapping(path="settings/thirdParty")
public class ThirdPartyController {


    //Autowired Repositories
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ChargeItemRepository chargeItemRepository;

    //Autowired Services
    @Autowired
    ThirdPartyService thirdPartyService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ChargeItemService chargeItemService;


    @RequestMapping(path = "thirdPartyList", method = RequestMethod.GET)
    public String thirdPartyList(Model model){
        List<ThirdParty> thirdParty = thirdPartyRepository.findAll();
        model.addAttribute("thirdParty", thirdParty);
        return "settings/thirdParty/parties";
    }

    @RequestMapping(path = "addThirdParty", method = RequestMethod.GET)
    public String addThirdParty(Model model){
        List<Category> category = categoryRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();

        model.addAttribute("category", category);
        model.addAttribute("chargeItem", chargeItem);
        return "settings/thirdParty/addThirdParty";
    }

    @RequestMapping(path = "addThirdParty", method = RequestMethod.POST)
    public String saveThirdParty(@Valid @ModelAttribute("details") ThirdPartyDetails details, BindingResult result, Model model){

        String cate = details.getCategory();
        String cod = details.getCode();
        String nam = details.getName();
        String pay = details.getPayee();
        String charge = details.getChargeItem();
        String acc = details.getAccount();
/*
        System.out.print(cate);
        System.out.print(cod);
        System.out.print(nam);
        System.out.print(pay);
        System.out.print(charge);
        System.out.print(acc);*/

        Category category = categoryRepository.findByCode(cate);

        ChargeItem chargeItem = chargeItemRepository.findByCode(charge);

        ThirdParty thirdParty = new ThirdParty();

        thirdParty.setCategory(category);
        thirdParty.setCode(cod);
        thirdParty.setName(nam);
        thirdParty.setPayee(pay);
        thirdParty.setChargeItem(chargeItem);
        thirdParty.setAccount(acc);

        model.addAttribute("thirdParty", new ThirdParty());

        thirdPartyService.saveThirdParty(thirdParty);
        return "redirect:/settings/thirdParty/thirdPartyList";
    }

    @RequestMapping(path="editThirdParty/{id}", method = RequestMethod.GET)
    public String editThirdParty(@PathVariable("id") long id, Model model){

        ThirdParty thirdParty = thirdPartyRepository.findOne(id);

        List<Category> category = categoryRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();

        model.addAttribute("thirdParty", thirdParty);
        model.addAttribute("category", category);
        model.addAttribute("chargeItem", chargeItem);

        return "settings/thirdParty/editThirdParty";
    }

    @RequestMapping(path="editThirdParty/{id}", method = RequestMethod.POST)
    public String updateThirdParty(@PathVariable("id") long id, @Valid ThirdParty thirdParty, BindingResult result, Model model){

        if (result.hasErrors()) {
            thirdParty.setId(id);
            return "settings/thirdParty/editThirdParty";
        }
       thirdPartyService.saveThirdParty(thirdParty);
        return "redirect:/settings/thirdParty/thirdPartyList";
    }

}
