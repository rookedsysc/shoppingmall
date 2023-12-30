package org.example.shoppingmall.common.error;

public enum ErrorCode implements ErrorCodeInterface {
    OK(200, 200, "OK"),
    BAD_REQUEST(400, 400, "잘못된 요청"),
    SERVER_ERROR(500, 500, "서버에러"),
    NULL_POINT(500, 512, "Null point error");

    private final int httpStatusCode;
    private final int errorCode;
    private final String description;

    ErrorCode(int httpStatusCode, int errorCode, String description) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.description = description;
    }

    @Override
    public Integer getHttpStatusCode() {
        return this.httpStatusCode;
    }

    @Override
    public Integer getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}