package com.summer.excelhelper.utils;

import com.summer.excelhelper.exception.ExcelHelperException;

import java.io.File;
import java.util.Map;

/**
 * @author xiashanhao
 * @date 2019-04-30 19:02
 */
public class AssertUtils {

    public static void notNull(Object obj, String msg) {
        if (obj == null) {
            throw new ExcelHelperException(msg, new RuntimeException());
        }
    }

    public static void notBlank(String obj, String msg) {
        if (obj == null || obj.trim().equals("")) {
            throw new ExcelHelperException(msg, new RuntimeException());
        }
    }

    public static void notEmpty(Map map, String msg) {
        AssertUtils.notNull(map, msg);
        if (map.size() <= 0) {
            throw new ExcelHelperException(msg);
        }
    }

    public static void isExist(File file, String msg) {
        if (!file.exists() || file.isDirectory()) {
            throw new ExcelHelperException(msg);
        }
    }

    public static void isTrue(Boolean boolen, String msg) {
        if (!boolen) {
            throw new ExcelHelperException(msg);
        }
    }
}
