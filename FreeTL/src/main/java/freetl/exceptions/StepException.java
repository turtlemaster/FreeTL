package freetl.exceptions;

public class StepException extends Exception {
    public StepException() {
    }

    public StepException(String s) {
        super(s);
    }

    public StepException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public StepException(Throwable throwable) {
        super(throwable);
    }
}
