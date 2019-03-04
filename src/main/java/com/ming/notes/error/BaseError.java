package com.ming.notes.error;

public enum BaseError implements CommonError {

    PARAMETER_VALIDATION_ERROR("00001", "参数错误"),
    UNKNOWN_ERROR("00002", "未知错误"),
    USER_NOT_EXIST("10001", "用户不存在");

    private String errorCode;
    private String errorMsg;

    BaseError(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMsg;
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

}