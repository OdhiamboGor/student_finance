package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.feeSegment.models.FeeSegment;
import ke.ac.egerton.student_finance.feeSegment.repositories.FeeSegmentsRepository;
import ke.ac.egerton.student_finance.filters.FeeSegmentFilter;
import ke.ac.egerton.student_finance.reports.models.FeeSegmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "reports/feeSegment")
public class FeeSegmentReportController {

    FeeSegmentsRepository feeSegmentsRepository;

    public FeeSegmentReportController(FeeSegmentsRepository feeSegmentsRepository) {
        this.feeSegmentsRepository = feeSegmentsRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<FeeSegment> list(FeeSegmentFilter filter, @RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "1") int page) {
        Pageable pageable = PaginationUtil.pageRequest(page, "code", Sort.Direction.DESC);

        Page<FeeSegment> feeSegment;
        if(StringUtils.hasText(search)){
            FeeSegmentFilter filter1 = new FeeSegmentFilter();
            filter.setCode(search);
            feeSegment = feeSegmentsRepository.filter(filter1, pageable);
        }
        else{
            feeSegment = feeSegmentsRepository.findAll(pageable);
        }
       List<FeeSegmentResponse> responseList = new ArrayList<>();

        for(FeeSegment feeSeg :feeSegment){
            responseList.add(new FeeSegmentResponse(feeSeg));
        }
        return feeSegmentsRepository.filter(filter, PaginationUtil.pageRequest(page, "code", Sort.Direction.DESC));
    }
}