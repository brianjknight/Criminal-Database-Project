package main.java.exceptions;

/**
 * Exception thrown when trying to retrieve a CriminalRecord that does not exist for the given SSN.
 */
public class NoCriminalRecordFoundException extends RuntimeException{
    private static final long serialVersionUID = -1069711839422000753L;
    private String ssn;

    /**
     * Exception with no message or cause.
     * @param ssn social security number to look up record.
     */
    public NoCriminalRecordFoundException(String ssn) {
        super("No criminal records found for SSN: " + ssn);
        this.ssn = ssn;
    }

    /**
     * Exception with a message, but no cause.
     * @param ssn social security number to look up record.
     * @param message descriptive message.
     */
    public NoCriminalRecordFoundException(String ssn, String message) {
        super("No criminal records found for SSN: " + ssn + " " + message);
        this.ssn = ssn;
    }

    /**
     * Exception with no message, but with a cause.
     * @param ssn social security number to look up record.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCriminalRecordFoundException(String ssn, Throwable cause) {
        super("No criminal records found for SSN: " + ssn, cause);
        this.ssn = ssn;
    }

    /**
     * Exception with message and cause.
     * @param ssn social security number to look up record.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCriminalRecordFoundException(String ssn, String message, Throwable cause) {
        super("No criminal records found for SSN: " + ssn + " " + message, cause);
        this.ssn = ssn;
    }

}
