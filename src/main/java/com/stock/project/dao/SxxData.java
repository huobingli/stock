package com.stock.project.dao;

import java.util.List;

public interface SxxData {
    void InsertSxxData(List<SxxDataEntity> list);

    // 大盘涨跌数据
    List<SxxDataEntity> SelectSxxInfoList();
}
