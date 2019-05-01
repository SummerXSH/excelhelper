package com.summer.excelhelper;

import com.summer.excelhelper.importexcel.IImportExcel;
import com.summer.excelhelper.importexcel.impl.ImportExcel;

/**
 * @author xiashanhao
 * @date 2019-04-30 22:01
 */
public class ExcelHelper {

    public static IImportExcel startImport() {
        return new ImportExcel();
    }
}
