package com.github.aa76111.args.example;

import org.apache.commons.lang3.StringUtils;

import static com.github.aa76111.args.example.ErrorCode.OK;

public class ArgsException extends Exception {

    private char errorArgumentId = '\0';
    private String errorParameter = null;
    private ErrorCode errorCode = OK;

    public ArgsException() {
    }

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(String errorParameter, ErrorCode errorCode) {
        this.errorParameter = errorParameter;
        this.errorCode = errorCode;
    }

    public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
        this.errorCode = errorCode;
        this.errorArgumentId = errorArgumentId;
        this.errorParameter = errorParameter;
    }

    public char getErrorArgumentId() {
        return errorArgumentId;
    }

    public void setErrorArgumentId(char errorArgumentId) {
        this.errorArgumentId = errorArgumentId;
    }

    public String getErrorParameter() {
        return errorParameter;
    }

    public void setErrorParameter(String errorParameter) {
        this.errorParameter = errorParameter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String errorMessage() {
        switch (errorCode) {
            case OK:
                return "TILT: should not get here.";
            case INVALID_ARGUMENT_FORMAT:
                return String.format("'%s' is not valid argument format.", errorParameter);
            default:
                return StringUtils.EMPTY;
        }
    }
}
