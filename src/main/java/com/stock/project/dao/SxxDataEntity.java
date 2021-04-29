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
    private String code;
    private String sxxx;
    private String xy;
}
