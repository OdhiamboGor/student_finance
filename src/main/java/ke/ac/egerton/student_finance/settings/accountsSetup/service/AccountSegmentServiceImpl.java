package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSegment;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountSegmentServiceImpl implements AccountSegmentService {

    @Autowired
    AccountSegmentRepository accountSegmentRepository;

    @Override
    public AccountSegment saveAccountSegment(AccountSegment accountSegment) {
        return accountSegmentRepository.save(accountSegment);
    }

    @Override
    public AccountSegment updateAccountSegment(AccountSegment accountSegment) {
        return null;
    }

    @Override
    public List<AccountSegment> getAllAccountSegment() {
        return this.accountSegmentRepository.findAll();
    }

    @Override
    public AccountSegment getAccountSegmentById(long id) {
        return this.accountSegmentRepository.findOne(id);
    }

    @Override
    public AccountSegment getAccountSegmentByCode(String code) {
        return null;
    }

    @Override
    public AccountSegment getAccountSegmentByNumber(long number) {
        return this.accountSegmentRepository.findOne(number);
    }


}
