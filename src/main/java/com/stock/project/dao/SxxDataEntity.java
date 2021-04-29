package com.stock.project.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SxxDataEntity {
    private Integer id;
    private String time;
    private String code;
    private String sxxx120;
    private String sxxx250;
    private String sxxx;
    private String xy120;
    private String xy250;
}
