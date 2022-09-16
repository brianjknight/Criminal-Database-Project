package exceptions;

public class NoCrimeFoundException extends RuntimeException{

    private static final long serialVersionUID = -7715647062639847713L;
    private String caseNumber;

    public NoCrimeFoundException(String caseNumber) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist.");
        this.caseNumber = caseNumber;
    }

    public NoCrimeFoundException(String caseNumber, String message) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist." + " " + message);
        this.caseNumber = caseNumber;
    }

    public NoCrimeFoundException(String caseNumber, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist.", cause);
        this.caseNumber = caseNumber;
    }

    public NoCrimeFoundException(String caseNumber, String message, Throwable cause) {
        super("Case number: " + "\'" + caseNumber + "\'" + " does not exist." + " " + message, cause);
        this.caseNumber = caseNumber;
    }

}
