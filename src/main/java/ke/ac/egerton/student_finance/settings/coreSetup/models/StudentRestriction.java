package ke.ac.egerton.student_finance.settings.coreSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import ke.ac.egerton.models.StudentStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "SFRESTRICT")
public class StudentRestriction extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFRESTRICT")
    @GenericGenerator(name = "SFRESTRICT", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "STATUSCODE", referencedColumnName = "STATUSCODE")
    private StudentStatus status;

    @Column(name = "TRANSCODE")
    private String code;

    @Column(name = "TRANSDESC")
    private String name;

    @Column(name = "FDAYS")
    private Long futureDays;

    public StudentRestriction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
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

    public Long getFutureDays() {
        return futureDays;
    }

    public void setFutureDays(Long futureDays) {
        this.futureDays = futureDays;
    }

    @Override
    public String toString() {
        return "StudentRestriction{" +
                "id=" + id +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", futureDays=" + futureDays +
                '}';
    }
}
