package com.summer.excelhelper.common.impl;

import com.summer.excelhelper.common.IExcelConvert;

/**
 * @author xiashanhao
 * @date 2019-05-02 23:36
 */
public class DefaultExcelConcert implements IExcelConvert {

    public <T> T stringConvert(String source, Class<T> tagetClass) throws Exception {
        return (T) source;
    }

    public <T> T blankConvert(Object source, Class<T> tagetClass) throws Exception {
        return null;
    }

    public <T> T errorConvert(byte source, Class<T> tagetClass) throws Exception {
        return null;
    }

    public <T> T formulaConvert(String source, Class<T> tagetClass) throws Exception {
        return null;
    }

    public <T> T numericConvert(Double source, Class<T> tagetClass) throws Exception {
        return (T) Long.valueOf(Double.valueOf(source).longValue()).toString();
    }
}
