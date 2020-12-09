package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BlockDataEntity {
    private Integer id;
    private String blockcode;
    private String date;
    private String rise;
}
