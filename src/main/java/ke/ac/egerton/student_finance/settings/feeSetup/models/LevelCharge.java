package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.StudyLevel;
import ke.ac.egerton.models.places.CountryRegion;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFLVCG")
public class LevelCharge extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFLVCG")
    @GenericGenerator(name = "SFLVCG", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ACADLEVELCODE", referencedColumnName = "ACADLEVELCODE")
    private StudyLevel level;

    @ManyToOne
    @JoinColumn(name = "REGIONCODE", referencedColumnName = "REGIONCODE")
    private CountryRegion region;

    @ManyToOne
    @JoinColumn(name = "SEGCODE", referencedColumnName = "SEGCODE")
    private ChargeItem chargeItem;

    private BigDecimal amount;

    @Column(name = "IOA")
    private Boolean application;

    @Column(name = "IGA")
    private Boolean graduation;

    @Column(name = "IPN")
    private Boolean penalty;

    @Column(name = "IAL")
    private Boolean alumni;

    @ManyToOne
    @JoinColumn(name = "CURRENCYCODE", referencedColumnName = "CURRENCYCODE")
    private Currency currency;


    public LevelCharge() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyLevel getLevel() {
        return level;
    }

    public void setLevel(StudyLevel level) {
        this.level = level;
    }

    public CountryRegion getRegion() {
        return region;
    }

    public void setRegion(CountryRegion region) {
        this.region = region;
    }

    public ChargeItem getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(ChargeItem chargeItem) {
        this.chargeItem = chargeItem;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getApplication() {
        return application;
    }

    public void setApplication(Boolean application) {
        this.application = application;
    }

    public Boolean getGraduation() {
        return graduation;
    }

    public void setGraduation(Boolean graduation) {
        this.graduation = graduation;
    }

    public Boolean getPenalty() {
        return penalty;
    }

    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

    public Boolean getAlumni() {
        return alumni;
    }

    public void setAlumni(Boolean alumni) {
        this.alumni = alumni;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "LevelCharge{" +
                "id=" + id +
                ", level=" + level +
                ", region=" + region +
                ", chargeItem=" + chargeItem +
                ", amount=" + amount +
                ", application=" + application +
                ", graduation=" + graduation +
                ", penalty=" + penalty +
                ", alumni=" + alumni +
                ", currency=" + currency +
                '}';
    }
}
