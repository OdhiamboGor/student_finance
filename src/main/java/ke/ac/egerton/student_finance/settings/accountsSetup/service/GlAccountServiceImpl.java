package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.GlAccount;
import ke.ac.egerton.student_finance.settings.accountsSetup.repository.GlAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GlAccountServiceImpl implements GlAccountService {

    @Autowired
    GlAccountRepository glAccountRepository;


    @Override
    public GlAccount saveGlAccount(GlAccount glAccount) {
        return glAccountRepository.save(glAccount);
    }

    @Override
    public GlAccount updateGlAccount(GlAccount glAccount) {
        return null;
    }

    @Override
    public List<GlAccount> getAllGlAccount() {
        return this.glAccountRepository.findAll();
    }

    @Override
    public GlAccount getGlAccountById(long id) {
        return this.glAccountRepository.findOne(id);
    }

    @Override
    public GlAccount getGlAccountByCode(String code) {
        return null;
    }

    @Override
    public void deleteGlAccount(String code) {

    }
}
