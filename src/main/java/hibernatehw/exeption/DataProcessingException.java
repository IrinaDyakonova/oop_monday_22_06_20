package hibernatehw.exeption;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message, Exception exception) {
        super(message, exception);
    }
}
