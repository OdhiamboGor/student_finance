package ke.ac.egerton.student_finance.invoicing.services;

import ke.ac.egerton.student_finance.invoicing.models.Invoice;
import ke.ac.egerton.student_finance.receipting.models.ReceiptBatch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    Invoice saveInvoice(Invoice invoice);

    Invoice updateInvoice(Invoice invoice);

    List<Invoice> getAllInvoice();

    Invoice getInvoiceById(long id);

    Invoice getInvoiceByCode(String code);

    void deleteInvoice(String code);

    void deleteInvoice(Invoice invoice);
}
