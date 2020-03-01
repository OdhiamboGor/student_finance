package ke.ac.egerton.student_finance.settings.feeSetup.controllers.validation;

import java.math.BigDecimal;

public class LevelChargeDetails {

    private Long id;
    private String level;
    private String region;
    private String chargeItem;
    private BigDecimal amount;
    private Boolean application;
    private Boolean graduation;
    private Boolean penalty;
    private Boolean alumni;
    private String currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getApplication() {
        return application;
    }

    public void setApplication(Boolean application) {
        this.application = application;
    }

    public Boolean getGraduation() {
        return graduation;
    }

    public void setGraduation(Boolean graduation) {
        this.graduation = graduation;
    }

    public Boolean getPenalty() {
        return penalty;
    }

    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }

    public Boolean getAlumni() {
        return alumni;
    }

    public void setAlumni(Boolean alumni) {
        this.alumni = alumni;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
