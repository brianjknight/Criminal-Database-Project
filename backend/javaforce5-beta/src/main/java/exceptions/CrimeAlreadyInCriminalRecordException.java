package main.java.exceptions;

/**
 * Exception thrown when trying to add a Crime to a CriminalRecord when it already exists in the record.
 */
public class CrimeAlreadyInCriminalRecordException extends RuntimeException{

    private static final long serialVersionUID = 8107788040547335233L;
    private String caseNumber;

    /**
     * Exception with no message or cause.
     * @param caseNumber case number being used.
     */
    public CrimeAlreadyInCriminalRecordException(String caseNumber) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record.");
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with a message, but no cause.
     * @param caseNumber case number being used.
     * @param message descriptive message.
     */
    public CrimeAlreadyInCriminalRecordException(String caseNumber, String message) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record. " + message);
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with no message, but with a cause.
     * @param caseNumber case number being used.
     * @param cause The original throwable resulting in this exception.
     */
    public CrimeAlreadyInCriminalRecordException(String caseNumber, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record.", cause);
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with message and cause.
     * @param caseNumber case number being used.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public CrimeAlreadyInCriminalRecordException(String caseNumber, String message, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record. " + message, cause);
        this.caseNumber = caseNumber;
    }
}
