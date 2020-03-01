package ke.ac.egerton.student_finance.thirdPartyPayments.controllers;

import ke.ac.egerton.student_finance.settings.thirdParty.models.Category;
import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.CategoryRepository;
import ke.ac.egerton.student_finance.settings.thirdParty.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "thirdPartyPayments/thirdPartyProcess")
public class ThirdPartyProcessesController {

    //Autowired Repositories
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @RequestMapping(path = "thirdPartyProcessForm",method = RequestMethod.GET)
    public String thirdPartyProcessForm(Model model){
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("category", categories);

        List<ThirdParty> thirdParty= thirdPartyRepository.findAll();
        model.addAttribute("thirdParty",thirdParty);
        return "thirdPartyPayments/thirdPartyProcess";
    }
}
