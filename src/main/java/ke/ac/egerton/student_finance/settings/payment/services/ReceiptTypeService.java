package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptTypeService {

    ReceiptType saveReceiptType(ReceiptType receiptType);

    ReceiptType updateReceiptType(ReceiptType receiptType);

    List<ReceiptType> getAllReceiptType();

    ReceiptType getReceiptTypeById(long id);

    ReceiptType getReceiptTypeByCode(String code);

    void deleteReceiptType(long id);
}
