package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFGLSEGMAPS")
public class SegmentMapping extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFGLSEGMAPS")
    @GenericGenerator(name = "SFGLSEGMAPS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SEGTYPECODE")
    private String code;

    @Column(name = "SEGTYPEDESC")
    private String name;

    @Column(name = "SYSSEGCODE")
    private String sysCode;

    @ManyToOne
    @JoinColumn(name = "SEGNO", referencedColumnName = "SEGNO")
    private AccountSegment accountSegment;

    @ManyToOne
    @JoinColumn(name = "SEGCODE", referencedColumnName = "SEGCODE")
    private SegmentCode segmentCode;


    public SegmentMapping() {
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

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public AccountSegment getAccountSegment() {
        return accountSegment;
    }

    public void setAccountSegment(AccountSegment accountSegment) {
        this.accountSegment = accountSegment;
    }

    public SegmentCode getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(SegmentCode segmentCode) {
        this.segmentCode = segmentCode;
    }

    @Override
    public String toString() {
        return "SegmentMapping{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", accountSegment=" + accountSegment +
                ", segmentCode=" + segmentCode +
                '}';
    }
}
