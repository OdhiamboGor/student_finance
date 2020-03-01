package ke.ac.egerton.student_finance.reports.controllers;

import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.filters.TransactionFilter;
import ke.ac.egerton.student_finance.transactions.models.Transaction;
import ke.ac.egerton.student_finance.transactions.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "reports/transaction")
public class TransactionReportController {

    @Autowired
    TransactionRepository transactionRepository;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<Transaction> list(TransactionFilter filter, @RequestParam(required = false, defaultValue = "1") int page) {
        return transactionRepository.filter(filter, PaginationUtil.pageRequest(page, "docNo", Sort.Direction.ASC)
        );
    }
}
