package com.summer.excelhelper.common.impl;

import com.summer.excelhelper.annotation.ImportField;
import com.summer.excelhelper.common.MappingInfoDefigner;
import com.summer.excelhelper.pojo.MappingInfo;
import com.summer.excelhelper.utils.AssertUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过获取类注解的方式定义mapping 信息
 *
 * @author xiashanhao
 * @date 2019-04-30 17:29
 */
public class ClassMappingInfoDefigner implements MappingInfoDefigner {

    private Class cla;

    public ClassMappingInfoDefigner(Class cla) {
        this.cla = cla;
    }

    public Map<Integer, MappingInfo> define() {
        AssertUtils.notNull(cla, "class cannot is null");
        HashMap<Integer, MappingInfo> defineResult = new HashMap();
        Field[] fields = cla.getDeclaredFields();
        if (fields != null) {
            HashMap<Integer, MappingInfo> fieldResuld = doDefineByFields(fields);
            defineResult.putAll(fieldResuld);
        }
        Method[] methods = cla.getDeclaredMethods();
        if (methods != null) {
            HashMap<Integer, MappingInfo> methodResuld = doDefineByMethods(methods);
            defineResult.putAll(methodResuld);
        }
        return defineResult;
    }

    private HashMap<Integer, MappingInfo> doDefineByMethods(Method[] methods) {
        HashMap<Integer, MappingInfo> defineResult = new HashMap();
        for (Method method : methods) {
            ImportField anno = method.getAnnotation(ImportField.class);
            if (anno == null) {
                continue;
            }
            Class<?>[] types = method.getParameterTypes();
            if (method.getName().startsWith("set") && types != null && types.length == 1) {
                MappingInfo mapinfo = new MappingInfo();
                mapinfo.setIndex(anno.index());
                mapinfo.setMethodName(method.getName());
                mapinfo.setParamentType(types);
                defineResult.put(anno.index(), mapinfo);
            }
        }
        return defineResult;
    }

    private HashMap<Integer, MappingInfo> doDefineByFields(Field[] fields) {
        HashMap<Integer, MappingInfo> defineResult = new HashMap();
        for (Field field : fields) {
            ImportField anno = field.getAnnotation(ImportField.class);
            if (anno == null) {
                continue;
            }
            MappingInfo mapinfo = new MappingInfo();
            mapinfo.setIndex(anno.index());
            mapinfo.setMethodName(convertToMethodName(field.getName()));
            mapinfo.setParamentType(new Class[]{field.getType()});
            defineResult.put(anno.index(), mapinfo);
        }
        return defineResult;
    }

    private String convertToMethodName(String fieldName) {
        String firstChar = fieldName.substring(0, 1);
        String remaining = fieldName.substring(1);
        return "set" + firstChar.toUpperCase() + remaining;
    }
}

