package main.java.exceptions;

/**
 * Exception thrown when trying to create or save a CriminalRecord that
 * does not contain the required attributes ssn, name, dob, and state.
 */
public class MissingAttributeToSaveRecordException extends RuntimeException {

    private static final long serialVersionUID = -3592874481640674253L;

    /**
     * Exception with no message or cause.
     */
    public MissingAttributeToSaveRecordException() {
        super("You must enter SSN, name, DOB, and state to save a record.");
    }

    /**
     * Exception with a message, but no cause.
     * @param message descriptive message.
     */
    public MissingAttributeToSaveRecordException(String message) {
        super("You must enter SSN, name, DOB, and state to save a record." + message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public MissingAttributeToSaveRecordException(Throwable cause) {
        super("You must enter SSN, name, DOB, and state to save a record.", cause);
    }

    /**
     * Exception with message and cause.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public MissingAttributeToSaveRecordException(String message, Throwable cause) {
        super("You must enter SSN, name, DOB, and state to save a record." + message, cause);
    }
}
