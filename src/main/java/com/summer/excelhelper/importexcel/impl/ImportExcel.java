package com.summer.excelhelper.importexcel.impl;

import com.summer.excelhelper.common.impl.ClassMappingInfoDefigner;
import com.summer.excelhelper.importexcel.abs.AbstractImportExcel;
import com.summer.excelhelper.pojo.MappingInfo;
import com.summer.excelhelper.utils.AssertUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiashanhao
 * @date 2019-04-30 17:17
 */
public class ImportExcel extends AbstractImportExcel {

    public <T> List<T> read(Class<T> targetClass) throws Exception {
        // do  check some necessary parament befor read excel file
        checkNecessaryParament();
        ArrayList<T> resultList = new ArrayList();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(inputDirectory + "/" + inputFileName)));
        XSSFSheet sheet = workbook.getSheetAt(readSheet);
        if (sheet == null) {
            return resultList;
        }
        tempRow = startRow;
        while (endRow >= tempRow) {
            XSSFRow row = sheet.getRow(tempRow);

            if (row == null) {
                break;
            }
            T obj = targetClass.newInstance();
            for (Map.Entry<Integer, MappingInfo> entry : mappingCollection.entrySet()) {
                XSSFCell cell = row.getCell(entry.getKey());
                if (cell == null) {
                    continue;
                }
                MappingInfo mapInfo = entry.getValue();
                Method method = targetClass.getMethod(mapInfo.getMethodName(), mapInfo.getParamentType());
                Object value = null;
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_BLANK:
                        value = convert.blankConvert(null, mapInfo.getParamentType()[0]);
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        break;
                    case XSSFCell.CELL_TYPE_ERROR:
                        value = convert.errorConvert(cell.getErrorCellValue(), mapInfo.getParamentType()[0]);
                        break;
                    case XSSFCell.CELL_TYPE_FORMULA:
                        value = convert.formulaConvert(cell.getCellFormula(), mapInfo.getParamentType()[0]);
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        value = convert.numericConvert(cell.getNumericCellValue(), mapInfo.getParamentType()[0]);
                        break;
                    case XSSFCell.CELL_TYPE_STRING:
                        value = convert.stringConvert(cell.getStringCellValue(), mapInfo.getParamentType()[0]);
                        break;
                }
                method.invoke(obj, value);
            }
            resultList.add(obj);
            tempRow++;
        }
        return resultList;
    }

    public <T> List<T> readAndInitMapping(Class<T> targetClass) throws Exception {
        initMapping(new ClassMappingInfoDefigner(targetClass));
        Set<Map.Entry<Integer, MappingInfo>> entries = mappingCollection.entrySet();
        return read(targetClass);
    }

    private void checkNecessaryParament() {
        AssertUtils.notNull(inputDirectory, "inputDirectory can not is null ");
        AssertUtils.notNull(outPutDirectory, "outPutDirectory can not is null ");
        AssertUtils.notBlank(inputFileName, "inputFileName can not is blank ");
//        AssertUtils.notBlank(outputFileName, "outputFileName can not is blank ");
        AssertUtils.notEmpty(mappingCollection, "mappingCollection can not is empty");
        AssertUtils.notNull(startRow, "startRow can not is null");
        AssertUtils.notNull(endRow, "endRow can not is null");
        AssertUtils.notNull(readSheet, "readSheet can not is null");
        AssertUtils.notNull(defaultDefigner, "defaultDefigner can not is null");
        AssertUtils.notNull(convert, "convert can not is null");
        AssertUtils.isExist(new File(inputDirectory + "/" + inputFileName), "inputfile not exist or is dir!");
        AssertUtils.isTrue(endRow > startRow, "startRow and not great than endRow");
    }

}
