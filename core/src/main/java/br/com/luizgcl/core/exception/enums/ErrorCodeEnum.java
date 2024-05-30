package br.com.luizgcl.core.exception.enums;

public enum ErrorCodeEnum {

    ON0001("Invalid Tax Number", "ON-0001"),
    TR0001("User type Shopkeeper cannot make transfer", "TR-0001"),
    TR0002("Balance unavailable", "TR-0002"),
    TRP0001("Invalid Transaction Pin", "TRP-0001")
    ;

    private String message;
    private String code;

    ErrorCodeEnum(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
