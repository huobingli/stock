package com.stock.project.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateDapanData {
//    Integer UpdateDapanData();
    void InsertDapanData(@Param("time") String time, @Param("date") String date,
                         @Param("szzs") Double szzs, @Param("zrztbx") Double zrztbx,
                         @Param("zt_num") Integer zt_num, @Param("dt_num") Integer dt_num,
                         @Param("zf_zero_num") Integer zf_zero_num, @Param("df_zero_num") Integer df_zero_num,
                         @Param("zf_five_num") Integer zf_five_num, @Param("df_five_num") Integer df_five_num);

    void InsertDapanData2(List<DapanDataEntity> list);
}
