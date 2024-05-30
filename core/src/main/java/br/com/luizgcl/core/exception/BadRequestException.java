package br.com.luizgcl.core.exception;

public class BadRequestException extends BaseException {

    public BadRequestException(String message, String code) {
        super(message, code);
    }
}
