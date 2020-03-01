package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReceiptBatchService {

    ReceiptBatch saveReceiptBatch(ReceiptBatch receiptBatch);

    ReceiptBatch updateReceiptBatch(ReceiptBatch receiptBatch);

    List<ReceiptBatch> getAllReceiptBatch();

    ReceiptBatch getReceiptBatchById(long id);

    ReceiptBatch getReceiptBatchByCode(String code);

    void deleteReceiptBatch(String code);

    void deleteReceiptBatch(ReceiptBatch receiptBatch);



}
