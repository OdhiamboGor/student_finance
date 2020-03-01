package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SFSEGM")
public class AccountSegment extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFSEGM")
    @GenericGenerator(name = "SFSEGM", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SEGNO")
    private Long number;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "SEGDESC")
    private String description;

    @NotNull(message = "This field cannot be null")
    @Column(name = "SEGLEN")
    private Long length;

    @Column(name = "ISACCT")
    private Boolean account;

    public AccountSegment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Boolean getAccount() {
        return account;
    }

    public void setAccount(Boolean account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountSegment{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                ", length=" + length +
                ", account=" + account +
                '}';
    }
}
