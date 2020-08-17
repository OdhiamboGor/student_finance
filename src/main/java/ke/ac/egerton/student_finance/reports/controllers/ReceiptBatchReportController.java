package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.ReceiptBatchFilter;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptBatchesRepository;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import ke.ac.egerton.student_finance.reports.models.BatchResponse;
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
@RequestMapping(path = "reports/receiptBatch")
public class ReceiptBatchReportController {

    ReceiptBatchesRepository receiptBatchesRepository;

    public ReceiptBatchReportController(ReceiptBatchesRepository receiptBatchesRepository) {
        this.receiptBatchesRepository = receiptBatchesRepository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ReceiptBatch> list (ReceiptBatchFilter filter, @RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "1") int page){
        Pageable pageable = PaginationUtil.pageRequest(page, "batchId", Sort.Direction.DESC);

        Page<ReceiptBatch> batch;
        if (StringUtils.hasText(search)) {
            ReceiptBatchFilter filter1 = new ReceiptBatchFilter();
            filter.setBatchId(search);
            batch = receiptBatchesRepository.filter(filter1, pageable);
        }
        else {
            batch = receiptBatchesRepository.findAll(pageable);
        }
            List<BatchResponse> responseList = new ArrayList<>();

            for(ReceiptBatch receiptBatch:batch){
                responseList.add(new BatchResponse(receiptBatch));
            }

        return receiptBatchesRepository.filter(filter, PaginationUtil.pageRequest(page, "batchId", Sort.Direction.DESC));
    }
}
