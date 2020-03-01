package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.controllers.validation.SegmentMappingDetails;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSegment;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentMapping;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSegmentRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentCodeRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentMappingRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.SegmentCodeService;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.SegmentMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "settings/segmentMapping")
public class SegmentMappingController {

    //Autowired Repositories
    @Autowired
    SegmentMappingRepository segmentMappingRepository;
    @Autowired
    AccountSegmentRepository accountSegmentRepository;
    @Autowired
    SegmentCodeRepository segmentCodeRepository;

    //Autowired Services
    @Autowired
    SegmentMappingService segmentMappingService;

    @Autowired
    SegmentCodeService segmentCodeService;

    @RequestMapping(path="segmentMappingList", method = RequestMethod.GET)
    public String segmentMappingList(Model model){
        List <SegmentMapping> mapping = segmentMappingRepository.findAll();
        model.addAttribute("mapping", mapping);
        return "settings/accountSetup/mapping";
    }

    @RequestMapping(path = "addSegmentMapping", method = RequestMethod.GET)
    public String addSegmentMapping(Model model){
        List<AccountSegment> segment = accountSegmentRepository.findAll();
        List<SegmentCode> code = segmentCodeRepository.findAll();
        model.addAttribute("segment", segment);
        model.addAttribute("code",code);
        return "settings/accountSetup/addSegmentMapping";
    }

    @RequestMapping(path = "addSegmentMapping", method = RequestMethod.POST)
    public String saveSegmentMapping(@Valid @ModelAttribute("details") SegmentMappingDetails details, BindingResult result, Model model){

        String sys = details.getSysCode();
        String nam =details.getName();
        String co = details.getCode();
        Long number = details.getAccountSegment();
        String code = details.getSegmentCode();

        AccountSegment segment = accountSegmentRepository.findOne(number);

        SegmentCode segmentCode = segmentCodeRepository.findByCode(code);

        SegmentMapping segmentMapping = new SegmentMapping();

        segmentMapping.setSysCode(sys);
        segmentMapping.setName(nam);
        segmentMapping.setCode(co);
        segmentMapping.setAccountSegment(segment);
        segmentMapping.setSegmentCode(segmentCode);

        segmentMappingService.saveSegmentMapping(segmentMapping);

        return "redirect:/settings/segmentMapping/segmentMappingList";
    }

    @RequestMapping(path="/editSegmentMapping/{id}", method = RequestMethod.GET)
    public String editSegmentMapping(@PathVariable("id") long id, Model model){
        SegmentMapping mapping = segmentMappingService.getSegmentMappingById(id);
        List<AccountSegment> segment = accountSegmentRepository.findAll();
        List<SegmentCode> segmentCode = segmentCodeRepository.findAll();
        model.addAttribute("mapping",mapping);
        model.addAttribute("segment", segment);
        model.addAttribute("segmentCode",segmentCode);

        return "settings/accountSetup/editSegmentMapping";
    }

    @RequestMapping(path="/editSegmentMapping/{id}", method = RequestMethod.POST)
    public String updateSegmentMapping(SegmentMapping segmentMapping,@PathVariable("id") long id, @Valid SegmentMappingDetails details, BindingResult result, Model model){

        String sys = details.getSysCode();
        String nam =details.getName();
        String co = details.getCode();
        Long acc = details.getAccountSegment();
        String seg = details.getSegmentCode();

        AccountSegment segment =  accountSegmentRepository.findOne(acc);

        SegmentCode segmentCode = segmentCodeRepository.findByCode(seg);

        segmentMapping.setSysCode(sys);
        segmentMapping.setName(nam);
        segmentMapping.setCode(co);
        segmentMapping.setAccountSegment(segment);
        segmentMapping.setSegmentCode(segmentCode);

        segmentMappingService.saveSegmentMapping(segmentMapping);
        return "redirect:/settings/segmentMapping/segmentMappingList";
    }
}
