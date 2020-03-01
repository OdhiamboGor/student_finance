package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.AccountStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountStructureServiceImpl implements AccountStructureService{

    @Autowired
    AccountStructureRepository structureRepository;

    @Override
    public AccountStructure saveAccountStructure(AccountStructure accountStructure) {
        return structureRepository.save(accountStructure);
    }

    @Override
    public AccountStructure updateAccountStructure(AccountStructure accountStructure) {
        return null;
    }

    @Override
    public List<AccountStructure> getAllAccountStructure() {
        return this.structureRepository.findAll();
    }

    @Override
    public AccountStructure getAccountStructureById(long id) {
        return this.structureRepository.findOne(id);
    }

    @Override
    public AccountStructure getAccountStructureByCode(String code) {
        return null;
    }

    @Override
    public void deleteAccountStructure(long id) {

    }
}
