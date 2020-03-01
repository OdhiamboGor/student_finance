package ke.ac.egerton.student_finance.quickDocuments.controllers;

import ke.ac.egerton.academic.units.YearOfStudy;
import ke.ac.egerton.academic.units.YearOfStudyRepository;
import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.academic.AcademicYear;
import ke.ac.egerton.models.academic.Session;
import ke.ac.egerton.models.dao.StudentRepository;
import ke.ac.egerton.models.dao.academic.AcademicYearRepository;
import ke.ac.egerton.models.dao.academic.SessionRepository;
import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "quickDocuments/batchEntry")
public class BatchEntryController {

    //Autowired Repositories
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    AcademicYearRepository academicYearRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    YearOfStudyRepository yearOfStudyRepository;



    @RequestMapping(path = "batchEntryForm", method = RequestMethod.GET)
    public String batchEntryForm(Model model){
        List<Batches> batch = batchRepository.findAll(new Sort(Sort.Direction.DESC, "batchDate"));
        List<Session> sessions = sessionRepository.findAll();
        List<AcademicYear> academicYear = academicYearRepository.findAll();
        List<Currency> currencies = currencyRepository.findAll();
        /*List<Student> students = studentRepository.findAll();*/
        List <YearOfStudy> yearOfStudy = yearOfStudyRepository.findAll();

        model.addAttribute("batch", batch);
        model.addAttribute("sess",sessions);
        model.addAttribute("academicYear", academicYear);
        model.addAttribute("currencies", currencies);
       /* model.addAttribute("students", students);*/
        model.addAttribute("yearOfStudy", yearOfStudy);

        return "quickDocuments/batchEntry/batchEntry";
    }
}
