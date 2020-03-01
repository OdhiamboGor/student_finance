package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeStructure;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.FeeStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeeStructureServiceImpl implements FeeStructureService{

    @Autowired
    FeeStructureRepository feeStructureRepository;

    @Override
    public FeeStructure saveFeeStructure(FeeStructure feeStructure) {
        return feeStructureRepository.save(feeStructure);
    }

    @Override
    public FeeStructure updateFeeStructure(FeeStructure feeStructure) {
        return null;
    }

    @Override
    public List<FeeStructure> getAllFeeStructure() {
        return this.feeStructureRepository.findAll();
    }

    @Override
    public FeeStructure getFeeStructureById(long id) {
        return this.feeStructureRepository.findOne(id);
    }

    @Override
    public FeeStructure getFeeStructureByCode(String code) {
        return null;
    }

    @Override
    public void deleteFeeStructure(long id) {

    }
}
