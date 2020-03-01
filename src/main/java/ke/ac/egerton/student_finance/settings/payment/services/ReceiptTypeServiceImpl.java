package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.ReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.ReceiptTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptTypeServiceImpl implements ReceiptTypeService{

    @Autowired
    ReceiptTypeRepository receiptTypeRepository;

    @Override
    public ReceiptType saveReceiptType(ReceiptType receiptType) {
        return receiptTypeRepository.save(receiptType);
    }

    @Override
    public ReceiptType updateReceiptType(ReceiptType receiptType) {
        return null;
    }

    @Override
    public List<ReceiptType> getAllReceiptType() {
        return this.receiptTypeRepository.findAll();
    }

    @Override
    public ReceiptType getReceiptTypeById(long id) {
        return this.receiptTypeRepository.findOne(id);
    }

    @Override
    public ReceiptType getReceiptTypeByCode(String code) {
        return null;
    }

    @Override
    public void deleteReceiptType(long id) {

    }
}
