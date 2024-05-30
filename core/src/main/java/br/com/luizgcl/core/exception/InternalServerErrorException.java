package br.com.luizgcl.core.exception;

public class InternalServerErrorException extends BaseException {

    public InternalServerErrorException(String message, String code) {
        super(message, code);
    }
}
