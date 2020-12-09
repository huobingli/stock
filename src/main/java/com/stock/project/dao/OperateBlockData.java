package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperateBlockData {
    void InsertBlockData(@Param("blockcode") String blockcode, @Param("date") String date,
                         @Param("rise") String rise);

    void InsertBlockData2(List<BlockDataEntity> list);

    void InsertBlockBaseData(@Param("blockcode") String blockcode, @Param("date") String date,
                         @Param("rise") String rise);

    void InsertBlockBaseData2(List<BlockBaseEntity> list);
}
