package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.ThirdPartyFilter;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "reports/thirdParty")
public class ThirdPartyReportController {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ThirdParty> list (ThirdPartyFilter filter, @RequestParam(required = false, defaultValue = "1") int page){
        return  thirdPartyRepository.filter(filter, PaginationUtil.pageRequest(page, "code", Sort.Direction.ASC));
    }
}
