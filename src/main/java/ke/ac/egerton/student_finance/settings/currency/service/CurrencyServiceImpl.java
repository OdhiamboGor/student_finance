package ke.ac.egerton.student_finance.settings.currency.service;

import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import ke.ac.egerton.student_finance.settings.currency.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {

        @Autowired
        private CurrencyRepository currencyRepository;

    @Override
    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency updateCurrency(Currency currency) {

        return null;
    }

    @Override
    public List< Currency > getAllCurrency() {
            return this.currencyRepository.findAll();
        }

    @Override
    public Currency getCurrencyById(long id) {
        return this.currencyRepository.findOne(id);
    }


    @Override
    public Currency getCurrencyByCode(String code) {
        return null;
    }

    @Override
    public void deleteCurrency(String code) {

    }

   /* @Override
        public void deleteProduct(long productId) {
            Optional < Product > productDb = this.productRepository.findById(productId);

            if (productDb.isPresent()) {
                this.productRepository.delete(productDb.get());
            } else {
                throw new ResourceNotFoundException("Record not found with id : " + productId);
            }

        }*/
}
