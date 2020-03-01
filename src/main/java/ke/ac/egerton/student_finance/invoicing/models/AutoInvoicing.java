package ke.ac.egerton.student_finance.invoicing.models;

import ke.ac.egerton.models.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AutoInvoicing extends AuditableEntity {

    @Id
    private  Long id;

    private String batchNo;

    private String batchDescription;



}
