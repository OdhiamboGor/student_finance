package ke.ac.egerton.student_finance.settings.coreSetup.controllers;

import ke.ac.egerton.student_finance.settings.coreSetup.models.FiscalCalendar;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FiscalCalendarRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.services.FiscalCalendarService;
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
@RequestMapping(path = "settings/fiscalCalendar")
public class FiscalCalendarController {

    //Autowired Repositories
    @Autowired
    FiscalCalendarRepository fiscalCalendarRepository;

    //Autowired Services
    @Autowired
    FiscalCalendarService fiscalCalendarService;

    @RequestMapping(path ="fiscalCalendar", method = RequestMethod.GET)
    public String fiscalCalendarList(Model model){
        List<FiscalCalendar> calendars = fiscalCalendarRepository.findAll();
        model.addAttribute("calendars", calendars);
        return "settings/coreSetup/calendar";
    }

    @RequestMapping(path="addFiscalCalendar", method = RequestMethod.GET)
    public String addFiscalCalendar(){
        return "settings/coreSetup/addFiscalCalendar";
    }

    @RequestMapping(path="addFiscalCalendar", method = RequestMethod.POST)
    public String saveFiscalCalendar(@Valid @ModelAttribute("fiscalCalendar") FiscalCalendar fiscalCalendar, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "redirect:/settings/fiscalCalendar/addFiscalCalendar";
        }
        model.addAttribute("fiscalCalendar", new FiscalCalendar());

        fiscalCalendarService.saveFiscalCalendar(fiscalCalendar);
        return "redirect:/settings/fiscalCalendar/fiscalCalendar";
    }

    @RequestMapping(path="/editFiscalCalendar/{id}", method = RequestMethod.GET)
    public String editFiscalCalendar(@PathVariable("id") long id, Model model){
        FiscalCalendar fiscalCalendar = fiscalCalendarService.getFiscalCalendarById(id);
        model.addAttribute("fiscalCalendar", fiscalCalendar);
        return "settings/coreSetup/editFiscalCalendar";
    }

    @RequestMapping(path="/updateFiscalCalendar/{id}", method = RequestMethod.POST)
    public String updateFiscalCalendar(@PathVariable("id") long id, @Valid FiscalCalendar fiscalCalendar, BindingResult result, Model model){
        if (result.hasErrors()) {
            fiscalCalendar.setId(id);
            return "redirect:settings/fiscalCalendar/editFiscalCalendar";
        }

        fiscalCalendarService.saveFiscalCalendar(fiscalCalendar);
        return "redirect:/settings/fiscalCalendar/fiscalCalendar";
    }

}
