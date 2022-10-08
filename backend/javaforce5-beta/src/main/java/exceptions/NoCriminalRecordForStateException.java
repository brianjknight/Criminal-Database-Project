package main.java.exceptions;

/**
 * Exception thrown when trying to retrieve CriminalRecords for a given state and optional filter for number of crimes.
 */
public class NoCriminalRecordForStateException extends RuntimeException{
    private static final long serialVersionUID = -1069711839422000753L;
    private String state;

    /**
     * Exception with no message or cause.
     * @param state state attribute to match in each CriminalRecord.
     */
    public NoCriminalRecordForStateException(String state) {
        super("No criminal records found in this state: " + state);
        this.state = state;
    }

    /**
     * Exception with a message, but no cause.
     * @param state state attribute to match in each CriminalRecord.
     * @param message descriptive message.
     */
    public NoCriminalRecordForStateException(String state, String message) {
        super("No criminal records found in this state: " + state + " " + message);
        this.state = state;
    }

    /**
     * Exception with no message, but with a cause.
     * @param state state attribute to match in each CriminalRecord.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCriminalRecordForStateException(String state, Throwable cause) {
        super("No criminal records found in this state: " + state, cause);
        this.state = state;
    }

    /**
     * Exception with message and cause.
     * @param state state attribute to match in each CriminalRecord.
     * @param message descriptive message.
     * @param cause The original throwable resulting in this exception.
     */
    public NoCriminalRecordForStateException(String state, String message, Throwable cause) {
        super("No criminal records found in this state: " + state + " " + message, cause);
        this.state = state;
    }

}
