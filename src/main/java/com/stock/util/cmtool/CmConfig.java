package com.stock.util.cmtool;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true)
public class CmConfig {
    private Double tan;
    private Double sep;
    private Integer chipCount;
    private Double x;


    public Integer getChipCount() {
        if (chipCount == null || chipCount <= 0) {
            chipCount = 100;
        }
        return chipCount;
    }


    public void setChipCount(Integer chipCount) {
        this.chipCount = chipCount;
    }


    public double getTan() {
        if (tan == null || tan <= 0) {
            tan = 1.0;
        }
        return tan;
    }


    public void setTan(double tan) {
        this.tan = tan;
    }


    public double getSep() {
        if (sep == null || sep <= 0) {
            sep = 0.01;
        }
        return sep;
    }


    public void setSep(double sep) {
        this.sep = sep;
    }


    public double getX() {
        if (x == null || x <= 0) {
            x = 2.0;
        }
        return x;
    }


    public void setX(double x) {
        this.x = x;
    }


    @Override
    public String toString() {        return "CmConfig{" +
            "tan=" + getTan() +
            ", sep=" + getSep() +
            ", x=" + getX() +
            '}';
    }
}
