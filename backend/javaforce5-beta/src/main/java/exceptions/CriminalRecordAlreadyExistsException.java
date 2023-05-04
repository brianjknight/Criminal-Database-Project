package main.java.exceptions;

/**
 * Exception thrown when trying to add a CriminalRecord when it already exists.
 */
public class CriminalRecordAlreadyExistsException extends RuntimeException{


    private static final long serialVersionUID = -2482392070077652853L;
    private String ssn;

    /**
     * Exception with no message or cause.
     * @param ssn Social security number for the criminal.
     */
    public CriminalRecordAlreadyExistsException(String ssn) {
        super("Criminal record already exists for SSN: " + ssn);
        this.ssn = ssn;
    }

    /**
     * Exception with a message, but no cause.
     * @param ssn Social security number for the criminal.
     * @param message Descriptive message to include.
     */
    public CriminalRecordAlreadyExistsException(String ssn, String message) {
        super("Criminal record already exists for SSN: " + ssn + ". " + message);
        this.ssn = ssn;
    }

    /**
     * Exception with no message, but with a cause.
     * @param ssn Social security number for the criminal.
     * @param cause The throwable resulting in this exception.
     */
    public CriminalRecordAlreadyExistsException(String ssn, Throwable cause) {
        super("Criminal record already exists for SSN: " + ssn, cause);
        this.ssn = ssn;
    }

    /**
     * Exception with message and cause.
     * @param ssn Social security number for the criminal.
     * @param message Descriptive message to include.
     * @param cause The throwable resulting in this exception.
     */
    public CriminalRecordAlreadyExistsException(String ssn, String message, Throwable cause) {
        super("Criminal record already exists for SSN: " + ssn + ". " + message, cause);
        this.ssn = ssn;
    }
}
