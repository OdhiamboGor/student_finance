package ke.ac.egerton.student_finance.settings.thirdParty.controllers;

import ke.ac.egerton.models.academic.AcademicYear;
import ke.ac.egerton.models.academic.Session;
import ke.ac.egerton.models.academic.StudentCategory;
import ke.ac.egerton.models.dao.academic.AcademicYearRepository;
import ke.ac.egerton.models.dao.academic.SessionRepository;
import ke.ac.egerton.models.dao.academic.StudentCategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.controllers.validation.LimitDetails;
import ke.ac.egerton.student_finance.settings.thirdParty.models.Limit;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.LimitRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.services.LimitService;
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
@RequestMapping(path = "settings/limit")
public class LimitController {

    //Autowired Repositories
    @Autowired
    LimitRepository limitRepository;
    @Autowired
    StudentCategoryRepository studentCategoryRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    AcademicYearRepository academicYearRepository;
    @Autowired
    SessionRepository sessionRepository;


    //Autowired Services
    @Autowired
    LimitService limitService;

    @RequestMapping(path = "limitList", method = RequestMethod.GET)
    public String limitList(Model model){
        List<Limit> limit = limitService.getAllLimit();
        model.addAttribute("limit", limit);
        return "settings/thirdParty/limit";
    }

    @RequestMapping(path = "addLimit", method = RequestMethod.GET)
    public String addLimit(Model model){
        List<StudentCategory> category = studentCategoryRepository.findAll();
        List<ThirdParty> thirdParty = thirdPartyRepository.findAll();
        List<AcademicYear> academicYear = academicYearRepository.findAll();
        List<Session> asession = sessionRepository.findAll();

        model.addAttribute("category", category);
        model.addAttribute("thirdParty", thirdParty);
        model.addAttribute("academicYear", academicYear);
        model.addAttribute("asession", asession);

        return "settings/thirdParty/addLimit";
    }

    @RequestMapping(path = "addLimit", method = RequestMethod.POST)
    public String saveLimit(@Valid @ModelAttribute("details") LimitDetails details, BindingResult result, Model model){

        String studentCategory = details.getStudentCategory();
        String thirdParty = details.getThirdParty();
        String academicYear = details.getAcademicYear();
        String asession = details.getSession();
        BigDecimal amnt = details.getAmount();

        StudentCategory sc = studentCategoryRepository.findOne(studentCategory);
        ThirdParty tp = thirdPartyRepository.findByCode(thirdParty);
        AcademicYear ay = academicYearRepository.findOne(academicYear);
        Session sess = sessionRepository.findFirstByCodeIgnoreCase(asession);

        Limit limit = new Limit();

        limit.setStudentCategory(sc);
        limit.setThirdParty(tp);
        limit.setAcademicYear(ay);
        limit.setSession(sess);
        limit.setAmount(amnt);

        model.addAttribute("limit", new Limit());

        limitService.saveLimit(limit);
        return "redirect:/settings/limit/limitList";
    }

    @RequestMapping(path="editLimit/{id}", method = RequestMethod.GET)
    public String editLimit(@PathVariable("id") long id, Model model){
        Limit limit = limitRepository.findOne(id);
        List<StudentCategory> category = studentCategoryRepository.findAll();
        List<ThirdParty> party = thirdPartyRepository.findAll();
        List<AcademicYear> academicYear = academicYearRepository.findAll();
        List<Session> asession = sessionRepository.findAll();

        model.addAttribute("limit", limit);
        model.addAttribute("category", category);
        model.addAttribute("party", party);
        model.addAttribute("academicYear", academicYear);
        model.addAttribute("asession", asession);

        return "settings/thirdParty/editLimit";
    }

    @RequestMapping(path="addLimit/{id}", method = RequestMethod.POST)
    public String updateLimit(Limit limit, @PathVariable("id") long id, @Valid LimitDetails details, BindingResult result, Model model){

        String studentCategory = details.getStudentCategory();
        String thirdParty = details.getThirdParty();
        String academicYear = details.getAcademicYear();
        String asession = details.getSession();
        BigDecimal amnt = details.getAmount();

        System.out.println(studentCategory);
        System.out.println(thirdParty);
        System.out.println(academicYear);
        System.out.println(asession);
        System.out.println(amnt);

        StudentCategory sc = studentCategoryRepository.findOne(studentCategory);
        ThirdParty tp = thirdPartyRepository.findByCode(thirdParty);
        AcademicYear ay = academicYearRepository.findOne(academicYear);
        Session sess = sessionRepository.findFirstByCodeIgnoreCase(asession);

        limit.setStudentCategory(sc);
        limit.setThirdParty(tp);
        limit.setAcademicYear(ay);
        limit.setSession(sess);
        limit.setAmount(amnt);

        limitService.saveLimit(limit);
        return "redirect:/settings/limit/limitList";

    }

}
