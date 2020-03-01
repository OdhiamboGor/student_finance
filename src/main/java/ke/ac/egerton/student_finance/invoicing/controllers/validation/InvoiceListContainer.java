package ke.ac.egerton.student_finance.invoicing.controllers.validation;

import ke.ac.egerton.student_finance.invoicing.models.Invoice;

import java.util.List;

public class InvoiceListContainer {

    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
