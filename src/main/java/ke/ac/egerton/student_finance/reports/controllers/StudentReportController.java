package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.dao.StudentFilter;
import ke.ac.egerton.models.dao.StudentRepository;
import ke.ac.egerton.models.util.PaginationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "reports/student")
public class StudentReportController {

    @Autowired
    StudentRepository studentRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<Student> list(StudentFilter filter, @RequestParam(required = false, defaultValue = "1") int page) {
        return studentRepository.filter(filter, PaginationUtil.pageRequest(page, "studentNumber", Sort.Direction.ASC)
        );
    }
}
