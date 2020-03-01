package ke.ac.egerton.student_finance.settings.currency.service;

import ke.ac.egerton.student_finance.settings.currency.model.Currency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CurrencyService {

    Currency saveCurrency(Currency currency);

    Currency updateCurrency(Currency currency);

    List< Currency > getAllCurrency();

    Currency getCurrencyById(long id);

    Currency getCurrencyByCode(String code);

    void deleteCurrency(String code);
}
