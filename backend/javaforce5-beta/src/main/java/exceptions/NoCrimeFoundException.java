package main.java.exceptions;

/**
 * Exception thrown when trying retrieve a Crime from DDB Crimes table but it does not exist.
 */
public class NoCrimeFoundException extends RuntimeException {

    private static final long serialVersionUID = -7715647062639847713L;
    private String caseNumber;

    /**
     * Exception with no message or cause.
     * @param caseNumber case number being used.
     */
    public NoCrimeFoundException(String caseNumber) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist.");
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with a message, but no cause.
     * @param caseNumber case number being used.
     * @param message descriptive message.
     */
    public NoCrimeFoundException(String caseNumber, String message) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist." + " " + message);
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with no message, but with a cause.
     * @param caseNumber case number being used.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCrimeFoundException(String caseNumber, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist.", cause);
        this.caseNumber = caseNumber;
    }

    /**
     * Exception with message and cause.
     * @param caseNumber case number being used.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCrimeFoundException(String caseNumber, String message, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist." + " " + message, cause);
        this.caseNumber = caseNumber;
    }

}
