package com.summer.excelhelper.importexcel;

import com.summer.excelhelper.common.MappingInfoDefigner;
import com.summer.excelhelper.pojo.MappingInfo;

import java.util.List;
import java.util.Map;

/**
 * @author xiashanhao
 * @date 2019-04-30 17:50
 */
public interface IImportExcel {

    IImportExcel setReadSheet(Integer i);

    IImportExcel setStarRow(Integer startRow);

    IImportExcel setEndRow(Long endRow);

    IImportExcel setInputFileName(String fileName);

    IImportExcel setOutputFileName(String fileName);

    IImportExcel setOutputFileDir(String dir);

    IImportExcel setInputFileDir(String dir);

    IImportExcel initMapping(MappingInfoDefigner defigner);

    Map<Integer, MappingInfo> getMapping();

    <T> List<T> read(Class<T> targetClass) throws Exception;

    <T> List<T> readAndInitMapping(Class<T> targetClass) throws Exception;

}
