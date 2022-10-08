package main.java.exceptions;

/**
 * Exception thrown when trying to add a Crime to a CriminalRecord that belongs to a different SSN.
 * SSN attributes of Crime and CriminalRecord must match.
 */
public class CriminalRecordCrimeMismatchException extends RuntimeException {

    private static final long serialVersionUID = -3705778411794007532L;
    private String ssn;
    private String caseNumber;

    /**
     * Exception with no message or cause.
     * @param ssn provided ssn.
     * @param caseNumber provided case number.
     */
    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with a message, but no cause.
     * @param ssn provided ssn.
     * @param caseNumber provided case number.
     * @param message descriptive message.
     */
    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, String message) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn + " " + message);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with no message, but with a cause.
     * @param ssn provided ssn.
     * @param caseNumber provided case number.
     * @param cause The original throwable resulting in this exception.
     */
    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, Throwable cause) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn, cause);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with message and cause.
     * @param ssn provided ssn.
     * @param caseNumber provided case number.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public CriminalRecordCrimeMismatchException(String ssn, String caseNumber, String message, Throwable cause) {
        super("Case number : " + caseNumber + " does not belong to criminal with SSN: " + ssn + " " + message, cause);
        this.ssn = ssn;
        this.caseNumber = caseNumber;
    }

}
