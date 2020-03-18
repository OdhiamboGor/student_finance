package ke.ac.egerton.student_finance.invoicing.services;

import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;

import java.math.BigDecimal;

public interface VerifyDocumentsService {

    VerifyDocuments updateVerifyInvoice(VerifyDocuments verifyDocuments, BigDecimal amount);
}
