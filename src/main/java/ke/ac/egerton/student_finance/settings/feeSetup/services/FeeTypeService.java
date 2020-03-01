package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.FeeType;
import ke.ac.egerton.student_finance.settings.feeSetup.models.LevelCharge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeeTypeService {

    FeeType saveFeeType(FeeType feeType);

    FeeType updateFeeType(FeeType feeType);

    List<FeeType> getAllFeeType();

    FeeType getFeeTypeById(long id);

    void deleteFeeType(long id);
}
