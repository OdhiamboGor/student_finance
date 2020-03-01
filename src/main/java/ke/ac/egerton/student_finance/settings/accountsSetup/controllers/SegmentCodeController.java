package ke.ac.egerton.student_finance.settings.accountsSetup.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.controllers.validation.SegmentCodeDetails;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSegment;
import ke.ac.egerton.student_finance.settings.accountsSetup.models.SegmentCode;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSegmentRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.SegmentCodeRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountSegmentService;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.SegmentCodeService;
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
@RequestMapping(path = "settings/segmentCode")
public class SegmentCodeController {

   //Autowired Repositories
   @Autowired
    SegmentCodeRepository segmentCodeRepository;
   @Autowired
    AccountSegmentRepository accountSegmentRepository;

    //Autowired Services
    @Autowired
    SegmentCodeService segmentCodeService;
    @Autowired
    AccountSegmentService accountSegmentService;

    @RequestMapping(path = "segmentCodeList", method = RequestMethod.GET)
    public String segmentCodeList(Model model){
        List <SegmentCode> code = segmentCodeRepository.findAll();
        model.addAttribute("code", code);

        return "settings/accountSetup/segmentCode";
    }

    @RequestMapping(path = "addSegmentCode", method = RequestMethod.GET)
    public String addSegmentCode(Model model){
        List <AccountSegment> segment = accountSegmentRepository.findAll();
        model.addAttribute("segment", segment);
        return "settings/accountSetup/addSegmentCode";
    }

    @RequestMapping(path="addSegmentCode", method = RequestMethod.POST)
    public String saveSegmentCode(@Valid @ModelAttribute("details") SegmentCodeDetails details, BindingResult result, Model model){
        String code = details.getCode();
        String name = details.getName();
        Long number = Long.valueOf(details.getSegment());

        AccountSegment accountSegment = accountSegmentService.getAccountSegmentByNumber(number);

        SegmentCode segmentCode = new SegmentCode();

        segmentCode.setCode(code);
        segmentCode.setName(name);
        segmentCode.setSegment(accountSegment);

        model.addAttribute("segmentCode", new SegmentCode());
        segmentCodeService.saveSegmentCode(segmentCode);
        return "redirect:/settings/segmentCode/segmentCodeList";
    }

    @RequestMapping(path="/editSegmentCode/{id}", method = RequestMethod.GET)
    public String editSegmentCode(@PathVariable("id") long id, Model model){
        SegmentCode segmentCode = segmentCodeRepository.findOne(id);
        model.addAttribute("segmentCode", segmentCode);
        List <AccountSegment> segment = accountSegmentRepository.findAll();
        model.addAttribute("segment", segment);

        return "settings/accountSetup/editSegmentCode";
    }

    @RequestMapping(path="/editSegmentCode/{id}", method = RequestMethod.POST)
    public String updateSegmentCode(@PathVariable("id") long id, @Valid SegmentCode segmentCode, BindingResult result, Model model){
        if (result.hasErrors()) {
            segmentCode.setId(id);
            return "/settings/segmentCode/editSegmentCode";
        }
        segmentCodeService.saveSegmentCode(segmentCode);
        return "redirect:/settings/segmentCode/segmentCodeList";
    }
}
