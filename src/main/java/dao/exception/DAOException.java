package dao.exception;

public class DAOException extends RuntimeException {
    public DAOException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
