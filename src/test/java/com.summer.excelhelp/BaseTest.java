package com.summer.excelhelp;

import com.summer.excelhelper.ExcelHelper;
import com.summer.excelhelper.importexcel.IImportExcel;
import com.summer.excelhelper.pojo.MappingInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiashanhao
 * @date 2019-04-30 15:48
 */
public class BaseTest {
    public static void main(String[] args) throws Exception {
        IImportExcel iImportExcel = ExcelHelper.startImport().setInputFileDir("inputdir").setInputFileName("file.xlsx");
        List<MobileForReadExcel> read = iImportExcel.readAndInitMapping(MobileForReadExcel.class);
        for (MobileForReadExcel m : read) {
//            System.out.println(m.toString());
        }
        Map<Integer, MappingInfo> mapping = iImportExcel.getMapping();
        Set<Map.Entry<Integer, MappingInfo>> entries = mapping.entrySet();
        for (Map.Entry<Integer, MappingInfo> en : entries) {
            System.out.println(en.getKey() + en.getValue().toString());
        }

    }
}
