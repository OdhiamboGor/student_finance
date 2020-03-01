package ke.ac.egerton.student_finance.settings.receipts.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.student_finance.settings.bankSetup.models.Bank;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFRCNOS")
public class ReceiptNumber extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFRCNOS")
    @GenericGenerator(name = "SFRCNOS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BANKCODE", referencedColumnName = "BANKCODE")
    private Bank bank;

    @Column(name = "STARTW")
    private Long startNumber;

    @Column(name = "NXTNO")
    private Long nextNumber;

    @Column(name = "ABRV")
    private String abbreviation;

    public ReceiptNumber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Long getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(Long startNumber) {
        this.startNumber = startNumber;
    }

    public Long getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(Long nextNumber) {
        this.nextNumber = nextNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        return "ReceiptNumber{" +
                "id=" + id +
                ", bank=" + bank +
                ", startNumber=" + startNumber +
                ", nextNumber=" + nextNumber +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
