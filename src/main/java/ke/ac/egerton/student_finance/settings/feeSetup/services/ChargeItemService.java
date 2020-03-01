package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChargeItemService {

    ChargeItem saveChargeItem(ChargeItem chargeItem);

    ChargeItem updateChargeItem(ChargeItem chargeItem);

    List<ChargeItem> getAllChargeItem();

    ChargeItem getChargeItemById(long id);

    ChargeItem getChargeItemByCode(String code);

    void deleteChargeItem(long id);
}
