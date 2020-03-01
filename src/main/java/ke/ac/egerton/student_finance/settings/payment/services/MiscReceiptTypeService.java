package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.MiscReceiptType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MiscReceiptTypeService {

    MiscReceiptType saveMiscReceiptType(MiscReceiptType miscReceiptType);

    MiscReceiptType updateMiscReceiptType(MiscReceiptType miscReceiptType);

    List<MiscReceiptType> getAllMiscReceiptType();

    MiscReceiptType getMiscReceiptTypeById(long id);

    MiscReceiptType getMiscReceiptTypeByCode(String code);

    void deleteMiscReceiptType(long id);
}
