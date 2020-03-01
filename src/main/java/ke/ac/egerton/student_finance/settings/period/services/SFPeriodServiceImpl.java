package ke.ac.egerton.student_finance.settings.period.services;

import ke.ac.egerton.student_finance.settings.period.models.SFPeriod;
import ke.ac.egerton.student_finance.settings.period.repositories.SFPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SFPeriodServiceImpl implements SFPeriodService {


    @Autowired
    SFPeriodRepository periodRepository;


    @Override
    public SFPeriod saveSFPeriod(SFPeriod period) {
        return periodRepository.save(period);
    }

    @Override
    public SFPeriod updateSFPeriod(SFPeriod period) {
        return null;
    }

    @Override
    public List<SFPeriod> getAllSFPeriod() {
        return this.periodRepository.findAll();
    }

    @Override
    public SFPeriod getSFPeriodById(long id) {
        return this.periodRepository.findOne(id);
    }

    @Override
    public SFPeriod getSFPeriodByCode(Long code) {
        return this.periodRepository.findOne(code);
    }

    @Override
    public void deleteSFPeriod(long id) {

    }

    @Override
    public void deleteSFPeriod(SFPeriod Period) {

    }
}
