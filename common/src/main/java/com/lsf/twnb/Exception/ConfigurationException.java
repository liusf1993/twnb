package com.lsf.twnb.Exception;

/**
 * 配置异常
 */
public class ConfigurationException extends TwnbException {
    public ConfigurationException(int errorCode) {
        super(errorCode);
    }

    public ConfigurationException(String errorMessage) {
        super(errorMessage);
    }

    public ConfigurationException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
