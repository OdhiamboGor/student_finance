package ke.ac.egerton.student_finance.settings.coreSetup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ke.ac.egerton.student_finance.settings.coreSetup.models.FeePaymentPlan;

public interface FeePaymentPlanRepository extends JpaRepository<FeePaymentPlan, Long> {
    FeePaymentPlan findByCode(String code);

}
