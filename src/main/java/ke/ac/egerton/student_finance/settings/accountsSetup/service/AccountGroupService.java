package ke.ac.egerton.student_finance.settings.accountsSetup.service;


import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountGroup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountGroupService {

    AccountGroup saveAccountGroup(AccountGroup accountGroup);

    AccountGroup updateAccountGroup(AccountGroup accountGroup);

    List< AccountGroup > getAllAccountGroup();

    AccountGroup getAccountGroupById(long id);

    AccountGroup getAccountGroupByCode(String code);

    void deleteAccountGroup(String code);
}
