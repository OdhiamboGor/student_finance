package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.MiscReceiptType;
import ke.ac.egerton.student_finance.settings.payment.repository.MiscReceiptTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MiscReceiptTypeServiceImpl implements MiscReceiptTypeService{

    @Autowired
    MiscReceiptTypeRepository miscReceiptTypeRepository;

    @Override
    public MiscReceiptType saveMiscReceiptType(MiscReceiptType miscReceiptType) {
        return miscReceiptTypeRepository.save(miscReceiptType);
    }

    @Override
    public MiscReceiptType updateMiscReceiptType(MiscReceiptType miscReceiptType) {
        return null;
    }

    @Override
    public List<MiscReceiptType> getAllMiscReceiptType() {
        return this.miscReceiptTypeRepository.findAll();
    }

    @Override
    public MiscReceiptType getMiscReceiptTypeById(long id) {
        return this.miscReceiptTypeRepository.findOne(id);
    }

    @Override
    public MiscReceiptType getMiscReceiptTypeByCode(String code) {
        return null;
    }

    @Override
    public void deleteMiscReceiptType(long id) {

    }
}
