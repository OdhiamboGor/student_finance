package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayeeGroupService {

    PayeeGroup savePayeeGroup(PayeeGroup payeeGroup);

    PayeeGroup updatePayeeGroup(PayeeGroup payeeGroup);

    List<PayeeGroup> getAllPayeeGroup();

    PayeeGroup getPayeeGroupById(long id);

    PayeeGroup getPayeeGroupByCode(String code);

    void deletePayeeGroup(long id);
}
