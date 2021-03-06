package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DapanLimitUpDownEntity {
    private Integer id;
    private String time;
    private Integer zt_num;
    private Integer dt_num;
//    private Double zrztbx;
}

