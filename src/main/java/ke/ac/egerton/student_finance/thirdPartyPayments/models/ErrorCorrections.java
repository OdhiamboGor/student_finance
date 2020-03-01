package ke.ac.egerton.student_finance.thirdPartyPayments.models;

import ke.ac.egerton.models.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ErrorCorrections extends AuditableEntity {

    @Id
    Long id;
}
