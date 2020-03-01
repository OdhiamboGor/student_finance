package ke.ac.egerton.student_finance.settings.coreSetup.models;

import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SFFISCALYR")
public class FiscalCalendar{

    @Id
    @GeneratedValue(generator = "SFFISCALYR")
    @GenericGenerator(name = "SFFISCALYR", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @NotNull(message = "This field cannot be null")
    @Column(name = "FYCODE")
    private Integer code;

    @NotNull(message = "This field cannot be null")
    @Min(0)
    @Column(name = "PERIODS")
    private Integer period;

    @Column(name = "ISACTIVE")
    private Boolean active;

    @Column(name = "FYDESC")
    private String description;

    @Column(name = "STARTMONTH")
    private Integer month;

    public FiscalCalendar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "FiscalCalendar{" +
                "id=" + id +
                ", code=" + code +
                ", period=" + period +
                ", active=" + active +
                ", description='" + description + '\'' +
                ", month=" + month +
                '}';
    }

}
