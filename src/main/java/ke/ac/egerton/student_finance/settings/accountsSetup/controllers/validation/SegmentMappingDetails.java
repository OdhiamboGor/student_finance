package ke.ac.egerton.student_finance.settings.accountsSetup.controllers.validation;


public class SegmentMappingDetails {

    private Long id;
    private String code;
    private String name;
    private String sysCode;
    private Long accountSegment;
    private String segmentCode;

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

    public Long getAccountSegment() {
        return accountSegment;
    }

    public void setAccountSegment(Long accountSegment) {
        this.accountSegment = accountSegment;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }
}
