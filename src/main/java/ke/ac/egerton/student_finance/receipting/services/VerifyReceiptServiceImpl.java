package ke.ac.egerton.student_finance.receipting.services;

import ke.ac.egerton.student_finance.receipting.models.Receipt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyReceiptServiceImpl implements VerifyReceiptService{
    @Override
    public Receipt updateReceiptStatus(Boolean posted) {

        return null;
    }
}
