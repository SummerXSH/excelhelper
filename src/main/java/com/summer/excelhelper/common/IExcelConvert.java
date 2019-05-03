package com.summer.excelhelper.common;

/**
 * @author xiashanhao
 * @date 2019-05-02 23:33
 */
public interface IExcelConvert {

    <T> T blankConvert(Object source, Class<T> tagetClass) throws Exception;


    <T> T errorConvert(byte source, Class<T> tagetClass) throws Exception;


    <T> T formulaConvert(String source, Class<T> tagetClass) throws Exception;


    <T> T stringConvert(String source, Class<T> tagetClass) throws Exception;

    <T> T numericConvert(Double source, Class<T> tagetClass) throws Exception;
}
