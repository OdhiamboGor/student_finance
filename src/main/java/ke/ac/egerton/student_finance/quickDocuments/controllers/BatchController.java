package ke.ac.egerton.student_finance.quickDocuments.controllers;

import ke.ac.egerton.models.Staff;
import ke.ac.egerton.models.dao.StaffRepository;
import ke.ac.egerton.models.util.PaginationUtil;
import ke.ac.egerton.student_finance.quickDocuments.controllers.validation.BatchesDetails;
import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.quickDocuments.services.BatchService;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "quickDocuments/batches")
public class BatchController {


    //Autowired Repositories
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    StaffsRepository staffsRepository;


    //Autowired Services
    @Autowired
    BatchService batchService;

    @RequestMapping(path = "batchList", method = RequestMethod.GET)
    public String batchList(Model model,@RequestParam(defaultValue = "1") int page){
        Pageable pageable = PaginationUtil.pageRequest(page, "batchDate", Sort.Direction.DESC);
        Page<Batches> batch = batchRepository.findAll(pageable);
        model.addAttribute("batch", batch);
        return "quickDocuments/batches/batchList";
    }

    @RequestMapping(path = "addBatch", method = RequestMethod.GET)
    public String addBatch(Model model){
        List<Staff> staff = staffRepository.findAll();
        model.addAttribute("staff", staff);
        return "quickDocuments/batches/addBatch";
    }

    @RequestMapping(path = "addBatch", method = RequestMethod.POST)
    public String saveBatch(@Valid @ModelAttribute("details") BatchesDetails details, BindingResult result, Model model) throws ParseException {

        String desc = details.getBatchDescription();
        String date = details.getBatchDate();
        String payroll = details.getStaff();

        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = date1.parse(date);

        Staff st = staffsRepository.findByPayrollId(payroll);

        Batches batches = new Batches();

        batches.setBatchDescription(desc);
        batches.setBatchDate(d2);
        batches.setStaff(st);

        model.addAttribute("batches", new Batches());

        batchService.saveBatch(batches);

        batches.setBatchNo(batches.getId());
        batchService.saveBatch(batches);

        return "redirect:/quickDocuments/batches/batchList";
    }

    @RequestMapping(path="editBatch/{id}", method = RequestMethod.GET)
    public String editBatch(@PathVariable("id") long id, Model model){

        Batches batch = batchRepository.findOne(id);
        List <Staff> staff = staffsRepository.findAll();

        model.addAttribute("batch", batch);
        model.addAttribute("staff", staff);

        return "quickDocuments/batches/editBatch";

    }

    @RequestMapping(path="editBatch/{id}", method = RequestMethod.POST)
    public String updateBatch(@PathVariable("id") long id, @Valid BatchesDetails details, BindingResult result, Model model) throws ParseException {

        Batches batches = batchRepository.findOne(id);

        String desc = details.getBatchDescription();
        String date = details.getBatchDate();
        String payroll = details.getStaff();

        DateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = date1.parse(date);

        Staff st = staffsRepository.findByPayrollId(payroll);

        batches.setBatchDescription(desc);
        batches.setBatchDate(d2);
        batches.setStaff(st);

        batchService.saveBatch(batches);

        batches.setBatchNo(batches.getId());
        batchService.updateBatch(batches);

        return "redirect:/quickDocuments/batches/batchList";
    }

    @RequestMapping(path="deleteBatch/{id}", method = RequestMethod.GET)
    public String deleteBatch(@PathVariable("id") long id){
        Batches batches = batchRepository.findOne(id);

        batchService.deleteBatch(batches);

        return "redirect:/quickDocuments/batches/batchList";
    }

}
