package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.ChargeItemFilter;
import ke.ac.egerton.student_finance.filters.ReceiptBatchFilter;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import ke.ac.egerton.student_finance.reports.models.BatchResponse;
import ke.ac.egerton.student_finance.reports.models.ChargeItemResponse;
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
@RequestMapping(path = "reports/chargeItem")
public class ChargeItemReportController {

    @Autowired
    ChargeItemRepository chargeItemRepository;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ChargeItem> list (ChargeItemFilter filter, @RequestParam(required = false) String search, @RequestParam(required = false, defaultValue = "1") int page){
        Pageable pageable = PaginationUtil.pageRequest(page, "code", Sort.Direction.DESC);

        Page<ChargeItem> chargeItem;
        if (StringUtils.hasText(search)) {
            ChargeItemFilter filter1 = new ChargeItemFilter();
            filter.setCode(search);
            chargeItem = chargeItemRepository.filter(filter1, pageable);
        }
        else {
            chargeItem = chargeItemRepository.findAll(pageable);
        }
        List<ChargeItemResponse> responseList = new ArrayList<>();

        for(ChargeItem chargeItems :chargeItem){
            responseList.add(new ChargeItemResponse(chargeItems));
        }

        return chargeItemRepository.filter(filter, PaginationUtil.pageRequest(page, "code", Sort.Direction.DESC));
    }
}
