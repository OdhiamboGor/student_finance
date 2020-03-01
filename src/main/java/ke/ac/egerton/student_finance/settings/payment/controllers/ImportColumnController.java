package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.payment.controllers.validation.ImportColumnDetails;
import ke.ac.egerton.student_finance.settings.payment.models.ImportColumn;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.repository.ImportColumnRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import ke.ac.egerton.student_finance.settings.payment.services.ImportColumnService;
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
@RequestMapping(path = "settings/importColumn")
public class ImportColumnController {

    //Autwired Repositories
    @Autowired
    ImportColumnRepository importColumnRepository;
    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;

    //Autowired Services
    @Autowired
    ImportColumnService importColumnService;


    @RequestMapping(path = "importColumnList", method = RequestMethod.GET)
    public String importColumnList(Model model){
        List<ImportColumn> column = importColumnRepository.findAll();
        model.addAttribute("column", column);
        return "settings/payment/column";
    }

    @RequestMapping(path = "addImportColumn", method = RequestMethod.GET)
    public String addImportColumn(Model model){
        List<PaymentGateway> paymentGateway = paymentGatewayRepository.findAll();
        model.addAttribute("paymentGateway", paymentGateway);

        return "settings/payment/addImportColumn";
    }

    @RequestMapping(path = "addImportColumn", method = RequestMethod.POST)
    public String saveImportColumn(@ModelAttribute("details") ImportColumnDetails details, BindingResult result, Model model){
        String syscol = details.getSysColumn();
        String gateWayCol = details.getGatewayColumn();
        String gate = details.getGateway();
        Boolean val = details.getValidate();
        String form = details.getFormat();

        System.out.print(syscol);
        System.out.print("\n");

        System.out.print(gateWayCol);
        System.out.print("\n");

        System.out.print(gate);
        System.out.print("\n");

        System.out.print(val);
        System.out.print("\n");

        System.out.print(form);
        System.out.print("\n");


        PaymentGateway paymentGateway = paymentGatewayRepository.findByCode(gate);

        ImportColumn importColumn = new ImportColumn();

        importColumn.setSysColumn(syscol);
        importColumn.setGatewayColumn(gateWayCol);
        importColumn.setGateway(paymentGateway);
        importColumn.setValidate(val);
        importColumn.setFormat(form);

        importColumnRepository.save(importColumn);

        return "redirect:/settings/importColumn/importColumnList";

    }

    @RequestMapping(path="editImportColumn/{id}", method = RequestMethod.GET)
    public String editImportColumn(@PathVariable("id") long id, Model model){
        ImportColumn importColumn = importColumnRepository.findOne(id);
        List<PaymentGateway> paymentGateway = paymentGatewayRepository.findAll();

        model.addAttribute("importColumn", importColumn);
        model.addAttribute("paymentGateway", paymentGateway);
        return "settings/payment/editImportColumn";
    }

    @RequestMapping(path="editImportColumn/{id}", method = RequestMethod.POST)
    public String updateImportColumn(@PathVariable("id") long id, @Valid ImportColumnDetails details, BindingResult result, Model model){

        ImportColumn importColumn = importColumnRepository.findOne(id);

        String syscol = details.getSysColumn();
        String gateWayCol = details.getGatewayColumn();
        String gateway = details.getGateway();
        Boolean val = details.getValidate();
        String form = details.getFormat();

        System.out.print(syscol);
        System.out.print(gateWayCol);
        System.out.print(gateway);
        System.out.print(val);
        System.out.print(form);

        PaymentGateway paymentGateway = paymentGatewayRepository.findByCode(gateway);

        System.out.print(paymentGateway);

        importColumn.setSysColumn(syscol);
        importColumn.setGatewayColumn(gateWayCol);
        importColumn.setGateway(paymentGateway);
        importColumn.setValidate(val);
        importColumn.setFormat(form);

        importColumnRepository.save(importColumn);

        return "redirect:/settings/importColumn/importColumnList";

    }

    @RequestMapping(path="deleteImportColumn/{id}", method = RequestMethod.GET)
    public String deleteImportColumn(@PathVariable("id") long id, Model model){
        ImportColumn importColumn =  importColumnRepository.findOne(id);
        if(importColumn==null){
            model.addAttribute("error", "No record found");

        }
        importColumnService.deleteImportColumn(importColumn);
        model.addAttribute("msg", "Deleted Successfully");
        return "redirect:/settings/importColumn/importColumnList";
    }
}
