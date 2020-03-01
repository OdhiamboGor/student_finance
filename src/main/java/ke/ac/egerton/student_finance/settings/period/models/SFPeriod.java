package ke.ac.egerton.student_finance.settings.period.models;

import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "SFFYPERIODS")
public class SFPeriod {

    @Id
    @GeneratedValue(generator = "SFFYPERIODS")
    @GenericGenerator(name = "SFFYPERIODS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotNull(message = "This field cannot be null")
    @Column(name = "FYCODE")
    private Long code;

    @NotNull(message = "This field cannot be null")
    @Min(0)
    @Column(name = "FYPERIOD")
    private Long period;

    @Column(name = "LOCKED")
    private Boolean locked;

    @Column(name = "STARTDATE")
    private String startDate;

    @Column(name = "ENDDATE")
    private String endDate;

    @Column(name = "FYPERIODDESC")
    private String description;


    public SFPeriod() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", code=" + code +
                ", period=" + period +
                ", locked=" + locked +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
