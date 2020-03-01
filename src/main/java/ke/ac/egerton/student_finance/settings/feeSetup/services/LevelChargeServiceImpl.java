package ke.ac.egerton.student_finance.settings.feeSetup.services;

import ke.ac.egerton.student_finance.settings.feeSetup.models.LevelCharge;
import ke.ac.egerton.student_finance.settings.feeSetup.repositories.LevelChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LevelChargeServiceImpl implements LevelChargeService{

    @Autowired
    LevelChargeRepository levelChargeRepository;

    @Override
    public LevelCharge saveLevelCharge(LevelCharge levelCharge) {
        return levelChargeRepository.save(levelCharge);
    }

    @Override
    public LevelCharge updateLevelCharge(LevelCharge levelCharge) {
        return null;
    }

    @Override
    public List<LevelCharge> getAllLevelCharge() {
        return this.levelChargeRepository.findAll();
    }

    @Override
    public LevelCharge getLevelChargeById(long id) {
        return this.levelChargeRepository.findOne(id);
    }

    @Override
    public LevelCharge getLevelChargeByCode(String code) {
        return null;
    }

    @Override
    public void deleteLevelCharge(long id) {

    }
}
