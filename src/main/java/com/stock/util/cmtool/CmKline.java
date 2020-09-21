package com.stock.util.cmtool;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

@Data
public class CmKline {
    @JsonAlias("1")
    @JsonFormat(pattern = "yyyyMMdd")
    private Date date;
    @JsonAlias("7")
    private Double open;
    @JsonAlias("8")
    private Double high;
    @JsonAlias("9")
    private Double low;
    @JsonAlias("11")
    private Double close;
    @JsonAlias("13")
    private Long volume;


    @Override
    public String toString() {        return "K{" +
            "date=" + date +
            ", open=" + open +
            ", high=" + high +
            ", low=" + low +
            ", close=" + close +
            ", volume=" + volume +
            '}';
    }
}
