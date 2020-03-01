package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.FiscalCalendar;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FiscalCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FiscalCalendarServiceImpl implements FiscalCalendarService {

    @Autowired
    FiscalCalendarRepository fiscalCalendarRepository;


    @Override
    public FiscalCalendar saveFiscalCalendar(FiscalCalendar fiscalCalendar) {
        return fiscalCalendarRepository.save(fiscalCalendar);
    }

    @Override
    public FiscalCalendar updateFiscalCalendar(FiscalCalendar fiscalCalendar) {
        return null;
    }

    @Override
    public List<FiscalCalendar> getAllFiscalCalendar() {
        return null;
    }

    @Override
    public FiscalCalendar getFiscalCalendarById(long id) {
        return this.fiscalCalendarRepository.findOne(id);
    }

    @Override
    public FiscalCalendar getFiscalCalendarByCode(String code) {
        return null;
    }

    @Override
    public void deleteFiscalCalendar(String code) {

    }

    @Override
    public void deleteFiscalCalendar(Long id) {

    }
}
