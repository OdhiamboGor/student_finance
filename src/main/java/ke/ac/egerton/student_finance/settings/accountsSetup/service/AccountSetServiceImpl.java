package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountSet;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountSetServiceImpl implements AccountSetService{

    @Autowired
    AccountSetRepository accountSetRepository;

    @Override
    public AccountSet saveAccountSet(AccountSet accountSet) {
        return accountSetRepository.save(accountSet);
    }

    @Override
    public AccountSet updateAccountSet(AccountSet accountSet) {
        return null;
    }

    @Override
    public List<AccountSet> getAllAccountSet() {
        return this.accountSetRepository.findAll();
    }

    @Override
    public AccountSet getAccountSetById(long id) {
        return this.accountSetRepository.findOne(id);
    }

    @Override
    public AccountSet getAccountSetByCode(String code) {
        return null;
    }

    @Override
    public void deletAccountSet(String code) {

    }
}
