package ke.ac.egerton.student_finance.settings.payment.services;

import ke.ac.egerton.student_finance.settings.payment.models.PayeeGroup;
import ke.ac.egerton.student_finance.settings.payment.repository.PayeeGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PayeeGroupServiceImpl implements PayeeGroupService {

    @Autowired
    PayeeGroupRepository payeeGroupRepository;

    @Override
    public PayeeGroup savePayeeGroup(PayeeGroup payeeGroup) {
        return payeeGroupRepository.save(payeeGroup);
    }

    @Override
    public PayeeGroup updatePayeeGroup(PayeeGroup payeeGroup) {
        return null;
    }

    @Override
    public List<PayeeGroup> getAllPayeeGroup() {
        return this.payeeGroupRepository.findAll();
    }

    @Override
    public PayeeGroup getPayeeGroupById(long id) {
        return payeeGroupRepository.findOne(id);
    }

    @Override
    public PayeeGroup getPayeeGroupByCode(String code) {
        return null;
    }

    @Override
    public void deletePayeeGroup(long id) {

    }
}
