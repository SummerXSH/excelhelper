package com.summer.excelhelper.common;

import com.summer.excelhelper.pojo.MappingInfo;

import java.util.Map;

/**
 * @author xiashanhao
 * @date 2019-04-30 17:27
 */
public interface MappingInfoDefigner {

    Map<Integer, MappingInfo> define();
}
