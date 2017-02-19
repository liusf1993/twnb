package com.lsf.twnb.exception;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

/**
 * 系统范围内的异常
 */
public class TwnbException extends Exception{
    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 错误信息
     */
    private String errorMessage ;

    public TwnbException(int errorCode){
        this.errorCode=errorCode;
    }
    public TwnbException(String errorMessage){
        this.errorMessage=errorMessage;

    }
    public TwnbException(String errorFormat,Object  arg){
        FormattingTuple ft = MessageFormatter.format(errorFormat, arg);
        this.errorMessage=ft.getMessage();

    }
    public TwnbException(int errorCode,String errorMessage){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
