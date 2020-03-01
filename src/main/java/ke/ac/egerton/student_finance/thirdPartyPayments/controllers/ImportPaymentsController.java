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
import ke.ac.egerton.student_finance.thirdPartyPayments.models.ThirdPartyProcesses;
import ke.ac.egerton.student_finance.thirdPartyPayments.repositories.ThirdPartyProcessesRepository;
import ke.ac.egerton.student_finance.thirdPartyPayments.services.ThirdPartyPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    
    //Autowired Services
    @Autowired
    ThirdPartyPaymentService thirdPartyPaymentService;


    @RequestMapping(method = RequestMethod.GET)
    public String importPayments(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("category", categories);

        List<ThirdParty> thirdParty= thirdPartyRepository.findAll();
        model.addAttribute("thirdParty",thirdParty);


        List<Batches> batches = batchRepository.findByPostFalse();
        System.out.println(batches);
        model.addAttribute("batches", batches);

        List<AcademicYear> academicYears = academicYearRepository.findAll();
        model.addAttribute("acYears", academicYears);

        List<Session> sessions = sessionRepository.findAll();
        model.addAttribute("sess", sessions);

        return "thirdPartyPayments/importPayments";
    }

    @RequestMapping(value = "/loadThirdParty", headers = "Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody
    List<ThirdPartyProcesses> loadThirdParty(@RequestParam(value = "code", required = true) String code) throws IllegalStateException {

        //Specify the returning object you want here
        return thirdPartyPaymentService.loadThirdPartyProcess(code);

    }
    @RequestMapping(value = "/thirdParties/{code}", method = RequestMethod.GET)
    public @ResponseBody  List<ThirdParty> getAllThirdParties(@PathVariable("code") String code) {
        //return thirdPartyRepository.findByCode(code);
        return null;

    }

   /* @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(User.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<User> users = csvToBean.parse();

                // TODO: save users in DB?

                // save users list on model
                model.addAttribute("users", users);
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "file-upload-status";
    }*/

   /* public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            logger.error("Error occurred while loading object list from file " + fileName, e);
            return Collections.emptyList();
        }*/
}
