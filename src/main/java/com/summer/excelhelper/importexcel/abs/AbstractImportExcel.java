package com.summer.excelhelper.importexcel.abs;

import com.summer.excelhelper.common.MappingInfoDefigner;
import com.summer.excelhelper.common.impl.ClassMappingInfoDefigner;
import com.summer.excelhelper.importexcel.IImportExcel;
import com.summer.excelhelper.pojo.MappingInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiashanhao
 * @date 2019-04-30 18:06
 */
public abstract class AbstractImportExcel implements IImportExcel {


    protected Map<Integer, MappingInfo> mappingCollection = new HashMap();

    protected String inputDirectory = System.getProperty("user.dir");

    protected String inputFileName = "";

    protected String outPutDirectory = System.getProperty("user.dir");

    protected String outputFileName = "";

    protected Integer readSheet = 0;

    protected Integer startRow = 0;

    protected Integer tempRow = 0;

    protected Long endRow = Long.MAX_VALUE;

    protected Class<? extends MappingInfoDefigner> defaultDefigner = ClassMappingInfoDefigner.class;

    public IImportExcel setReadSheet(Integer i) {
        this.readSheet = i;
        return this;
    }

    public IImportExcel setStarRow(Integer startRow) {
        this.startRow = startRow;
        return this;
    }

    public IImportExcel setEndRow(Long endRow) {
        this.endRow = endRow;
        return this;
    }

    public IImportExcel setInputFileName(String fileName) {
        this.inputFileName = fileName;
        return this;
    }

    public IImportExcel setOutputFileName(String fileName) {
        this.outputFileName = fileName;
        return this;
    }

    public IImportExcel setOutputFileDir(String dir) {
        this.outPutDirectory = dir;
        return this;
    }

    public IImportExcel setInputFileDir(String dir) {
        this.inputDirectory = dir;
        return this;
    }

    public IImportExcel initMapping(MappingInfoDefigner defigner) {
        mappingCollection.putAll(defigner.define());
        return this;
    }

    public Map<Integer, MappingInfo> getMapping() {
        return mappingCollection;
    }
}
