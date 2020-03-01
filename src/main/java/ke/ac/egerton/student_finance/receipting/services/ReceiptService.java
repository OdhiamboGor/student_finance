package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptService {

    Receipt saveReceipt(Receipt receipt);

    Receipt updateReceipt(Receipt receipt);

    List<Receipt> getAllReceipt();

    Receipt getReceiptById(long id);

    Receipt getReceiptByCode(String code);

    void deleteReceipt(String code);

    void deleteReceipt(Receipt receipt);

}
