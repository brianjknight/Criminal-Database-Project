package main.java.exceptions;

public class MissingAttributeToSaveRecordException extends RuntimeException{

    private static final long serialVersionUID = -3592874481640674253L;

    public MissingAttributeToSaveRecordException() {
        super("You must enter SSN, name, DOB, and state to save a record.");
    }

    public MissingAttributeToSaveRecordException(String message) {
        super("You must enter SSN, name, DOB, and state to save a record." + message);
    }

    public MissingAttributeToSaveRecordException(Throwable cause) {
        super("You must enter SSN, name, DOB, and state to save a record.", cause);
    }

    public MissingAttributeToSaveRecordException(String message, Throwable cause) {
        super("You must enter SSN, name, DOB, and state to save a record." + message, cause);
    }
}
