package com.yx.shgd.common.exception;

public interface ErrorCode {
    int getCode();
    String getMessage();
    int getHttpCode();
}
