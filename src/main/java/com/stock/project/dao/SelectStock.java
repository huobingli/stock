package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

public interface SelectStock {
    ResultEntity Select(@Param("username") String name);
}
