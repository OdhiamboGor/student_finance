package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSegment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountSegmentService {

    AccountSegment saveAccountSegment(AccountSegment accountSegment);

    AccountSegment updateAccountSegment(AccountSegment accountSegment);

    List< AccountSegment > getAllAccountSegment();

    AccountSegment getAccountSegmentById(long id);

    AccountSegment getAccountSegmentByCode(String code);

    AccountSegment getAccountSegmentByNumber(long number);
}
