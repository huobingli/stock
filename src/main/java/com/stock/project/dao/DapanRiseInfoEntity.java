package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DapanRiseInfoEntity {
    private Integer id;
    private String time;
    private Integer zf_zero_num;
    private Integer df_zero_num;
}