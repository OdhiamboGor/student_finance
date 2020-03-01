package ke.ac.egerton.student_finance.settings.period.services;

import ke.ac.egerton.student_finance.settings.period.models.SFPeriod;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SFPeriodService {

    SFPeriod saveSFPeriod(SFPeriod period);

    SFPeriod updateSFPeriod(SFPeriod period);

    List<SFPeriod> getAllSFPeriod();

    SFPeriod getSFPeriodById(long id);

    SFPeriod getSFPeriodByCode(Long code);

    void deleteSFPeriod(long id);

    void deleteSFPeriod(SFPeriod Period);
}
