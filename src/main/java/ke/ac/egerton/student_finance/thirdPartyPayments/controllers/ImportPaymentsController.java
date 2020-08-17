package ke.ac.egerton.student_finance.thirdPartyPayments.controllers;

import ke.ac.egerton.models.academic.AcademicYear;
import ke.ac.egerton.models.academic.Session;
import ke.ac.egerton.models.dao.academic.AcademicYearRepository;
import ke.ac.egerton.models.dao.academic.SessionRepository;
import ke.ac.egerton.student_finance.quickDocuments.models.Batches;
import ke.ac.egerton.student_finance.quickDocuments.repositories.BatchRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import ke.ac.egerton.student_finance.thirdPartyPayments.models.HelbImports;
import ke.ac.egerton.student_finance.thirdPartyPayments.models.ThirdPartyProcesses;
import ke.ac.egerton.student_finance.thirdPartyPayments.repositories.HelbImportsRepository;
import ke.ac.egerton.student_finance.thirdPartyPayments.repositories.ThirdPartyProcessesRepository;
import ke.ac.egerton.student_finance.thirdPartyPayments.services.HelbImportsService;
import ke.ac.egerton.student_finance.thirdPartyPayments.services.ThirdPartyPaymentService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "thirdPartyPayments/importPayments")
public class ImportPaymentsController {

    //Autowired Repositories
    @Autowired
    ThirdPartyProcessesRepository thirdPartyProcessesRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
    @Autowired
    BatchRepository batchRepository;
    @Autowired
    AcademicYearRepository academicYearRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    HelbImportsRepository helbImportsRepository;

    //Autowired Services
    @Autowired
    ThirdPartyPaymentService thirdPartyPaymentService;
    @Autowired
    HelbImportsService helbImportsService;


    @RequestMapping(value = "importForm", method = RequestMethod.GET)
    public String importPayments(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("category", categories);

        List<ThirdParty> thirdParty = thirdPartyRepository.findAll();
        model.addAttribute("thirdParty", thirdParty);


        List<Batches> batches = batchRepository.findByPostFalse();
        System.out.println(batches);
        model.addAttribute("batches", batches);

        List<AcademicYear> academicYears = academicYearRepository.findAll();
        model.addAttribute("acYears", academicYears);

        List<Session> sessions = sessionRepository.findAll();
        model.addAttribute("sess", sessions);

        return "thirdPartyPayments/importPayments";
    }

    @RequestMapping(value = "loadThirdParty", headers = "Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody
    List<ThirdPartyProcesses> loadThirdParty(@RequestParam(value = "code", required = true) String code) throws IllegalStateException {

        //Specify the returning object you want here
        return thirdPartyPaymentService.loadThirdPartyProcess(code);

    }

      @RequestMapping(value = "importHelb", method = RequestMethod.POST)
      public String importHelb(@ModelAttribute HelbImports helbImports, RedirectAttributes redirectAttributes){

          boolean isFlag = helbImportsService.uploadHelb(helbImports.getFile());
          if(isFlag){
              redirectAttributes.addFlashAttribute("successmessage", "File uploaded successfully");
          }
          else{
              redirectAttributes.addFlashAttribute("errormessage", "File not uploaded  successfully");
          }

          return "redirect:/thirdPartyPayments/importPayments/importForm";

      }

}
