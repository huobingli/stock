package com.stock.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stock.project.dao.DapanDataEntity;
import com.stock.project.dao.UpdateDapanData;
import com.stock.project.model.ResultVo;
import com.stock.project.util.limitupdown.DapanData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UpdateDapanController {

    @Autowired
    private UpdateDapanData updateDapanData;

    @Autowired
    private DapanData dapanData;

    // 仅仅用来更新数据
    @RequestMapping("UpdateDapanData")
    public ResultVo ExecuteUpdateData(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        try {
            String string = dapanData.RequestDapanRiseUpData(startDate, endDate);

            JSONObject json = JSON.parseObject(string);
            JSONArray arrayData = json.getJSONArray("data");
            List<DapanDataEntity> arrayList = new ArrayList<>();

            SimpleDateFormat formatter = new SimpleDateFormat("YY-MM-dd");

            for (int i = 0; i < arrayData.size(); i++) {
                JSONObject data = arrayData.getJSONObject(i);

                DapanDataEntity dp = new DapanDataEntity();

                // 日期
                long lTime = Long.parseLong(data.getString("add_date"));
                Date date = new Date(lTime);

                dp.setId(data.getInteger("id")).setTime(data.getString("add_date")).
                    setDt_num(data.getInteger("dt_num")).
                    setZt_num(data.getInteger("zt_num")).
                    setZrztbx(data.getDouble("zrztbx")).
                    setSzzs(data.getDouble("zrztbx")).
                    setZf_zero_num(data.getInteger("zf_zero_num")).
                    setDf_zero_num(data.getInteger("df_zero_num")).
                    setZf_five_num(data.getInteger("zf_five_num")).
                    setDf_five_num(data.getInteger("df_five_num")).
                    setDate(formatter.format(date));
                arrayList.add(dp);
            }

            updateDapanData.InsertDapanData2(arrayList);
            return ResultVo.success("插入成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(-1, "抛出异常");
        }
    }


    @RequestMapping("RequestDapanDataRetJson")
    @ResponseBody
    public ResultVo ExecuteUpdateTradingInfoData(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        try {
            String string = dapanData.RequestDapanRiseUpData(startDate, endDate);

            return ResultVo.success(string);
        } catch (Exception e) {

        }
        return ResultVo.success("error");
    }
}
