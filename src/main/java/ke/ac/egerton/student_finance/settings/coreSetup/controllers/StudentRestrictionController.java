package ke.ac.egerton.student_finance.settings.coreSetup.controllers;

import ke.ac.egerton.models.StudentStatus;
import ke.ac.egerton.models.dao.StudentStatusRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.models.StudentRestriction;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.StudentRestrictionRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.StudentRestrictionService;
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
@RequestMapping(path = "settings/studentRestriction")
public class StudentRestrictionController {

    //Autowired Repositories
    @Autowired
    StudentRestrictionRepository studentRestrictionRepository;

    @Autowired
    StudentStatusRepository studentStatusRepository;

    //Autowired Services
    @Autowired
    StudentRestrictionService studentRestrictionService;

    @RequestMapping(path ="studentRestrictionList", method= RequestMethod.GET)
    public String studentRestrictionList(Model model){
        List<StudentRestriction> restrictions = studentRestrictionRepository.findAll();
        model.addAttribute("restriction", restrictions);
        return "settings/coreSetup/studentRestriction";
    }

    @RequestMapping(path="addStudentRestriction", method = RequestMethod.GET)
    public String addStudentRestriction(Model model){
        List <StudentStatus> studentStatus = studentStatusRepository.findAll();
        model.addAttribute("status", studentStatus);
        return "settings/coreSetup/addStudentRestriction";
    }

    @RequestMapping(path="addStudentRestriction", method = RequestMethod.POST)
    public String saveStudentRestriction(@Valid @ModelAttribute("studentRestriction") StudentRestriction studentRestriction, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "settings/studentRestriction/addStudentRestriction";
        }
        model.addAttribute("studentRestriction", new StudentRestriction());
        studentRestrictionService.saveStudentRestriction(studentRestriction);
        return "redirect:/settings/studentRestriction/studentRestrictionList";
    }

    @RequestMapping(path="/editStudentRestriction/{id}", method = RequestMethod.GET)
    public String editStudentRestriction(@PathVariable("id") long id, Model model){
        StudentRestriction studentRestriction = studentRestrictionService.getStudentRestrictionById(id);
        List <StudentStatus> studentStatus = studentStatusRepository.findAll();
        model.addAttribute("studentRestriction", studentRestriction);
        model.addAttribute("status", studentStatus);
        return "settings/coreSetup/editStudentRestriction";
    }

    @RequestMapping(path="/updateStudentRestriction/{id}", method = RequestMethod.POST)
    public String updateStudentRestriction(@PathVariable("id") long id, @Valid StudentRestriction studentRestriction, BindingResult result, Model model){
        if (result.hasErrors()) {
            studentRestriction.setId(id);
            return "redirect:/settings/studentRestriction/editStudentRestriction";
        }
        studentRestrictionService.saveStudentRestriction(studentRestriction);
        return "redirect:/settings/studentRestriction/studentRestrictionList";
    }
}
