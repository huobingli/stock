package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// 插入到数据库里结构
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DapanDataEntity {
    private Integer id;
    private String time;
    private String date;
    private Integer zt_num;
    private Integer dt_num;
    private Double zrztbx;
    private Integer zf_zero_num;
    private Integer df_zero_num;
    private Integer zf_five_num;
    private Integer df_five_num;
    private Double szzs;
}