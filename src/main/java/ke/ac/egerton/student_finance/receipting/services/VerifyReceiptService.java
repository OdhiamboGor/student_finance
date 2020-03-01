package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import org.springframework.stereotype.Service;

@Service
public interface VerifyReceiptService {

    Receipt updateReceiptStatus(Boolean posted);
}
