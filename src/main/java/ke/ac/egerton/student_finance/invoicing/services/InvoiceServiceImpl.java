package ke.ac.egerton.student_finance.invoicing.services;

import ke.ac.egerton.student_finance.invoicing.models.Invoice;
import ke.ac.egerton.student_finance.invoicing.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        String status = "Posted";
        Optional <Invoice> invc = this.invoiceRepository.findById(invoice.getId());
        if(invc.isPresent()){
            Invoice invoiceUpdate = invc.get();
            invoiceUpdate.setId(invoice.getId());
            invoiceUpdate.setStatus(status);
            invoiceRepository.save(invoiceUpdate);
            return invoiceUpdate;
        }

    return  invoice;
    }

    @Override
    public List<Invoice> getAllInvoice() {
        return null;
    }

    @Override
    public Invoice getInvoiceById(long id) {
        return null;
    }

    @Override
    public Invoice getInvoiceByCode(String code) {
        return null;
    }

    @Override
    public void deleteInvoice(String code) {

    }

    @Override
    public void deleteInvoice(Invoice invoice) {

    }
}
