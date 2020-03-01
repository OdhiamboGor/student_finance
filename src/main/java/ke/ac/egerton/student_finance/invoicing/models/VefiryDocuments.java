package ke.ac.egerton.student_finance.invoicing.models;

import ke.ac.egerton.models.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VefiryDocuments extends AuditableEntity {

    @Id
    private  Long id;
}
