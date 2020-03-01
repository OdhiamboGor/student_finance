package ke.ac.egerton.student_finance.studentInquiry.controllers;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="students/studentInquiry")
public class StudentInquiryController  {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudent(Model model, Student studentReport){
        model.addAttribute("s", studentReport);
        return "student/studentInquiry";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String studentDetails(Model model, Student s){
        Student student = studentRepository.findTopByStudentNumberIgnoreCase(s.getStudentNumber());
        model.addAttribute("data", student);
        model.addAttribute("s",s);

        return "studentInquiry/studentInquiryResult";
    }

    /*@RequestMapping(value = "searchStudent", method = RequestMethod.GET)
    public String searchStudent(Model model, String accountNumber){
        System.out.println(accountNumber);
        Student student1 = studentRepository.findOne(Long.valueOf(accountNumber));

        System.out.println(student1);
        model.addAttribute("students", student1);

        return "studentInquiry/studentInquiry";
    }*/
}
