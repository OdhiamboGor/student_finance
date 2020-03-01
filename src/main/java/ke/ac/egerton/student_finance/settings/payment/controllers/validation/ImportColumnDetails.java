package ke.ac.egerton.student_finance.settings.payment.controllers.validation;

public class ImportColumnDetails {

    private Long id;
    private String sysColumn;
    private String gatewayColumn;
    private String gateway;
    private Boolean validate;
    private String format;

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

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
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
}
