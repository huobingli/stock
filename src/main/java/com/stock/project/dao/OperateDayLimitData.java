package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperateDayLimitData {

    DayLimitDataEntity Select(@Param("limitday") Integer limitday);
    //String Select(@Param("username") String name);

    List<DayLimitDataEntity> SelectList(@Param("limitday") Integer limitday);
}
