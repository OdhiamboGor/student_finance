package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountSetService {

    AccountSet saveAccountSet(AccountSet accountSet);

    AccountSet updateAccountSet(AccountSet accountSet);

    List< AccountSet > getAllAccountSet();

    AccountSet getAccountSetById(long id);

    AccountSet getAccountSetByCode(String code);

    void deletAccountSet(String code);
}
