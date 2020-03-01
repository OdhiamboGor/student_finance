package ke.ac.egerton.student_finance.settings.accountsSetup.service;

import ke.ac.egerton.student_finance.settings.accountsSetup.models.AccountStructure;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountStructureService {

    AccountStructure saveAccountStructure(AccountStructure accountStructure);

    AccountStructure updateAccountStructure(AccountStructure accountStructure);

    List< AccountStructure > getAllAccountStructure();

    AccountStructure getAccountStructureById(long id);

    AccountStructure getAccountStructureByCode(String code);

    void deleteAccountStructure(long id);
}
