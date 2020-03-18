package ke.ac.egerton.student_finance.invoicing.services;

import ke.ac.egerton.student_finance.invoicing.models.VerifyDocuments;

import java.math.BigDecimal;

public class VerifyDocumentsServiceImpl implements  VerifyDocumentsService{
    @Override
    public VerifyDocuments updateVerifyInvoice(VerifyDocuments verifyDocuments, BigDecimal amount) {
        verifyDocuments.setHomeAmount(amount);
        return verifyDocuments;
    }

}
