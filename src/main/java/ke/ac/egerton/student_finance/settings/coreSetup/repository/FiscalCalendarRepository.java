package ke.ac.egerton.student_finance.settings.coreSetup.repository;


import ke.ac.egerton.student_finance.settings.coreSetup.models.FiscalCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiscalCalendarRepository extends JpaRepository<FiscalCalendar, Long> {

}
