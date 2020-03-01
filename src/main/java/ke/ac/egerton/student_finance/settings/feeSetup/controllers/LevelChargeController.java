package ke.ac.egerton.student_finance.settings.feeSetup.controllers;

import ke.ac.egerton.models.academic.StudyLevel;
import ke.ac.egerton.models.dao.academic.StudyLevelRepository;
import ke.ac.egerton.models.dao.places.CountryRegionRepository;
import ke.ac.egerton.models.places.CountryRegion;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.currency.service.CurrencyService;
import ke.ac.egerton.student_finance.settings.feeSetup.controllers.validation.LevelChargeDetails;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.models.LevelCharge;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.LevelChargeRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.ChargeItemService;
import ke.ac.egerton.student_finance.settings.feeSetup.services.LevelChargeService;
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
@RequestMapping(path = "settings/levelCharge")
public class LevelChargeController {

    //Autowired Repositories
    @Autowired
    LevelChargeRepository levelChargeRepository;
    @Autowired
    StudyLevelRepository studyLevelRepository;
    @Autowired
    CountryRegionRepository countryRegionRepository;
    @Autowired
    ChargeItemRepository chargeItemRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    //Autowired Services
    @Autowired
    ChargeItemService chargeItemService;
    @Autowired
    CurrencyService currencyService;
    @Autowired
    LevelChargeService levelChargeService;

    @RequestMapping(path = "levelChargeList", method = RequestMethod.GET)
    public String levelChargeList(Model model){
        List<LevelCharge> levelCharge = levelChargeRepository.findAll();
        model.addAttribute("levelCharge", levelCharge);
        return "settings/feeSetup/levelCharge";
    }

    @RequestMapping(path = "addLevelCharge", method = RequestMethod.GET)
    public String addLevelCharge(Model model){
        List<StudyLevel> level = studyLevelRepository.findAll();
        List<CountryRegion> region = countryRegionRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        List<Currency> currency = currencyRepository.findAll();
        model.addAttribute("level", level);
        model.addAttribute("region",region);
        model.addAttribute("chargeItem",chargeItem);
        model.addAttribute("currency",currency);
        return "settings/feeSetup/addLevelCharge";
    }

    @RequestMapping(path="addLevelCharge", method = RequestMethod.POST)
    public String saveLevelCharge(@Valid @ModelAttribute("details") LevelChargeDetails details, BindingResult result, Model model){
       String level = details.getLevel();
       String region = details.getRegion();
       String item = details.getChargeItem();
       BigDecimal amnt = details.getAmount();
       Boolean app = details.getApplication();
       Boolean grad = details.getGraduation();
       Boolean pen = details.getPenalty();
       Boolean alnm = details.getAlumni();
       String curr = details.getCurrency();

       StudyLevel stud = studyLevelRepository.findByCode(level);
       CountryRegion cnt = countryRegionRepository.findByCode(region);
       ChargeItem chg = chargeItemRepository.findByCode(item);
       Currency cur = currencyRepository.findByCode(curr);


       LevelCharge levelCharge = new LevelCharge();
       levelCharge.setLevel(stud);
       levelCharge.setRegion(cnt);
       levelCharge.setChargeItem(chg);
       levelCharge.setCurrency(cur);
       levelCharge.setAmount(amnt);
       levelCharge.setApplication(app);
       levelCharge.setGraduation(grad);
       levelCharge.setPenalty(pen);
       levelCharge.setAlumni(alnm);


        model.addAttribute("levelCharge", new LevelCharge());
        levelChargeService.saveLevelCharge(levelCharge);
        return "redirect:/settings/levelCharge/levelChargeList";
    }

    @RequestMapping(path="editLevelCharge/{id}", method = RequestMethod.GET)
    public String editLevelCharge(@PathVariable("id") long id, Model model){
        LevelCharge levelCharge = levelChargeRepository.findOne(id);
        List<StudyLevel> level = studyLevelRepository.findAll();
        List<CountryRegion> region = countryRegionRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        List<Currency> currency = currencyRepository.findAll();
        model.addAttribute("levelCharge", levelCharge);
        model.addAttribute("level", level);
        model.addAttribute("region",region);
        model.addAttribute("chargeItem",chargeItem);
        model.addAttribute("currency",currency);

        return "settings/feeSetup/editLevelCharge";
    }

    @RequestMapping(path="editLevelCharge/{id}", method = RequestMethod.POST)
    public String updateLevelCharge(LevelCharge levelCharge, @PathVariable("id") long id, @Valid LevelChargeDetails details, BindingResult result, Model model){

        String level = details.getLevel();
        String region = details.getRegion();
        String item = details.getChargeItem();
        String curr = details.getCurrency();

        BigDecimal amnt = levelCharge.getAmount();
        Boolean app = levelCharge.getApplication();
        Boolean grad = levelCharge.getGraduation();
        Boolean pen = levelCharge.getPenalty();
        Boolean alnm = levelCharge.getAlumni();


        System.out.println(level);
        System.out.println(region);
        System.out.println(item);
        System.out.print(amnt);
        System.out.print(app);
        System.out.print(grad);
        System.out.print(pen);
        System.out.print(alnm);
        System.out.println(curr);


        StudyLevel stud = studyLevelRepository.findByCode(level);
        CountryRegion cnt = countryRegionRepository.findByCode(region);
        ChargeItem chg = chargeItemRepository.findByCode(item);
        Currency cur = currencyRepository.findByCode(curr);

        System.out.println(stud);
        System.out.println(cnt);
        System.out.println(chg);
        System.out.println(cur);

        levelCharge.setLevel(stud);
        levelCharge.setRegion(cnt);
        levelCharge.setChargeItem(chg);
        levelCharge.setCurrency(cur);
        levelCharge.setAmount(amnt);
        levelCharge.setApplication(app);
        levelCharge.setGraduation(grad);
        levelCharge.setPenalty(pen);
        levelCharge.setAlumni(alnm);

        levelChargeService.saveLevelCharge(levelCharge);
        return "redirect:/settings/levelCharge/levelChargeList";

    }

}
