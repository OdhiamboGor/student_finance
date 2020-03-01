package ke.ac.egerton.student_finance.settings.currency.model;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "ACCURRENCIES")
public class Currency extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "ACCURRENCIES")
    @GenericGenerator(name = "ACCURRENCIES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

   /* @NotBlank(message = "This field cannot be empty")*/
    @Column(name = "CURRENCYCODE")
    private String code;

    /*@NotBlank(message = "This field cannot be empty")*/
    @Column(name = "CURRENCYNAME")
    private String name;

    @Column(name = "PRFX")
    private String prefix;

    @Column(name = "SUFFIX")
    private String suffix;

    @Column(name = "DP")
    private Integer decimalPoints;

    @Column(name = "HMCUR")
    private Boolean homeCurrency;

    @Column(name = "CURENABLED")
    private Boolean enabled;

    public Currency() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getDecimalPoints() {
        return decimalPoints;
    }

    public void setDecimalPoints(Integer decimalPoints) {
        this.decimalPoints = decimalPoints;
    }

    public Boolean getHomeCurrency() {
        return homeCurrency;
    }

    public void setHomeCurrency(Boolean homeCurrency) {
        this.homeCurrency = homeCurrency;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", decimalPoints=" + decimalPoints +
                ", homeCurrency=" + homeCurrency +
                ", enabled=" + enabled +
                '}';
    }
}