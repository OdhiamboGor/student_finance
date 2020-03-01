package ke.ac.egerton.student_finance.settings.feeSetup.controllers;

import ke.ac.egerton.academic.units.YearOfStudy;
import ke.ac.egerton.academic.units.YearOfStudyRepository;
import ke.ac.egerton.models.academic.*;
import ke.ac.egerton.models.dao.academic.*;
import ke.ac.egerton.models.dao.places.CountryRegionRepository;
import ke.ac.egerton.models.places.CountryRegion;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeStructure;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeStructureRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.FeeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "settings/feeStructure")
public class FeeStructureController {

    //Autowired Repositories
    @Autowired
    FeeStructureRepository feeStructureRepository;
    @Autowired
    ProgrammeRepository programmeRepository;
    @Autowired
    CountryRegionRepository countryRegionRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    StudentCategoryRepository studentCategoryRepository;
    @Autowired
    AcademicYearRepository academicYearRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    ChargeItemRepository chargeItemRepository;
    @Autowired
    YearOfStudyRepository yearOfStudyRepository;
    @Autowired
    CurrencyRepository currencyRepository;


    //Autowired Services
    @Autowired
    FeeStructureService feeStructureService;

    @RequestMapping(path = "feeStructureList", method = RequestMethod.GET)
    public String feeStructureList(Model model){
        List<FeeStructure> feeStructure =feeStructureRepository.findAll();
        return "settings/feeSetup/feeStructure";
    }

    @RequestMapping(path = " addFeeStructure", method = RequestMethod.GET)
    public String addFeeStructure(Model model) {
        List<Programme> programme = programmeRepository.findAll();
        List<CountryRegion> region = countryRegionRepository.findAll();
        List<Section> section = sectionRepository.findAll();
        List<StudentCategory> category = studentCategoryRepository.findAll();
        List<AcademicYear> academicYear = academicYearRepository.findAll();
        List<YearOfStudy> yearOfStudy = yearOfStudyRepository.findAll();
        List<Session> sess = sessionRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        List<Currency> currency = currencyRepository.findAll();

        model.addAttribute("programme", programme);
        model.addAttribute("region", region);
        model.addAttribute("section", section);
        model.addAttribute("category", category);
        model.addAttribute("academicYear", academicYear);
        model.addAttribute("yearOfStudy", yearOfStudy);
        model.addAttribute("sess", sess);
        model.addAttribute("chargeItem", chargeItem);
        model.addAttribute("currency", currency);

        return "settings/feeSetup/addFeeStructure";
    }
}
