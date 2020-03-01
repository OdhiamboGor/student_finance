package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountGroup;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountGroupServiceImpl implements AccountGroupService{

    @Autowired
    AccountGroupRepository accountGroupRepository;

    @Override
    public AccountGroup saveAccountGroup(AccountGroup accountGroup) {
        return accountGroupRepository.save(accountGroup);
    }

    @Override
    public AccountGroup updateAccountGroup(AccountGroup accountGroup) {
        return null;
    }

    @Override
    public List<AccountGroup> getAllAccountGroup() {
        return this.accountGroupRepository.findAll();
    }

    @Override
    public AccountGroup getAccountGroupById(long id) {
        return this.accountGroupRepository.findOne(id);
    }

    @Override
    public AccountGroup getAccountGroupByCode(String code) {
        return null;
    }

    @Override
    public void deleteAccountGroup(String code) {

    }
}
