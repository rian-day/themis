package betahouse.exception;

public class ExcelException extends Exception{
    private String message;
    public ExcelException(String ErrorMessagr) {  //父类方法
        message = ErrorMessagr;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
