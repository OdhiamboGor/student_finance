package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.FeePaymentPlan;
import ke.ac.egerton.student_finance.settings.coreSetup.repository.FeePaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeePaymentPlanServiceImpl implements FeePaymentPlanService{

    @Autowired
    private FeePaymentPlanRepository feePaymentPlanRepository;

    @Override
    public FeePaymentPlan saveFeePaymentPlan(FeePaymentPlan feePaymentPlan) {
        return feePaymentPlanRepository.save(feePaymentPlan);
    }

    @Override
    public FeePaymentPlan updateFeePaymentPlan(FeePaymentPlan feePaymentPlan) {
        return null;
    }

    @Override
    public List<FeePaymentPlan> getAllFeePaymentPlan() {
        return this.feePaymentPlanRepository.findAll();
    }

    @Override
    public FeePaymentPlan getFeePaymentPlanById(long id) {
        return this.feePaymentPlanRepository.findOne(id);
    }

    @Override
    public FeePaymentPlan getFeePaymentPlanByCode(String code) {
        return this.feePaymentPlanRepository.findByCode(code);
    }

    @Override
    public void deleteFeePaymentPlan(String code) {

    }
}
