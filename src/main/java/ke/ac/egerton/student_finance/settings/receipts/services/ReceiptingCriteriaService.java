package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptingCriteriaService {

    ReceiptingCriteria saveReceiptingCriteria(ReceiptingCriteria receiptingCriteria);

    ReceiptingCriteria updateReceiptingCriteria(ReceiptingCriteria criteria);

    List<ReceiptingCriteria> getAllReceiptingCriteria();

    ReceiptingCriteria getReceiptingCriteriaById(long id);

    ReceiptingCriteria getReceiptingCriteriaByCode(String code);

    void deleteReceiptingCriteria(long id);

    void deleteReceiptingCriteria(ReceiptingCriteria receiptingCriteria);
}
