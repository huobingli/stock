package com.stock.project.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stock.project.dao.BlockBaseEntity;
import com.stock.project.dao.BlockDataEntity;
import com.stock.project.dao.OperateBlockData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@RestController
public class GetBlockDataController {
    @Autowired
    private OperateBlockData operateBlockData;


    @RequestMapping("GetBlockDataHotTrack")
    public String GetBlockDataHotTrack() {
        String response = "";
        try {
            // 附加参数可以请求 多少条参数
            //http://l2.10jqka.com.cn/hottrack/api/getcircleblocks?daynum=30
            URL url = new URL("http://l2.10jqka.com.cn/hottrack/api/getcircleblocks");

            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;

            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                // 设置下 cookies
                //connection.setRequestProperty("Cookie", "");
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject json = JSON.parseObject(response);
        JSONObject result = json.getJSONObject("result").getJSONObject("mrpm");

        String strKey[] = {"up", "down"};
        List<BlockDataEntity> listData = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            JSONArray ayresult =  result.getJSONArray(strKey[i]);

            for (int j = 0; j< ayresult.size(); j++)
            {
                JSONObject objup = ayresult.getJSONObject(j);

                String strTime = objup.getString("datetime");

                JSONArray aysubresult = objup.getJSONArray("stocks");
                for (int k = 0; k < aysubresult.size(); k++)
                {
                    JSONObject objstock = aysubresult.getJSONObject(k);
                    //BlockDataEntity blockDataEntity = JSON.toJavaObject(obj,BlockDataEntity.class);
                    BlockDataEntity blockDataEntity = new BlockDataEntity();
                    blockDataEntity.setBlockcode(objstock.getString("stockcode"))
                            .setRise(objstock.getString("value"))
                            .setDate(strTime);
                    listData.add(blockDataEntity);
                }
            }
        }

        operateBlockData.InsertBlockData2(listData);

        return response;
    }

    @Autowired

    // 板块数据
    @RequestMapping("GetBlockData")
    public void GetBlockData() {
        String response = "";
        try {
            URL url = new URL("http://ai.10jqka.com.cn/stock/plate/keyboardfales?text=");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;

            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                // 设置下 cookies
                //connection.setRequestProperty("Cookie", "");
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<BlockBaseEntity> listData = new ArrayList<>();
        JSONObject json = JSON.parseObject(response);
        JSONArray resultArray = json.getJSONArray("result");
        for (int i = 0; i < resultArray.size(); i++)
        {
            JSONObject objResult = resultArray.getJSONObject(i);
            JSONArray subArray = objResult.getJSONArray("block_data");

            for (int j = 0; j < subArray.size(); j++)
            {
                JSONObject objentity = subArray.getJSONObject(j);

                BlockBaseEntity blockBaseEntity = new BlockBaseEntity();
                blockBaseEntity.setBlockcode(objentity.getString("block_code"))
                        .setBlockname(objentity.getString("block_name"))
                        .setBlocktype(i)
                        .setBlockfstname(objentity.getString("block_fstname"));

                listData.add(blockBaseEntity);
            }
        }

        operateBlockData.InsertBlockBaseData2(listData);
    }

}
