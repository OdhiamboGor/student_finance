package ke.ac.egerton.student_finance.settings.bankSetup.service;

import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    Bank saveBank(Bank bank);

    Bank updateBank(Bank bank);

    List<Bank> getAllBanks();

    Bank getBankById(long id);

    Bank getBankByCode(String code);

    void deleteBank(String code);
}
