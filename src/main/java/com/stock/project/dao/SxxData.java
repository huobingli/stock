package com.stock.project.dao;

import java.util.List;

public interface SxxData {
    void InsertSxxData(List<SxxDataEntity> list);

    // 获取数据
    List<SxxDataRetEntity> SelectSxxInfoList();

    List<SxxDataSxxxXyEntity> SelectSxxxXyList();

    List<SxxDataEntity> SelectAllList();
}
