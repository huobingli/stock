package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/*
*   ID
*   代码
*   涨停日期
*   连续天数
*   类型
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DayLimitDataEntity {
    private Integer id;
    private String stockcode;
    private String limitday;
    private int continuity;
    private int type;
}
