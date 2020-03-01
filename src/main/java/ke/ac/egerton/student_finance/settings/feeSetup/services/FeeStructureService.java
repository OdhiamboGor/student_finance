package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeStructure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeeStructureService {

    FeeStructure saveFeeStructure(FeeStructure feeStructure);

    FeeStructure updateFeeStructure(FeeStructure feeStructure);

    List<FeeStructure> getAllFeeStructure();

    FeeStructure getFeeStructureById(long id);

    FeeStructure getFeeStructureByCode(String code);

    void deleteFeeStructure(long id);
}
