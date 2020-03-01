package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFSEGMCODES")
public class SegmentCode extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFSEGMCODES")
    @GenericGenerator(name = "SFSEGMCODES", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SEGNO", referencedColumnName = "SEGNO")
    private AccountSegment segment;

    @Column(name = "SEGCODE")
    private String code;

    @Column(name = "SEGDESC")
    private String name;

    public SegmentCode() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountSegment getSegment() {
        return segment;
    }

    public void setSegment(AccountSegment segment) {
        this.segment = segment;
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
}
