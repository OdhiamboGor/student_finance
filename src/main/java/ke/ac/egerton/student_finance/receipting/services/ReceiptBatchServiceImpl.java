package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptBatchServiceImpl implements ReceiptBatchService{

    @Autowired
    ReceiptBatchRepository receiptBatchRepository;

    @Override
    public ReceiptBatch saveReceiptBatch(ReceiptBatch receiptBatch) {
        return receiptBatchRepository.save(receiptBatch);
    }

    @Override
    public ReceiptBatch updateReceiptBatch(ReceiptBatch receiptBatch) {

        return this.receiptBatchRepository.save(receiptBatch);
    }

    @Override
    public List<ReceiptBatch> getAllReceiptBatch() {
        return this.receiptBatchRepository.findAll();
    }

    @Override
    public ReceiptBatch getReceiptBatchById(long id) {
        return this.receiptBatchRepository.findOne(id);
    }

    @Override
    public ReceiptBatch getReceiptBatchByCode(String code) {
        return null;
    }

    @Override
    public void deleteReceiptBatch(String code) {

    }

    @Override
    public void deleteReceiptBatch(ReceiptBatch receiptBatch) {
    }

}
