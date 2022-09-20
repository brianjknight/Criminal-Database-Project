package main.java.exceptions;

public class NoCriminalRecordFoundException extends RuntimeException{
    private static final long serialVersionUID = -1069711839422000753L;
    private String ssn;

    public NoCriminalRecordFoundException(String ssn) {
        super("No criminal records found for SSN: " + ssn);
        this.ssn = ssn;
    }

    public NoCriminalRecordFoundException(String ssn, String message) {
        super("No criminal records found for SSN: " + ssn + " " + message);
        this.ssn = ssn;
    }

    public NoCriminalRecordFoundException(String ssn, Throwable cause) {
        super("No criminal records found for SSN: " + ssn, cause);
        this.ssn = ssn;
    }

    public NoCriminalRecordFoundException(String ssn, String message, Throwable cause) {
        super("No criminal records found for SSN: " + ssn + " " + message, cause);
        this.ssn = ssn;
    }

}
