package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateDapanData {
//    Integer UpdateDapanData();
    void InsertDapanData(@Param("time") String time, @Param("limitupcount") Integer limitupcount,
                         @Param("limitdowncount") Integer limitdowncount, @Param("prelimitup") String prelimitup);

    void InsertDapanData2(List<DapanLimitUpDownEntity> list);
}
