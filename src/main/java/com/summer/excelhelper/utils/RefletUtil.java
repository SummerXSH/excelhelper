package com.summer.excelhelper.utils;

import com.summer.excelhelper.pojo.MappingInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.lang.reflect.Method;

/**
 * @author xiashanhao
 * @date 2019-04-30 21:53
 */
public class RefletUtil {

    public static <T> void setValue(Class<T> targetClass, T obj, XSSFCell cell, MappingInfo mapINfo) throws Exception {
        Method method = targetClass.getMethod(mapINfo.getMethodName(), mapINfo.getParamentType());
        if (method != null) {
            switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_BLANK:
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    method.invoke(obj, cell.getBooleanCellValue());
                    break;
                case XSSFCell.CELL_TYPE_ERROR:
                    method.invoke(obj, cell.getErrorCellValue());
                    break;
                case XSSFCell.CELL_TYPE_FORMULA:
                    method.invoke(obj, cell.getCellFormula());
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    method.invoke(obj, Double.valueOf(cell.getNumericCellValue()).longValue() + "");
                    break;
                case XSSFCell.CELL_TYPE_STRING:
                    method.invoke(obj, cell.getStringCellValue());
                    break;
                default:
                    break;
            }
        }
    }
}
