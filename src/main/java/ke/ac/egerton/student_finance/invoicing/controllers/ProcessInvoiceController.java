package ke.ac.egerton.student_finance.invoicing.controllers;

import ke.ac.egerton.academic.admission.disciplinary.settings.FeeSegement;
import ke.ac.egerton.academic.admission.disciplinary.settings.FeeSegmentRepository;
import ke.ac.egerton.models.academic.*;
import ke.ac.egerton.models.dao.academic.*;
import ke.ac.egerton.models.dao.places.CountryRegionRepository;
import ke.ac.egerton.student_finance.invoicing.controllers.validation.InvoiceDetails;
import ke.ac.egerton.student_finance.invoicing.controllers.validation.InvoiceListWrapper;
import ke.ac.egerton.student_finance.invoicing.models.Invoice;
import ke.ac.egerton.student_finance.invoicing.repositories.InvoiceRepository;
import ke.ac.egerton.student_finance.invoicing.services.InvoiceService;
import ke.ac.egerton.student_finance.programme.repositories.ProgrammesRepository;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FiscalCalendarRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.StudentRestrictionRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.FiscalCalendarService;
import ke.ac.egerton.student_finance.settings.coreSetup.services.StudentRestrictionService;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.currency.repository.ExchangeRateRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeStructureRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeTypeRepository;
import ke.ac.egerton.student_finance.settings.period.repositories.SFPeriodRepository;
import ke.ac.egerton.student_finance.student.repository.StudentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(path="invoicing/processInvoices")
public class ProcessInvoiceController {


    //Autowired repositories
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    StudentCategoryRepository studentCategoryRepository;
    @Autowired
    StudentRestrictionRepository studentRestrictionRepository;
    @Autowired
    FiscalCalendarRepository fiscalCalendarRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    ExchangeRateRepository exchangeRateRepository;
    @Autowired
    SFPeriodRepository periodRepository;
    @Autowired
    CountryRegionRepository countryRegionRepository;
    @Autowired
    ProgrammeRepository programmeRepository;
    @Autowired
    AcademicYearRepository academicYearRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    FeeStructureRepository feeStructureRepository;
    @Autowired
    FeeTypeRepository feeTypeRepository;
    @Autowired
    CampusRepository campusRepository;
    @Autowired
    ProgrammesRepository programmesRepository;
    @Autowired
    CohortRepository cohortRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    FeeSegmentRepository feeSegmentRepository;


    //Autowired Services
    @Autowired
    StudentRestrictionService studentRestrictionService;
    @Autowired
    FiscalCalendarService fiscalCalendarService;
    @Autowired
    InvoiceService invoiceService;

    //private ArrayList<InvoiceListWrapper> invoiceLists = new ArrayList<InvoiceListWrapper>();

    @RequestMapping(path = "processInvoiceForm", method = RequestMethod.GET)
    public String processInvoiceForm(Model model) {

        List<AcademicYear> academicYear = academicYearRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
        model.addAttribute("acadYear", academicYear);

        List<Programme> prog = programmesRepository.findAll(new Sort(Sort.Direction.ASC, "description"));
        model.addAttribute("prog", prog);

        List<Session> sess = sessionRepository.findAll();
        model.addAttribute("sess", sess);

        List<Campus> camp = campusRepository.findAll();
        model.addAttribute("camp", camp);

        List<Cohort> coh = cohortRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
        model.addAttribute("coh", coh);

        List<FeeSegement> feeseg = feeSegmentRepository.findAll();
        model.addAttribute("feeseg", feeseg);

        return "invoicing/processInvoices/processInvoiceForm";
    }

    @RequestMapping(path = "invoicesProcess", method = RequestMethod.POST)
    public String invoicesProcess(InvoiceDetails invoiceDetails, Model model, RedirectAttributes r, @RequestParam(required = false, defaultValue = "1") int page) {
        

        String acYear = invoiceDetails.getAcademicYear();
        //System.out.println(acYear);

        String campusCode = invoiceDetails.getCampusCode();
        //System.out.println(campusCode);

        String sesss = invoiceDetails.getSemesterCode();
        //System.out.println(sesss);

        String segCode = invoiceDetails.getSegCode();
        //System.out.println(segCode);

        List<AcademicYear> academicYear = academicYearRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
        model.addAttribute("acadYear", academicYear);

        List<Programme> prog = programmesRepository.findAll(new Sort(Sort.Direction.ASC, "description"));
        model.addAttribute("prog", prog);

        List<Session> sess = sessionRepository.findAll();
        model.addAttribute("sess", sess);

        List<Campus> camp = campusRepository.findAll();
        model.addAttribute("camp", camp);

        List<Cohort> coh = cohortRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
        model.addAttribute("coh", coh);

        List<FeeSegement> feeseg = feeSegmentRepository.findAll();
        model.addAttribute("feeseg", feeseg);


        List<Invoice> invoices =  invoiceRepository.findByAcademicYearAndCampusCodeAndSemesterCodeAndSegCodeAndStatusIsNull(acYear, campusCode, sesss, segCode);


        //Get sum of amount and put commas
        int totalAmount = invoices.stream().mapToInt(Invoice::getAmount).sum();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String total = numberFormat.format(totalAmount);
        model.addAttribute("total", total);

        int rec = invoices.size();
        //System.out.print(rec);

        //Check if list is empty
        if (invoices.isEmpty()) {
            r.addFlashAttribute("error", "No Record Found");
            return "redirect:/invoicing/processInvoices/processInvoiceForm";

        }

        model.addAttribute("invoices", invoices);

        return "invoicing/processInvoices/processInvoiceResultForm";
    }

  /*  @RequestMapping(path = "updateInvoice", method = RequestMethod.POST)
    @ResponseBody
    public String updateInvoice(@RequestParam  List<Long> id, Model model){

    System.out.println(id);

        return "redirect:/invoicing/processInvoices/invoicesProcess";
    }*/


    @RequestMapping(path = "updateInvoice", method = RequestMethod.POST)
    public String updateInvoice(@ModelAttribute("invoiceDetails")InvoiceDetails invoiceDetails , @RequestParam(value = "id" , required = false) Long[] id , BindingResult bindingResult , Model model) {

        List<Invoice> invoices = invoiceDetails.getInvoices();
        System.out.println(invoices);
        System.out.println(id);

        /* if(id != null) {
            Invoice invoice = null ;
            for (int i = 0; i < id.length; i++) {

                if(InvoiceService.isFound(id[i])) {
                    invoice = new Invoice();
                    invoice.setId(id[i]);
                    invoiceDetails.getInvoices().add(invoice);

            }
            for (int s = 0; i < invoiceDetails.getInvoices().size(); i++) {
                System.out.println(invoiceDetails.getInvoices().get(i));
            }*/
        return "redirect:/invoicing/processInvoices/processInvoiceForm";
        }

}