package com.stock.project.controller;

import com.stock.project.dao.SxxData;
import com.stock.project.dao.SxxDataEntity;
import com.stock.project.model.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SxxDataController {
    @Autowired
    private SxxData sxxData;

    @RequestMapping("UpdateSxxData")
    //@RequestBody
    public ResultVo UpdateSxxData() {
        try {
//            解析文件
            String strfile = "D:/gitProject/stock/file/17_XY.txt";
            List<String> arrayXY_17 = readFile(strfile);

            strfile = "D:/gitProject/stock/file/33_XY.txt";
            List<String> arrayXY_33 = readFile(strfile);

            arrayXY_17.addAll(arrayXY_33);

            strfile = "D:/gitProject/stock/file/17_SXXX.txt";
            List<String> arraySXXX_17 = readFile(strfile);

            strfile = "D:/gitProject/stock/file/33_SXXX.txt";
            List<String> arraySXXX_33 = readFile(strfile);

            arraySXXX_17.addAll(arraySXXX_33);

            Integer count = arrayXY_17.size() > arraySXXX_17.size() ? arrayXY_17.size() : arraySXXX_17.size();

//            预处理
            List<SxxDataEntity> arrayList = new ArrayList<>();

//            600000;20210427;36.5854;51.9802;-15.3948
            for (Integer i = 0; i < arraySXXX_17.size(); i++ ) {
                String str = arraySXXX_17.get(i);
                String[] s1=str.split(";");

                if (s1.length != 5)
                    continue;

                String strCode = s1[0].substring(1);
                if (strCode.length() < 1) {
                    continue;
                }

                String strtime = s1[1];
                if (strtime.equals("20210427")) {
                    continue;
                }

                SxxDataEntity data = new SxxDataEntity();
                data.setCode(strCode).setTime(strtime).setSxxx120(s1[2]).setSxxx250(s1[3]).setSxxx(s1[4]);
                arrayList.add(data);
            }

//            600000;20210427;10.9071;7.4268
            for (Integer i = 0; i < arrayXY_17.size(); i++ ) {

                String str = arrayXY_17.get(i);
                String[] s1 = str.split(";");

                if (s1.length != 4)
                    continue;

                String strCode = s1[0].substring(1);
                if (strCode.length() < 1) {
                    continue;
                }

                String strtime = s1[1];
                if (strtime.equals("20210427")) {
                    continue;
                }


                for (Integer j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).getCode().equals(strCode)) {
                        arrayList.get(j).setXy120(s1[2]).setXy250(s1[3]);
                        break;
                    }
                }
            }

            sxxData.InsertSxxData(arrayList);
            return ResultVo.success("插入成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(-1, "抛出异常");
        }
    }

    @RequestMapping("SelectSxxData")
    //@RequestBody
    public ResultVo SelectSxxData() {
        try {
            List<SxxDataEntity> result = sxxData.SelectSxxInfoList();

            return ResultVo.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVo.error(-1, "抛出异常");
        }
    }

    public List<String> readFile(String path) {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<String>();
        try {
            FileInputStream fis = new FileInputStream(path);
            // 防止路径乱码  如果utf-8 乱码 改GBK   eclipse里创建的txt 用UTF-8，在电脑上自己创建的txt 用GBK
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                // 如果 t x t文件里的路径 不包含---字符串    这里是对里面的内容进行一个筛选
                if (line.lastIndexOf("---") < 0) {
                    if(line.contains("20210427"))
                        continue;

                    list.add(line);
                }
            }
            br.close();
            isr.close();
            fis.close();
        }
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
        return list;
    }
}
