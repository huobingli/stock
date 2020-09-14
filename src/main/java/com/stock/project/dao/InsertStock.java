package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

public interface InsertStock {
    void Insert(@Param("code") String code, @Param("name") String name, @Param("industry") String industry);
}
