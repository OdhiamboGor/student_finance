package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.VerifyDocumentsFilter;
import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;
import ke.ac.egerton.student_finance.invoicing.repositories.VerifyDocumentsRepository;
import ke.ac.egerton.student_finance.reports.models.VerifyDocumentsResponse;
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
@RequestMapping(path = "reports/verifyDocuments")
public class VerifyDocumentsReportController {

    VerifyDocumentsRepository verifyDocumentsRepository;

    public VerifyDocumentsReportController(VerifyDocumentsRepository verifyDocumentsRepository) {
        this.verifyDocumentsRepository = verifyDocumentsRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<VerifyDocuments> list(VerifyDocumentsFilter filter, @RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "1") int page) {

        Pageable pageable = PaginationUtil.pageRequest(page, "documentNumber", Sort.Direction.ASC );

        Page<VerifyDocuments> documents;

        if (StringUtils.hasText(search)){
            VerifyDocumentsFilter filter1 = new VerifyDocumentsFilter();
            filter.setDocumentNumber(search);
            documents = verifyDocumentsRepository.filter(filter1, pageable);
        }else{
            documents = verifyDocumentsRepository.findAll(pageable);
        }
        List<VerifyDocumentsResponse> verifyDocumentsResponseList = new ArrayList<>();

        for(VerifyDocuments verifyDocuments:documents){
            verifyDocumentsResponseList.add(new VerifyDocumentsResponse(verifyDocuments));
        }
        return verifyDocumentsRepository.filter(filter, PaginationUtil.pageRequest(page, "documentNumber", Sort.Direction.ASC));
    }
}
