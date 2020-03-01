package ke.ac.egerton.student_finance.settings.accountsSetup.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "SFACCSTR")
public class AccountStructure extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFACCSTR")
    @GenericGenerator(name = "SFACCSTR", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "STRCODE")
    private String code;

    @NotBlank(message = "This field cannot be empty")
    @Column(name = "STRNAME")
    private String name;

    @Column(name = "SEG1")
    private Long segment1;

    @Column(name = "SEG2")
    private Long segment2;

    @Column(name = "SEG3")
    private Long segment3;

    @Column(name = "SEG4")
    private Long segment4;

    @Column(name = "SEG5")
    private Long segment5;

    @Column(name = "SEG6")
    private Long segment6;

    @Column(name = "SEG7")
    private Long segment7;

    @Column(name = "SEG8")
    private Long segment8;

    @Column(name = "SEG9")
    private Long segment9;

    @Column(name = "ACCTSEGMS")
    private String segment;

    @Column(name = "DELIMETER")
    private String delimeter;

    public AccountStructure() {
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

    public Long getSegment1() {
        return segment1;
    }

    public void setSegment1(Long segment1) {
        this.segment1 = segment1;
    }

    public Long getSegment2() {
        return segment2;
    }

    public void setSegment2(Long segment2) {
        this.segment2 = segment2;
    }

    public Long getSegment3() {
        return segment3;
    }

    public void setSegment3(Long segment3) {
        this.segment3 = segment3;
    }

    public Long getSegment4() {
        return segment4;
    }

    public void setSegment4(Long segment4) {
        this.segment4 = segment4;
    }

    public Long getSegment5() {
        return segment5;
    }

    public void setSegment5(Long segment5) {
        this.segment5 = segment5;
    }

    public Long getSegment6() {
        return segment6;
    }

    public void setSegment6(Long segment6) {
        this.segment6 = segment6;
    }

    public Long getSegment7() {
        return segment7;
    }

    public void setSegment7(Long segment7) {
        this.segment7 = segment7;
    }

    public Long getSegment8() {
        return segment8;
    }

    public void setSegment8(Long segment8) {
        this.segment8 = segment8;
    }

    public Long getSegment9() {
        return segment9;
    }

    public void setSegment9(Long segment9) {
        this.segment9 = segment9;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    @Override
    public String toString() {
        return "AccountStructure{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", segment1=" + segment1 +
                ", segment2=" + segment2 +
                ", segment3=" + segment3 +
                ", segment4=" + segment4 +
                ", segment5=" + segment5 +
                ", segment6=" + segment6 +
                ", segment7=" + segment7 +
                ", segment8=" + segment8 +
                ", segment9=" + segment9 +
                ", segment='" + segment + '\'' +
                ", delimeter='" + delimeter + '\'' +
                '}';
    }
}
