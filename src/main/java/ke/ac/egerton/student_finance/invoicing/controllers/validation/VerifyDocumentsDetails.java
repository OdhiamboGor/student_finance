package ke.ac.egerton.student_finance.invoicing.controllers.validation;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class VerifyDocumentsDetails {

    private Long batchNo;
    private String batchDescription;
    private Integer entryNo;
    private String customerId;
    private String source;
    private Date entryDate;
    private BigDecimal entryTotal;
    private String documentNumber;
    private String documentType;
    private String reference;
    private Integer glPost;
    private String sectionCode;
    private String drAccount;
    private String bkAccount;
    private String bankCode;
    private String homeCurrency;
    private BigDecimal homeAmount;
    private String sourceCurrency;
    private BigDecimal sourceAmount;
    private BigDecimal exchangeRate;
    private Integer financialYearCode;
    private Integer getFinancialYearPeriod;
    private String accountSetCode;
    private String actegoryCode;
    private String studyMethodCode;
    private String programmeCode;
    private String chtCode;
    private String academicLevelCode;
    private String campusCode;
    private String departmentCode;
    private Long sequence;
    private String accountGLControl;
    private String strCode;
    private String studentNumber;
    private Boolean documentStatus;
    private Boolean accountExist;
    private Boolean updated;
}
