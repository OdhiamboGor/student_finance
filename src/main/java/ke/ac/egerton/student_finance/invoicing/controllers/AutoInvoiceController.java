package ke.ac.egerton.student_finance.invoicing.controllers;

import ke.ac.egerton.academic.admission.disciplinary.settings.FeeSegement;
import ke.ac.egerton.academic.admission.disciplinary.settings.FeeSegmentRepository;
import ke.ac.egerton.models.Student;
import ke.ac.egerton.models.academic.*;
import ke.ac.egerton.models.dao.academic.*;
import ke.ac.egerton.models.dao.places.CountryRegionRepository;
import ke.ac.egerton.models.places.CountryRegion;
import ke.ac.egerton.student_finance.invoicing.controllers.validation.InvoiceDetails;
import ke.ac.egerton.student_finance.invoicing.models.Invoice;
import ke.ac.egerton.student_finance.invoicing.repositories.InvoiceRepository;
import ke.ac.egerton.student_finance.invoicing.services.InvoiceService;
import ke.ac.egerton.student_finance.programme.repositories.ProgrammesRepository;
import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.models.FiscalCalendar;
import ke.ac.egerton.student_finance.settings.coreSetup.models.StudentRestriction;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FiscalCalendarRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.StudentRestrictionRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.FiscalCalendarService;
import ke.ac.egerton.student_finance.settings.coreSetup.services.StudentRestrictionService;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.model.ExchangeRate;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import ke.ac.egerton.student_finance.settings.currency.repository.ExchangeRateRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.controllers.FeeStructureController;
import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeStructure;
import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeType;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeStructureRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeTypeRepository;
import ke.ac.egerton.student_finance.settings.period.models.SFPeriod;
import ke.ac.egerton.student_finance.settings.period.repositories.SFPeriodRepository;
import ke.ac.egerton.student_finance.settings.period.services.SFPeriodService;
import ke.ac.egerton.student_finance.student.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(path = "invoicing/autoInvoice")
public class AutoInvoiceController {

    //Autowired repositories
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    StudentCategoryRepository  studentCategoryRepository;
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


    @RequestMapping(path="autoInvoice", method = RequestMethod.GET)
    public String autoInvoice (Model model){
        List<Batches> batches  = batchRepository.findByPostFalse();
        model.addAttribute("bat", batches);

        List<StudentRestriction> stRes = studentRestrictionRepository.findByRestrictions();
        model.addAttribute("stRes", stRes);

        List<StudentCategory> stdCat = studentCategoryRepository.findAll();
        model.addAttribute("stdCat", stdCat);

        List<FiscalCalendar> fcal = fiscalCalendarRepository.findAll();
        model.addAttribute("fcal", fcal);

        List<SFPeriod> periods = periodRepository.findAll();
        model.addAttribute("periods", periods);

        List<Currency> curr = currencyRepository.findAll();
        model.addAttribute("curr", curr);

        List<ExchangeRate> exch = exchangeRateRepository.findAll();
        model.addAttribute("exch", exch);

        List<Programme> prog = programmeRepository.findAll();
        model.addAttribute("prog", prog);

        List<CountryRegion> cRegion = countryRegionRepository.findAll();
        model.addAttribute("cRegion", cRegion);

        List<AcademicYear> academicYear = academicYearRepository.findAll();
        model.addAttribute("academicYear", academicYear);

        List<Session> sess = sessionRepository.findAll();
        model.addAttribute("sess", sess);

        List<FeeStructure> feeStr = feeStructureRepository.findAll();
        model.addAttribute("feeStr", feeStr);

        List<FeeType> feeType = feeTypeRepository.findAll();
        model.addAttribute("feeType", feeType);

        List<Campus> camp = campusRepository.findAll();
        model.addAttribute("camp", camp);

        return "invoicing/autoInvoiceForm";
    }

    @ResponseBody
    @RequestMapping(path="findCategory", method = RequestMethod.GET)
    public String student(@PathVariable("id") String id, Model model){
        List<Student> stud = studentsRepository.findOptF9(id);
        return null;
    }

    @RequestMapping(path="verifyDocument", method = RequestMethod.GET)
    public String verifyDoc(Model model){
        return "invoicing/verifyDocumentForm";
    }

    @RequestMapping(path="verifyInvoice", method = RequestMethod.GET)
    public String verifyInvoice(InvoiceDetails invoiceDetails, Model model){

        List<AcademicYear> academicYear = academicYearRepository.findAll();
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

        return "invoicing/verifyInvoiceForm";
    }

    @RequestMapping(path = "loadInvoices", method = RequestMethod.POST)
    public String listInvoices(InvoiceDetails invoiceDetails, Model model, RedirectAttributes r){

        String sesss = invoiceDetails.getSemesterCode();
        //System.out.println(sesss);

        String program = invoiceDetails.getProgrammeCode();
        //System.out.println(program);

        String campusCode = invoiceDetails.getCampusCode();
        //System.out.println(campusCode);

        String acYear = invoiceDetails.getAcademicYear();
        //System.out.println(acYear);

        String cHort = invoiceDetails.getChtCode();
        //System.out.println(cHort);

        String fseg = invoiceDetails.getSegCode();
        //System.out.println(fseg);

        List <Invoice> invoices = invoiceRepository.findBySemesterCodeAndCampusCodeAndProgrammeCodeAndAcademicYearAndChtCodeAndSegCode(sesss,campusCode,program, acYear,cHort,fseg);

        //Get sum of amount and put commas
        int totalAmount = invoices.stream().mapToInt(Invoice::getAmount).sum();
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String total = numberFormat.format(totalAmount);
        model.addAttribute("total", total);

        //int rec = invoices.size();
        //System.out.print(rec);

        //Check if list is empty
        if(invoices.isEmpty()){
            r.addFlashAttribute("error", "No Record Found");
            return "redirect:/invoicing/autoInvoice/verifyInvoice";

        }

        int pageNumber = 1 ;
        int size = 1 ;
        PageRequest page = new PageRequest(pageNumber, size);
       // List<Article> articlesList = articleTypedQuery.getResultList();
        int start = page.getOffset();
        int end = (start + page.getPageSize()) > invoices .size() ? invoices .size() : (start + page.getPageSize());
        int totalRows = invoices .size();
        Page<Invoice> pageToReturn = new PageImpl<Invoice>(invoices .subList(start, end), page, totalRows);




        model.addAttribute("invo", invoices);

        List<AcademicYear> academicYear = academicYearRepository.findAll();
        model.addAttribute("acadYear", academicYear);

        List<Programme> prog = programmesRepository.findAll(new Sort(Sort.Direction.ASC, "description"));
        model.addAttribute("prog", prog);

        List<Session> sess = sessionRepository.findAll();
        model.addAttribute("sess", sess);

        List<Campus> camp = campusRepository.findAll();
        model.addAttribute("camp", camp);

        List<Cohort> coh = cohortRepository.findAll(new Sort(Sort.Direction.ASC, "code"));
        model.addAttribute("coh", coh);

        model.addAttribute("invoice", invoiceDetails);

        return "invoicing/verifyInvoiceFormResult";
    }

    @RequestMapping(path = "updateInvoice/{id}", method = RequestMethod.POST)
    public String updateInvoice(@PathVariable Long id, InvoiceDetails invoiceDetails, RedirectAttributes r, Model model){





        Invoice invoice = invoiceRepository.findOne(id);
        System.out.println(invoice);

            return null;
    }
}
