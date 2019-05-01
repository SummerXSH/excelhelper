package com.summer.excelhelper.exception;

/**
 * @author xiashanhao
 * @date 2019-04-30 18:19
 */
public class ExcelHelperException extends RuntimeException {
    public ExcelHelperException(String message) {
        super(message);
    }

    public ExcelHelperException(String message, Throwable cause) {
        super(message, cause);
    }
}
