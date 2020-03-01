package ke.ac.egerton.student_finance.settings.currency.model;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ACEXCHANGERATES")
public class ExchangeRate extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "ACEXCHANGERATES")
    @GenericGenerator(name = "ACEXCHANGERATES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "SRCCUR")
    private String sourceCurrency;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "HMCUR")
    private String homeCurrency;

    @NotNull(message = "This field cannot be null")
    private BigDecimal rate;

    @Column(name = "STARTDATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date startDate;

    @Column(name = "ENDDATE")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date endDate;

    public ExchangeRate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(String homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", sourceCurrency='" + sourceCurrency + '\'' +
                ", homeCurrency='" + homeCurrency + '\'' +
                ", rate=" + rate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

