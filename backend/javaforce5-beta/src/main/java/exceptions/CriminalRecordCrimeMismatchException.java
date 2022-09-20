package main.java.exceptions;

public class CriminalRecordCrimeMismatchException extends RuntimeException{

    private static final long serialVersionUID = -3705778411794007532L;
    private String ssn;
    private String caseNumber;

    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, String message) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn + " " + message);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, Throwable cause) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn, cause);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, String message, Throwable cause) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn + " " + message, cause);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

}
