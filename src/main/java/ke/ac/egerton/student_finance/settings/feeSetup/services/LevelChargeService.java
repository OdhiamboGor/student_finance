package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.LevelCharge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LevelChargeService {

    LevelCharge saveLevelCharge(LevelCharge levelCharge);

    LevelCharge updateLevelCharge(LevelCharge levelCharge);

    List<LevelCharge> getAllLevelCharge();

    LevelCharge getLevelChargeById(long id);

    LevelCharge getLevelChargeByCode(String code);

    void deleteLevelCharge(long id);
}
