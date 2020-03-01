package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.GlAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GlAccountService {
    GlAccount saveGlAccount(GlAccount glAccount);

    GlAccount updateGlAccount(GlAccount glAccount);

    List< GlAccount > getAllGlAccount();

    GlAccount getGlAccountById(long id);

    GlAccount getGlAccountByCode(String code);

    void deleteGlAccount(String code);

}
