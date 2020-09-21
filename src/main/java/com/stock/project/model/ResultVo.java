package com.stock.project.model;

public class ResultVo {
    private Integer code;
    private String msg;
    private Object data;

    public static ResultVo error(Integer code, String msg) {
        return new ResultVo(code, msg, null);
    }

    public static ResultVo success(Integer data) {
        return new ResultVo(0, "success", data);
    }

    public static ResultVo success(Object data) {
        return new ResultVo(0, "success", data);
    }

    public ResultVo(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
