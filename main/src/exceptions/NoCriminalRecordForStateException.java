package exceptions;

public class NoCriminalRecordForStateException extends RuntimeException{
    private static final long serialVersionUID = -1069711839422000753L;
    private String state;

    public NoCriminalRecordForStateException(String state) {
        super("No criminal records found in this state: " + state);
        this.state = state;
    }

    public NoCriminalRecordForStateException(String state, String message) {
        super("No criminal records found in this state: " + state + " " + message);
        this.state = state;
    }

    public NoCriminalRecordForStateException(String state, Throwable cause) {
        super("No criminal records found in this state: " + state, cause);
        this.state = state;
    }

    public NoCriminalRecordForStateException(String state, String message, Throwable cause) {
        super("No criminal records found in this state: " + state + " " + message, cause);
        this.state = state;
    }

}
