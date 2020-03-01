package ke.ac.egerton.student_finance.settings.bankSetup.service;

import ke.ac.egerton.student_finance.settings.bankSetup.models.BankApi;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankApiServiceImpl implements BankApiService {

    @Autowired
    BankApiRepository bankApiRepository;

    @Override
    public BankApi saveBankApi(BankApi bankApi) {
        return bankApiRepository.save(bankApi);
    }

    @Override
    public BankApi updateBankApi(BankApi bankApi) {
        return null;
    }

    @Override
    public List<BankApi> getAllBankApis() {
        return this.bankApiRepository.findAll();
    }

    @Override
    public BankApi getBankApiById(long id) {
        return this.bankApiRepository.findOne(id);
    }

    @Override
    public BankApi getBankApiByCode(String code) {
        return null;
    }

    @Override
    public void deleteBankApi(String code) {

    }
}
