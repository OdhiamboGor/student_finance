package ke.ac.egerton.student_finance.receipting.controllers;

import ke.ac.egerton.models.Staff;
import ke.ac.egerton.models.dao.StaffRepository;
import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.receipting.controllers.validation.ReceiptBatchDetails;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptBatchRepository;
import ke.ac.egerton.student_finance.receipting.services.ReceiptBatchService;
import ke.ac.egerton.student_finance.reports.models.StaffReport;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSetRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentCodeRepository;
import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReceiptingCriteriaRepository;
import ke.ac.egerton.student_finance.staff.repository.StaffsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(path = "receipting/receiptBatch")
public class ReceiptBatchController {

    //Autowired Repositories
    @Autowired
    ReceiptBatchRepository receiptBatchRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    AccountSetRepository accountSetRepository;
    @Autowired
    ReceiptingCriteriaRepository receiptingCriteriaRepository;
    @Autowired
    SegmentCodeRepository segmentCodeRepository;

    //Autowired Services
    @Autowired
    ReceiptBatchService receiptBatchService;


    @RequestMapping(path = "receiptBatchList", method = RequestMethod.GET)
    public String receiptBatchList(Model model,@RequestParam(defaultValue = "1") int page){
        Pageable pageable = PaginationUtil.pageRequest(page, "batchDate", Sort.Direction.DESC);
        Page<ReceiptBatch> receiptBatch = receiptBatchRepository.findAll(pageable);
        List<Staff> staff = staffRepository.findAll();

        model.addAttribute("receiptBatch", receiptBatch);
        model.addAttribute("staff", staff);
        return "receipting/batches/receiptBatch";
    }

    @RequestMapping(path = "addReceiptBatch", method = RequestMethod.GET)
    public String addReceiptBatch(Model model, StaffReport staffReport){
        List<Staff> staff = staffRepository.findAll();
        List<AccountSet> accountSet = accountSetRepository.findAll();
        List<ReceiptingCriteria> receiptingCriteria= receiptingCriteriaRepository.findAll();
        List<SegmentCode> segmentCode = segmentCodeRepository.findAll();

        model.addAttribute("staff", staffReport);
        model.addAttribute("staff", staff);
        model.addAttribute("accountSet", accountSet);
        model.addAttribute("receiptingCriteria",receiptingCriteria);
        model.addAttribute("segmentCode", segmentCode);

        return "receipting/batches/addReceiptBatch";
    }

    @RequestMapping(path = "addReceiptBatch", method = RequestMethod.POST)
    public String saveReceiptBatch(@ModelAttribute("details") ReceiptBatchDetails details, BindingResult result, Model model) throws ParseException {

       String userId= details.getUserId();
       String date = details.getBatchDate();

       DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
       Date d2 = date1.parse(date);

        LocalDate ld = LocalDate.now();
        Instant instant = ld.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);

        ReceiptBatch rcptBatch =  receiptBatchRepository.findByStaff_PayrollIdAndBatchDateAndStatus(userId, d2, false);


        if(rcptBatch != null) {
            model.addAttribute("error", "User has an open Batch for today");
            return "receipting/batches/addReceiptBatch";
        }
        else {
            Long batchEnd = details.getBatchEnd();
            String batchDesc = details.getBatchDescription();


            Staff st = staffRepository.findTopByPayrollId(userId);
            //String username = st.getFullName();

            ReceiptBatch receiptBatch = new ReceiptBatch();

            receiptBatch.setStaff(st);
            receiptBatch.setUsername(st.getFullName());
            receiptBatch.setBatchDate(d2);

            receiptBatch.setBatchEnd(batchEnd);

            receiptBatch.setBatchDescription(batchDesc);
            receiptBatch.setStatus(false);


            receiptBatch = receiptBatchService.saveReceiptBatch(receiptBatch);
            if (receiptBatch.getBatchId() == null) {
                receiptBatch.setBatchId(receiptBatch.getId());

                receiptBatchService.saveReceiptBatch(receiptBatch);
            }

            return "redirect:/receipting/receiptBatch/receiptBatchList";
        }
    }

    @RequestMapping(path="editReceiptBatch/{id}", method = RequestMethod.GET)
    public String editReceiptBatch(@PathVariable("id") long id, Model model){
        ReceiptBatch receiptBatch = receiptBatchRepository.findOne(id);

        List<Staff> staff = staffRepository.findAll();
        List<AccountSet> accountSet = accountSetRepository.findAll();
        List<ReceiptingCriteria> receiptingCriteria= receiptingCriteriaRepository.findAll();
        List<SegmentCode> segmentCode = segmentCodeRepository.findAll();

        model.addAttribute("receiptBatch", receiptBatch);
        model.addAttribute("staff", staff);
        model.addAttribute("accountSet", accountSet);
        model.addAttribute("receiptingCriteria",receiptingCriteria);
        model.addAttribute("segmentCode", segmentCode);

        return "receipting/batches/editReceiptBatch";
    }

    @RequestMapping(path="editReceiptBatch/{id}", method = RequestMethod.POST)
    public  String updateReceiptBatch(@PathVariable("id") long id, @Valid ReceiptBatchDetails details, BindingResult result, Model model) throws ParseException {

        ReceiptBatch receiptBatch = receiptBatchRepository.findOne(id);

        String bId = receiptBatch.getId();
        //System.out.println(bId);

        String date = details.getBatchDate();

        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = date1.parse(date);


        Long batchEnd = receiptBatch.getBatchEnd();
        System.out.println(batchEnd);

        String batchDesc = receiptBatch.getBatchDescription();
        System.out.println(batchDesc);

        Staff st = receiptBatch.getStaff();
        String userId = st.getPayrollId();
        System.out.println(userId);

        String username = st.getUsername();
        System.out.println(username);

        receiptBatch.setBatchId(bId);
        receiptBatch.setStaff(st);
        receiptBatch.setUsername(st.getFullName());
        receiptBatch.setBatchDate(d2);
        receiptBatch.setBatchEnd(batchEnd);
        receiptBatch.setBatchDescription(batchDesc);


        //model.addAttribute("receiptBatch", new ReceiptBatch());
        receiptBatchService.saveReceiptBatch(receiptBatch);

        return "redirect:/receipting/receiptBatch/receiptBatchList";
    }

    @RequestMapping(path="deleteReceiptBatch/{id}", method = RequestMethod.GET)
    public String deleteReceiptBatch(@PathVariable("id") long id, Model model){

        ReceiptBatch rb =  receiptBatchRepository.findOne(id);
        receiptBatchRepository.delete(rb);
        //receiptBatchService.deleteReceiptBatch(rb);

        return "redirect:/receipting/receiptBatch/receiptBatchList";

    }



}
