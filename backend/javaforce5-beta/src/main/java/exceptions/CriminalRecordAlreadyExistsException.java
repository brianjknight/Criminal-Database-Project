package main.java.exceptions;

public class CriminalRecordAlreadyExistsException extends RuntimeException{


    private static final long serialVersionUID = -2482392070077652853L;
    private String ssn;

    public CriminalRecordAlreadyExistsException(String ssn) {
        super("Criminal record already exists for SSN: " + ssn);
        this.ssn = ssn;
    }

    public CriminalRecordAlreadyExistsException(String ssn, String message) {
        super("Criminal record already exists for SSN: " + ssn + ". " + message);
        this.ssn = ssn;
    }

    public CriminalRecordAlreadyExistsException(String ssn, Throwable cause) {
        super("Criminal record already exists for SSN: " + ssn, cause);
        this.ssn = ssn;
    }

    public CriminalRecordAlreadyExistsException(String ssn, String message, Throwable cause) {
        super("Criminal record already exists for SSN: " + ssn + ". " + message, cause);
        this.ssn = ssn;
    }
}
