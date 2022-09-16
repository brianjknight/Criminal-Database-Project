package exceptions;

public class CrimeAlreadyInCriminalRecordException extends RuntimeException{

    private static final long serialVersionUID = 8107788040547335233L;
    private String caseNumber;

    public CrimeAlreadyInCriminalRecordException(String caseNumber) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record.");
        this.caseNumber = caseNumber;
    }

    public CrimeAlreadyInCriminalRecordException(String caseNumber, String message) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record. " + message);
        this.caseNumber = caseNumber;
    }

    public CrimeAlreadyInCriminalRecordException(String caseNumber, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record.", cause);
        this.caseNumber = caseNumber;
    }

    public CrimeAlreadyInCriminalRecordException(String caseNumber, String message, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " is already in this person's criminal record. " + message, cause);
        this.caseNumber = caseNumber;
    }
}
