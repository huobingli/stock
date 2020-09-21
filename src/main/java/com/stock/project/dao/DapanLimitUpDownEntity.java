package com.stock.project.dao;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DapanLimitUpDownEntity {
    private Integer id;
    private String time;
    private Integer limitup;
    private Integer limitdown;
}
