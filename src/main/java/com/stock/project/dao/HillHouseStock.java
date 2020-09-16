package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HillHouseStock {
    HillHouseEntity Select(@Param("param") String param);
    List<HillHouseEntity> SelectList(@Param("param") String param);
}
