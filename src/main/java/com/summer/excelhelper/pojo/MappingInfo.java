package com.summer.excelhelper.pojo;

import java.util.Arrays;

/**
 * Use fro record mapping info between excel and java object
 *
 * @author xiashanhao
 * @date 2019-04-30 16:49
 */
public class MappingInfo {

    /**
     * excel column number
     */
    Integer index;

    /**
     * will invoked method name
     */
    String methodName;

    /**
     * the invoked method's parament type
     */
    Class[] paramentType;

    /**
     * whether force convert cell value to parament type. If set is true ,
     * must ensure jvm allow,otherwise the tool will throw error.
     */
    Boolean forceConvert;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamentType() {
        return paramentType;
    }

    public void setParamentType(Class[] paramentType) {
        this.paramentType = paramentType;
    }

    public Boolean getForceConvert() {
        return forceConvert;
    }

    public void setForceConvert(Boolean forceConvert) {
        this.forceConvert = forceConvert;
    }

    @Override
    public String toString() {
        return "MappingInfo{" +
                "index=" + index +
                ", methodName='" + methodName + '\'' +
                ", paramentType=" + Arrays.toString(paramentType) +
                ", forceConvert=" + forceConvert +
                '}';
    }
}
