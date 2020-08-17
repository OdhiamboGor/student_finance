package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.ChargeItemFilter;
import ke.ac.egerton.student_finance.filters.ReceiptFilter;
import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptRepository;
import ke.ac.egerton.student_finance.reports.models.ChargeItemResponse;
import ke.ac.egerton.student_finance.reports.models.ReceiptResponse;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "reports/receipt")
public class ReceiptReportController {

    @Autowired
    ReceiptRepository receiptRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<Receipt> list (ReceiptFilter filter, @RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "1") int page){
        Pageable pageable = PaginationUtil.pageRequest(page, "receiptNumber", Sort.Direction.DESC);

        Page<Receipt> receipts;
        if (StringUtils.hasText(search)) {
            ReceiptFilter filter1 = new ReceiptFilter();
            filter.setReceiptNumber(search);
            receipts = receiptRepository.filter(filter1, pageable);
        }
        else {
            receipts = receiptRepository.findAll(pageable);
        }
        List<ReceiptResponse> responseList = new ArrayList<>();

        for(Receipt receipt :receipts){
            responseList.add(new ReceiptResponse(receipt));
        }

        return receiptRepository.filter(filter, PaginationUtil.pageRequest(page, "receiptNumber", Sort.Direction.DESC));
    }
}
