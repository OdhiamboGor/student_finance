package ke.ac.egerton.student_finance.payment_refund;

import ke.ac.egerton.models.AuditableEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentPayment extends AuditableEntity {

    @Id
    private  Long id;
}
