package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.ChargeType;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.ChargeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChargeTypeServiceImpl implements ChargeTypeService {

    @Autowired
    ChargeTypeRepository chargeTypeRepository;

    @Override
    public ChargeType saveChargeType(ChargeType chargeType) {
        return chargeTypeRepository.save(chargeType);
    }

    @Override
    public ChargeType updateChargeType(ChargeType chargeType) {
        return null;
    }

    @Override
    public List<ChargeType> getAllChargeType() {
        return this.chargeTypeRepository.findAll();
    }

    @Override
    public ChargeType getChargeTypeById(long id) {
        return this.chargeTypeRepository.findOne(id);
    }

    @Override
    public ChargeType getChargeTypeByCode(String code) {
        return null;
    }

    @Override
    public void deleteChargeType(long id) {

    }
}
