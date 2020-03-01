package ke.ac.egerton.student_finance.settings.payment.controllers;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSetRepository;
import ke.ac.egerton.student_finance.settings.accountsSetup.service.AccountSetService;
import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import ke.ac.egerton.student_finance.settings.feeSetup.services.ChargeItemService;
import ke.ac.egerton.student_finance.settings.payment.controllers.validation.ReceiptTypeDetails;
import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.PayeeGroupRepository;
import ke.ac.egerton.student_finance.settings.payment.repository.ReceiptTypeRepository;
import ke.ac.egerton.student_finance.settings.payment.services.PayeeGroupService;
import ke.ac.egerton.student_finance.settings.payment.services.ReceiptTypeService;
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
@RequestMapping(path = "settings/receiptType")
public class ReceiptTypeController {

    //Autowired Repositories
    @Autowired
    ReceiptTypeRepository receiptTypeRepository;
    @Autowired
    PayeeGroupRepository payeeGroupRepository;
    @Autowired
    ChargeItemRepository chargeItemRepository;
    @Autowired
    AccountSetRepository accountSetRepository;

    //Autowired Services
    @Autowired
    ReceiptTypeService receiptTypeService;
    @Autowired
    PayeeGroupService payeeGroupService;
    @Autowired
    ChargeItemService chargeItemService;
    @Autowired
    AccountSetService accountSetService;


    @RequestMapping(path = "receiptTypeList", method = RequestMethod.GET)
    public String receiptTypeList(Model model) {
        List<ReceiptType> receipt = receiptTypeRepository.findAll();
        model.addAttribute("receipt", receipt);
        return "settings/payment/receipt";
    }

    @RequestMapping(path = "addReceiptType", method = RequestMethod.GET)
    public String addReceiptType(Model model) {

        List<PayeeGroup> payeeGroup = payeeGroupRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        List<AccountSet> accountSet = accountSetRepository.findAll();

        model.addAttribute("payeeGroup", payeeGroup);
        model.addAttribute("chargeItem", chargeItem);
        model.addAttribute("accountSet", accountSet);

        return "settings/payment/addReceiptType";
    }

    @RequestMapping(path = "addReceiptType", method = RequestMethod.POST)
    public String saveReceiptType(@ModelAttribute("details") ReceiptTypeDetails details, BindingResult result, Model model) {

        String code = details.getCode();
        String name = details.getName();
        String payee = details.getPayeeGroup();
        String item = details.getChargeItem();
        String account = details.getAccountSet();

        System.out.println(code);
        System.out.println(name);
        System.out.println(payee);
        System.out.println(item);
        System.out.println(account);

        PayeeGroup payeeGroup = payeeGroupRepository.findByCode(payee);
        ChargeItem chargeItem = chargeItemRepository.findByCode(item);
        AccountSet accountSet = accountSetRepository.findByCode(account);

        ReceiptType receiptType = new ReceiptType();

        receiptType.setCode(code);
        receiptType.setName(name);
        receiptType.setPayeeGroup(payeeGroup);
        receiptType.setChargeItem(chargeItem);
        receiptType.setAccountSet(accountSet);

        receiptTypeService.saveReceiptType(receiptType);
        return "redirect:/settings/receiptType/receiptTypeList";
    }

    @RequestMapping(path = "editReceiptType/{id}", method = RequestMethod.GET)
    public String editReceiptType(@PathVariable("id") long id, Model model) {
        ReceiptType receiptType = receiptTypeRepository.findOne(id);

        List<PayeeGroup> payeeGroup = payeeGroupRepository.findAll();
        List<ChargeItem> chargeItem = chargeItemRepository.findAll();
        List<AccountSet> accountSet = accountSetRepository.findAll();

        model.addAttribute("receiptType", receiptType);
        model.addAttribute("payeeGroup", payeeGroup);
        model.addAttribute("chargeItem", chargeItem);
        model.addAttribute("accountSet", accountSet);

        return "settings/payment/editReceiptType";
    }

    @RequestMapping(path = "editReceiptType/{id}", method = RequestMethod.POST)
    public String updateReceiptType(@PathVariable("id") long id, @Valid ReceiptTypeDetails details, BindingResult result, Model model){
        ReceiptType receiptType = receiptTypeRepository.findOne(id);

        String code = details.getCode();
        String name = details.getName();
        String payee = details.getPayeeGroup();
        String item = details.getChargeItem();
        String account = details.getAccountSet();

        System.out.print(code);
        System.out.print(name);
        System.out.print(payee);
        System.out.print(item);
        System.out.print(account);


        PayeeGroup payeeGroup = payeeGroupRepository.findByCode(payee);
        ChargeItem chargeItem = chargeItemRepository.findByCode(item);
        AccountSet accountSet = accountSetRepository.findByCode(account);

        System.out.print(payeeGroup);
        System.out.print(chargeItem);
        System.out.print(accountSet);


        receiptType.setCode(code);
        receiptType.setName(name);
        receiptType.setPayeeGroup(payeeGroup);
        receiptType.setChargeItem(chargeItem);
        receiptType.setAccountSet(accountSet);

        receiptTypeService.saveReceiptType(receiptType);

        return "redirect:/settings/payment/receiptTypeList";
}
}
