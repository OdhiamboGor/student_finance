package ke.ac.egerton.student_finance.settings.feeSetup.controllers;

import ke.ac.egerton.academic.admission.disciplinary.settings.AccountSets;
import ke.ac.egerton.academic.admission.disciplinary.settings.AccountSetsRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.controllers.validation.ChargeItemDetails;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.models.UnitOfMeasure;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.UnitOfMeasureRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping(path = "settings/chargeItem")
public class ChargeItemController {

    //Autowired Repositories
    @Autowired
    ChargeItemRepository chargeItemRepository;
    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;
    @Autowired
    AccountSetsRepository accountSetsRepository;

    //Autowired Services
    @Autowired
    ChargeItemService chargeItemService;

    @RequestMapping(path = "chargeItemList", method = RequestMethod.GET)
    public String chargeItemList(Model model){
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        model.addAttribute("chargeItem", chargeItem);
        return "settings/feeSetup/chargeItem";
    }

    @RequestMapping(path = "addChargeItem", method = RequestMethod.GET)
    public String addChargeItem(Model model){
        List<UnitOfMeasure> unit = unitOfMeasureRepository.findAll();
        List<AccountSets> accountSets = accountSetsRepository.findAll();
        model.addAttribute("unit", unit);
        model.addAttribute("accountSets", accountSets);
        return "settings/feeSetup/addChargeItem";
    }

    @RequestMapping(path = "addChargeItem", method = RequestMethod.POST)
    public String saveChargeItem(@Valid @ModelAttribute("details") ChargeItemDetails details, BindingResult result, Model model){

        String code = details.getCode();
        String name = details.getName();
        String un = details.getUnitOfMeasure();
        Boolean tut = details.getTuition();
        String acc = details.getAccount();
        String map = details.getAccountMap();
        Boolean pay = details.getPayment();
        Boolean ins = details.getAutoInsert();
        BigDecimal amt = details.getAmount();
        Boolean seg = details.getHasSegment();
        Boolean sch = details.getScholarship();
        Boolean inv = details.getInvoice();
        String set  = details.getAccountSets();
        Long pri = details.getPriority();

        UnitOfMeasure unit = unitOfMeasureRepository.findByCode(un);
        AccountSets accSet = accountSetsRepository.findTopByCodeIgnoreCase(set);

        ChargeItem chargeItem= new ChargeItem();
        chargeItem.setCode(code);
        chargeItem.setName(name);
        chargeItem.setUnitOfMeasure(unit);
        chargeItem.setTuition(tut);
        chargeItem.setAccount(acc);
        chargeItem.setAccountMap(map);
        chargeItem.setPayment(pay);
        chargeItem.setAutoInsert(ins);
        chargeItem.setAmount(amt);
        chargeItem.setHasSegment(seg);
        chargeItem.setScholarship(sch);
        chargeItem.setInvoice(inv);
        chargeItem.setAccountSets(accSet);
        chargeItem.setPriority(pri);

        model.addAttribute("chargeItem", new ChargeItem());
        chargeItemService.saveChargeItem(chargeItem);
        return "redirect:/settings/chargeItem/chargeItemList";
    }

    @RequestMapping(path="editChargeItem/{id}", method = RequestMethod.GET)
    public String editChargeItem(@PathVariable("id") long id, Model model){

        ChargeItem chargeItem = chargeItemRepository.findOne(id);
        List<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findAll();
        List<AccountSets> accountSets = accountSetsRepository.findAll();
        model.addAttribute("chargeItem", chargeItem);
        model.addAttribute("unitOfMeasure", unitOfMeasure);
        model.addAttribute("accountSets", accountSets);
        return "settings/feeSetup/editChargeItem";
    }

    @RequestMapping(path="/editChargeItem/{id}", method = RequestMethod.POST)
    public String updateChargeItem(ChargeItem chargeItem, @PathVariable("id") long id, @Valid ChargeItemDetails details, BindingResult result, Model model){

        String cod = details.getCode();
        String name = details.getName();
        String un = details.getUnitOfMeasure();
        Boolean tut = details.getTuition();
        String acc = details.getAccount();
        String map = details.getAccountMap();
        Boolean pay = details.getPayment();
        Boolean ins = details.getAutoInsert();
        BigDecimal amt = details.getAmount();
        Boolean seg = details.getHasSegment();
        Boolean sch = details.getScholarship();
        Boolean inv = details.getInvoice();
        String set  = details.getAccountSets();
        Long pri = details.getPriority();

        System.out.println(cod);
        System.out.println(name);
        System.out.println(un);
        System.out.println(tut);
        System.out.println(acc);
        System.out.println(map);
        System.out.println(pay);
        System.out.println(ins);
        System.out.println(amt);
        System.out.println(seg);
        System.out.println(sch);
        System.out.println(inv);
        System.out.println(set);
        System.out.println(pri);

        UnitOfMeasure unit = unitOfMeasureRepository.findByCode(un);
        AccountSets accSet = accountSetsRepository.findTopByCodeIgnoreCase(set);

        chargeItem.setCode(cod);
        chargeItem.setName(name);
        chargeItem.setUnitOfMeasure(unit);
        chargeItem.setTuition(tut);
        chargeItem.setAccount(acc);
        chargeItem.setAccountMap(map);
        chargeItem.setPayment(pay);
        chargeItem.setAutoInsert(ins);
        chargeItem.setAmount(amt);
        chargeItem.setHasSegment(seg);
        chargeItem.setScholarship(sch);
        chargeItem.setInvoice(inv);
        chargeItem.setAccountSets(accSet);
        chargeItem.setPriority(pri);

        chargeItemService.saveChargeItem(chargeItem);
        return "redirect:/settings/chargeType/chargeTypeList";

    }
}
