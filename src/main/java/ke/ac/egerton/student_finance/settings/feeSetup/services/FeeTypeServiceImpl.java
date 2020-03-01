package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeType;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeeTypeServiceImpl implements FeeTypeService {

    @Autowired
    FeeTypeRepository feeTypeRepository;


    @Override
    public FeeType saveFeeType(FeeType feeType) {
        return feeTypeRepository.save(feeType);
    }

    @Override
    public FeeType updateFeeType(FeeType feeType) {
        return null;
    }

    @Override
    public List<FeeType> getAllFeeType() {
        return this.feeTypeRepository.findAll();
    }

    @Override
    public FeeType getFeeTypeById(long id) {
        return this.feeTypeRepository.findOne(id);
    }

    @Override
    public void deleteFeeType(long id) {

    }
}
