package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectStock {
    ResultEntity Select(@Param("username") String name);
    //String Select(@Param("username") String name);

    List<ResultEntity> SelectList(@Param("username") String name);
}
