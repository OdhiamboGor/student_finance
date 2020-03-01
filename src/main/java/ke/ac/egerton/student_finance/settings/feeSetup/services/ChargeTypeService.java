package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChargeTypeService {

    ChargeType saveChargeType(ChargeType chargeType);

    ChargeType updateChargeType(ChargeType chargeType);

    List<ChargeType> getAllChargeType();

    ChargeType getChargeTypeById(long id);

    ChargeType getChargeTypeByCode(String code);

    void deleteChargeType(long id);
}
