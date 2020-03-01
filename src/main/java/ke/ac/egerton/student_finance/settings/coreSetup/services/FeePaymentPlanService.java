package ke.ac.egerton.student_finance.settings.coreSetup.services;

import ke.ac.egerton.student_finance.settings.coreSetup.models.FeePaymentPlan;

import java.util.List;

public interface FeePaymentPlanService {

    FeePaymentPlan saveFeePaymentPlan(FeePaymentPlan feePaymentPlan);

    FeePaymentPlan updateFeePaymentPlan(FeePaymentPlan feePaymentPlan);

    List< FeePaymentPlan > getAllFeePaymentPlan();

    FeePaymentPlan getFeePaymentPlanById(long id);

    FeePaymentPlan getFeePaymentPlanByCode(String code);

    void deleteFeePaymentPlan(String code);
}
