package com.stock.project.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class BlockBaseEntity {
    private Integer id;
    private String blockcode;
    private String blockname;
    private int blocktype;
    private String blockcount;
    private String blockfstname;
}
