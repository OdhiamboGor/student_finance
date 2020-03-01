package ke.ac.egerton.student_finance.settings.payment.models;

import ke.ac.egerton.models.AuditableEntity;
import ke.ac.egerton.models.IncrementalIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "SFGTWCOLS")
public class ImportColumn extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "SFGTWCOLS")
    @GenericGenerator(name = "SFGTWCOLS", strategy = IncrementalIdGenerator.STRATEGY_NAME)
    private Long id;

    @Column(name = "SYSCOLUMN")
    private String sysColumn;

    @Column(name = "GTWCOLUMN")
    private String gatewayColumn;

    @ManyToOne
    @JoinColumn(name = "GTWCODE", referencedColumnName = "GTWCODE")
    private PaymentGateway gateway;

    @Column(name = "VLDATE")
    private Boolean validate;

    @Column(name = "FMT")
    private String format;


    public ImportColumn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSysColumn() {
        return sysColumn;
    }

    public void setSysColumn(String sysColumn) {
        this.sysColumn = sysColumn;
    }

    public String getGatewayColumn() {
        return gatewayColumn;
    }

    public void setGatewayColumn(String gatewayColumn) {
        this.gatewayColumn = gatewayColumn;
    }

    public PaymentGateway getGateway() {
        return gateway;
    }

    public void setGateway(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public Boolean getValidate() {
        return validate;
    }

    public void setValidate(Boolean validate) {
        this.validate = validate;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "ImportColumn{" +
                "id=" + id +
                ", sysColumn='" + sysColumn + '\'' +
                ", gatewayColumn='" + gatewayColumn + '\'' +
                ", gateway=" + gateway +
                ", validate=" + validate +
                ", format='" + format + '\'' +
                '}';
    }
}
