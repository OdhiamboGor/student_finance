package ke.ac.egerton.student_finance.settings.bankSetup.service;

import ke.ac.egerton.student_finance.settings.bankSetup.models.BankApi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankApiService {

    BankApi saveBankApi(BankApi bankApi);

    BankApi updateBankApi(BankApi bankApi);

    List<BankApi> getAllBankApis();

    BankApi getBankApiById(long id);

    BankApi getBankApiByCode(String code);

    void deleteBankApi(String code);
}
