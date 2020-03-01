package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChargeItemServiceImpl implements ChargeItemService {

    @Autowired
    ChargeItemRepository chargeItemRepository;

    @Override
    public ChargeItem saveChargeItem(ChargeItem chargeItem) {
        return chargeItemRepository.save(chargeItem);
    }

    @Override
    public ChargeItem updateChargeItem(ChargeItem chargeItem) {
        return null;
    }

    @Override
    public List<ChargeItem> getAllChargeItem() {
        return this.chargeItemRepository.findAll();
    }

    @Override
    public ChargeItem getChargeItemById(long id) {
        return this.chargeItemRepository.findOne(id);
    }

    @Override
    public ChargeItem getChargeItemByCode(String code) {
        return null;
    }

    @Override
    public void deleteChargeItem(long id) {

    }
}
