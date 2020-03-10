package ke.ac.egerton.student_finance.invoicing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="invoicing/verifyDocuments")
public class VerifyDocumentsController {

    @RequestMapping(path="verifyDocument", method = RequestMethod.GET)
    public String verifyDocumentForm(Model model){

        return "invoicing/verifyDocuments/verifyDocumentForm";
    }
}
