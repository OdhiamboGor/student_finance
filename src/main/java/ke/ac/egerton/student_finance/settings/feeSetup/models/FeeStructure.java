package ke.ac.egerton.student_finance.settings.feeSetup.models;

import ke.ac.egerton.academic.units.YearOfStudy;
import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.academic.*;
import ke.ac.egerton.models.places.CountryRegion;
import ke.ac.egerton.student_finance.settings.currency.model.Currency;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SFFSTR")
public class FeeStructure extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFFSTR")
    @GenericGenerator(name = "SFFSTR", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRCODE", referencedColumnName = "PRCODE")
    private Programme programme;

    @ManyToOne
    @JoinColumn(name = "REGIONCODE", referencedColumnName = "REGIONCODE")
    private CountryRegion region;

    @Column(name = "FEETYPE")
    private String feeType;

    @ManyToOne
    @JoinColumn(name = "SECTIONCODE", referencedColumnName = "SECTIONCODE")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "CATEGORYCODE", referencedColumnName = "CATEGORYCODE")
    private StudentCategory studentCategory;

    @ManyToOne
    @JoinColumn(name = "ACADEMICYEAR", referencedColumnName = "ACADEMICYEAR")
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "YEARCODE", referencedColumnName = "YEARCODE")
    private YearOfStudy yearOfStudy;

    @ManyToOne
    @JoinColumn(name = "SEMSESSIONCODE", referencedColumnName = "SEMSESSIONCODE")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "SEGCODE", referencedColumnName = "SEGCODE")
    private ChargeItem chargeItem;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "CURRENCYCODE", referencedColumnName = "CURRENCYCODE")
    private Currency currency;

    private String comments;

    private Boolean deleted;

    @Column(name = "AMTISDF")
    private Boolean isDefault;

    public FeeStructure() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public CountryRegion getRegion() {
        return region;
    }

    public void setRegion(CountryRegion region) {
        this.region = region;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory = studentCategory;
    }

    public AcademicYear getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    public YearOfStudy getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(YearOfStudy yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "FeeStructure{" +
                "id=" + id +
                ", programme=" + programme +
                ", region=" + region +
                ", feeType='" + feeType + '\'' +
                ", section=" + section +
                ", studentCategory=" + studentCategory +
                ", academicYear=" + academicYear +
                ", yearOfStudy=" + yearOfStudy +
                ", session=" + session +
                ", chargeItem=" + chargeItem +
                ", amount=" + amount +
                ", currency=" + currency +
                ", comments='" + comments + '\'' +
                ", deleted=" + deleted +
                ", isDefault=" + isDefault +
                '}';
    }
}
