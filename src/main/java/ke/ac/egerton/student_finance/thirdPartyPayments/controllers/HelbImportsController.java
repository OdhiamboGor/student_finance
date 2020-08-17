package ke.ac.egerton.student_finance.thirdPartyPayments.controllers;

import ke.ac.egerton.student_finance.thirdPartyPayments.services.HelbImportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class gHelbImportsController {

    @Autowired
    private HelbImportsService helbImportsService;
}
