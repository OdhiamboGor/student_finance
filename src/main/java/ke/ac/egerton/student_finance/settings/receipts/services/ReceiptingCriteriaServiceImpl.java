package ke.ac.egerton.student_finance.settings.receipts.services;

import ke.ac.egerton.student_finance.settings.receipts.models.ReceiptingCriteria;
import ke.ac.egerton.student_finance.settings.receipts.repositories.ReceiptingCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptingCriteriaServiceImpl implements ReceiptingCriteriaService{

    @Autowired
    ReceiptingCriteriaRepository receiptingCriteriaRepository;

    @Override
    public ReceiptingCriteria saveReceiptingCriteria(ReceiptingCriteria receiptingCriteria) {
        return receiptingCriteriaRepository.save(receiptingCriteria);
    }

    @Override
    public ReceiptingCriteria updateReceiptingCriteria(ReceiptingCriteria criteria) {
       return receiptingCriteriaRepository.save(criteria);
    }

    @Override
    public List<ReceiptingCriteria> getAllReceiptingCriteria() {
        return this.receiptingCriteriaRepository.findAll();
    }

    @Override
    public ReceiptingCriteria getReceiptingCriteriaById(long id) {
        return this.receiptingCriteriaRepository.findOne(id);
    }

    @Override
    public ReceiptingCriteria getReceiptingCriteriaByCode(String code) {
        return null;
    }

    @Override
    public void deleteReceiptingCriteria(long id) {

    }

    @Override
    public void deleteReceiptingCriteria(ReceiptingCriteria receiptingCriteria) {

    }
}
