package br.com.luizgcl.core.exception;

public abstract class BaseException extends RuntimeException {

    private String code;

    public BaseException(String message, String code) {
        super(message);
        this.code = code;
    }

}
