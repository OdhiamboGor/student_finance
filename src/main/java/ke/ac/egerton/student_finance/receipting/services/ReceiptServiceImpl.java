package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import ke.ac.egerton.student_finance.receipting.repositories.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService{

    @Autowired
    ReceiptRepository receiptRepository;

    @Override
    public Receipt saveReceipt(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt updateReceipt(Receipt receipt) {
        return this.receiptRepository.save(receipt);
    }

    @Override
    public List<Receipt> getAllReceipt() {
        return this.receiptRepository.findAll();
    }

    @Override
    public Receipt getReceiptById(long id) {
        return this.receiptRepository.findOne(id);
    }

    @Override
    public Receipt getReceiptByCode(String code) {
        return this.receiptRepository.findByReceiptNumber(code);
    }

    @Override
    public void deleteReceipt(String code) {

    }

    @Override
    public void deleteReceipt(Receipt receipt) {

    }

}
