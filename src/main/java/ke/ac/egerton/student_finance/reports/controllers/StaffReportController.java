package ke.ac.egerton.student_finance.reports.controllers;


import ke.ac.egerton.models.Staff;
import ke.ac.egerton.models.dao.StaffFilter;
import ke.ac.egerton.models.dao.StaffRepository;
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
@RequestMapping(path = "reports/staff")
public class StaffReportController {

    @Autowired
    StaffRepository staffRepository;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<Staff> list(StaffFilter filter, @RequestParam(required = false, defaultValue = "1") int page) {
        return staffRepository.filter(filter, PaginationUtil.pageRequest(page, "payrollId", Sort.Direction.ASC)
        );
    }
}
