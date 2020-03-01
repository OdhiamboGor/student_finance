package ke.ac.egerton.student_finance.thirdPartyPayments.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "errorCorrection")
public class ErrorCorrectionsController {

    @RequestMapping(method = RequestMethod.GET)
    public String errorForm(){
        return "thirdPartyPayments/errorCorrectionForm";
    }
}
