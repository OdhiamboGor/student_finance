package ke.ac.egerton.student_finance.receipting.controllers;

import ke.ac.egerton.models.Student;
import ke.ac.egerton.student_finance.receipting.controllers.validation.ReceiptDetails;
import ke.ac.egerton.student_finance.receipting.models.CancelReceipt;
import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.repositories.CancelReceiptRepository;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptRepository;
import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankRepository;
import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import ke.ac.egerton.student_finance.settings.payment.models.PaymentGateway;
import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.PaymentGatewayRepository;
import ke.ac.egerton.student_finance.student.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(path = "receipting/cancelReceipts")
public class CancelReceiptController {

    @Autowired
    ReceiptRepository receiptRepository;
    @Autowired
    CancelReceiptRepository cancelReceiptRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    PaymentGatewayRepository paymentGatewayRepository;


    @RequestMapping(path="cancelReceipt", method = RequestMethod.POST)
    public String cancelReceipt(@Valid ReceiptDetails details, BindingResult result, Model model) throws ParseException {

        CancelReceipt cancelReceipt = new CancelReceipt();

        String status = "Cancelled";
        //Getting batch ID
        cancelReceipt.setBatchId(details.getBatchId());
        Long batchId = details.getBatchId();

        //Getting receipt number
        cancelReceipt.setReceiptNumber(details.getReceiptNumber());
        String rcNo = details.getReceiptNumber();

        BigDecimal amount =details.getReceiptAmount();
        cancelReceipt.setAmount(amount);

        //Setting receipt type
        String rType = details.getReceiptType();
        System.out.println(rType);
        cancelReceipt.setReceiptType(rType);

        //Getting student number
        cancelReceipt.setCustomerId(details.getCustomerId());
        String custId = details.getCustomerId();

        Student student = studentsRepository.findByAccountNumber(details.getCustomerId());
        cancelReceipt.setStudentNumber(student.getStudentNumber());
        String stdNo = student.getStudentNumber();

        //Getting student name
        cancelReceipt.setFullName(student.getFullName());
        String name = student.getFullName();

        //Splitting receipt number into two parts and using it to get other details
        String[] parts = rcNo.split("-");

        String rcNo1 = parts[0];
        String rcNo2 = parts[1];
        Bank bank = bankRepository.findTopByCode(rcNo1);

        ReceiptType receiptType = bank.getReceiptType();
        PayeeGroup payeeGroup = receiptType.getPayeeGroup();
        String grName = payeeGroup.getName();
        cancelReceipt.setReceiptType(grName);

        //Cancel reason
        String reason = details.getReason();
        cancelReceipt.setReason(reason);

        //Setting posted status
        String post  = details.getPosted();
        int posts = 0;
        switch(post){
            case "No":
                posts =0;
                break;
            case "Yes" :
                posts = 1 ;
                break;
        }
        int posted = posts;
        cancelReceipt.setPosted(posted);

        String dt = details.getReceiptDate();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD");
        Date date = (Date)formatter.parse(dt);
        cancelReceipt.setReceiptDate(date);

        //Setting cancelled
        int canc = details.getCancelled();
        cancelReceipt.setCancelled(canc);


        Long dtu = details.getReceiptDateUF();
        cancelReceipt.setRcDateUF(dtu);

        //cancelReceipt.setAmount(receipt.getHomeAmount());
        //cancelReceipt.setCancelled(receipt.getCa);
        //cancelReceipt.setUserId();
        //cancelReceipt.setCancelledDate(receipt.ge);
        //cancelReceipt.setReason(receipt.getReas);
        cancelReceipt.setStatus(status);
        //cancelReceipt.setUserId(details.getAudit().getUsername());
        cancelReceiptRepository.save(cancelReceipt);

        //Updating receipt status in receipt details
        Receipt receipt = receiptRepository.findByReceiptNumber(rcNo);

        String stat = "Cancelled";
        receipt.setReceiptSstatus(stat);

        //cancelReceiptRepository.updateReceiptStatus(status,id);
        return "redirect:/receipting/receipt/cancelReceiptForm";
    }
}
