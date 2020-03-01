package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.FiscalCalendar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FiscalCalendarService {

    FiscalCalendar saveFiscalCalendar(FiscalCalendar fiscalCalendar);

    FiscalCalendar updateFiscalCalendar(FiscalCalendar fiscalCalendar);

    List< FiscalCalendar > getAllFiscalCalendar();

    FiscalCalendar getFiscalCalendarById(long id);

    FiscalCalendar getFiscalCalendarByCode(String code);

    void deleteFiscalCalendar(String code);

    void deleteFiscalCalendar(Long id);
}
