package ke.ac.egerton.student_finance.settings.bankSetup.service;

import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import ke.ac.egerton.student_finance.settings.bankSetup.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    BankRepository bankRepository;

    @Override
    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank updateBank(Bank bank) {
        return null;
    }

    @Override
    public List<Bank> getAllBanks() {
        return this.bankRepository.findAll();
    }

    @Override
    public Bank getBankById(long id) {
        return this.bankRepository.findOne(id);
    }

    @Override
    public Bank getBankByCode(String code) {
        return null;
    }

    @Override
    public void deleteBank(String code) {

    }
}
