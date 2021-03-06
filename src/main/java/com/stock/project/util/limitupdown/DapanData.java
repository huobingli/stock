package com.stock.project.util.limitupdown;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.stock.project.model.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

@RestController
//大盘涨跌停数
public class DapanData {

    //@Autowired
    //private UpdateDapanData dapanData;

//    @RequestMapping("RequstDapanData")
//    @ResponseBody
//    public static String RequestData(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
    public static String RequestDapanRiseUpData(String startDate, String endDate) {
        try {
            // 结束日期不传 默认获取日期
            if (endDate.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date(System.currentTimeMillis());
                endDate = formatter.format(date);
            }

            //URL url = new URL("http://gpc.10jqka.com.cn/dptrend/zqxy/charts?startDate=20200101&endDate=20200921");
            URL url = new URL("http://gpc.10jqka.com.cn/dptrend/zqxy/charts?startDate=" + startDate + "&endDate=" + endDate);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            } else {
//                String strRet = "URL错误";
                return "false";
                //return ResultVo.success("URL错误");
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
//            System.out.println(urlString);


            return urlString; //ResultVo.success(urlString);//UpdateDapanData(urlString);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //return ResultVo.success("请求成功");
        return "false";
//        return urlString;
    }

    //http://gpc.10jqka.com.cn/dptrend/fund/MarginTradingInfo/get?startDate=20180921&endDate=20200921
    public static String RequestTradingInfoData(String startDate, String endDate) {
        try {
            // 结束日期不传 默认获取日期
            if (endDate.isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date(System.currentTimeMillis());
                endDate = formatter.format(date);
            }

            URL url = new URL("http://gpc.10jqka.com.cn/dptrend/fund/MarginTradingInfo/get?startDate=" + startDate + "&endDate=" + endDate);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                // 设置下 cookies
                connection.setRequestProperty("Cookie", "searchGuide=sg; __utma=156575163.232964267.1582016786.1582016786.1582016786.1; Hm_lvt_78c58f01938e4d85eaf619eae71b4ed1=1598589480,1599119768; user=MDp0ZXN0anJkczQ6Ok5vbmU6NTAwOjM5MzIzMjYzMTo0LDEwMDAwMDAwMTAwMTAwMDAwMDExMTExMSwzNTc7NSwxLDQwOzYsMSw0MDs3LDExMTExMTExMTExMCw0MDs4LDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAxMDAwMDEwMDExLDQwOzIwLDEsMzU3OzIyLDEsMzU3OzI2LDEsMzU3OzI3LDEsMzU3OzI5LDEsMzU3OzMzLDAwMTEwMDAwMDAxMSwzNTc7MzYsMTAwMTExMTExMDAwMTExMTEwMTExMTExLDM1Nzs0MSwxMTExMSwzNTc7NDIsMTAwMTAxLDM1Nzs0MywxMDExMTExMTExMTExMTExMTExMTExMTEsMzU3OzQ0LDExMTExLDQwOzQ1LDEwMTExMTExMSwzNTc7NDYsMDExMDExMTExMDAwMDAxMTExMTExMTExLDM1Nzs0NywxMTExMTExMTExMTExMTEsMzU3OzQ4LDExMTExMTExMTExMTExMTExMTExMTExMTExMTExMTExLDM1Nzs1MCwxMSwzNTc7NTEsMTEwMDAwMDAwMDAwMDAwMCwzNTc7NTIsMDExMDAsMzU3OzU0LDEwMDAwMDAwMDAwMDAwMDAwMDAwMDAxMDAwMDAwMDAwLDM1Nzs1NiwxMSwzNTc7NTcsMTExMTExMTExMTExMTExMTExMTExMTExMTExMSwzNTc7NTgsMTExMTExMTExMTExMTExMTEsMzU3OzYwLDExMTExMTExMTExMTExMTExLDM1Nzs2MSwxMSwzNTc7NjIsMTEwMDAwMDAwMDAwMDAwMDEwMDAwMDAwLDM1Nzs2MywxMDAxMDAwMTAwMDAwMDAwMDAwMDAwMDAsMzU3OzY0LDAwMDExMTEwMDEwMDAwMDAwMDAxMDAwMCwzNTc7NjYsMTExMTExMTExMTExMTAsMzU3OzY4LDExMTExMTExMTAxMTExMTExMDAwLDM1Nzs3MywxMTExMDAsMzU3Ozc3LDEwMDAwMTAsMzU3Ozc4LDEsMzU3OzkxLDExMTExMTEsMzU3OzkyLDAwMDAwMTAwLDM1NzsxLDEwMSw0MDsyLDEsNDA7MywxLDQwOzEwMiwxLDQwOjk6OjozODMyMzI2MzE6MTYwMDczNzk1Nzo6OjE0ODkwMzgxODA6MjI4ODQzOjA6MWFhMmFiODk1YTE0NmZkN2VmOTI1YTAwZTE5MmFjZTE4Ojow; userid=383232631; u_name=testjrds4; escapename=testjrds4; ticket=df1384d64259c29360f28af895f70e89; user_status=0; laravel_session=hx10jqka480a17e262b5d24cdf07407e122d8ee6; @#!userid!#@=383232631; @#!sessionid!#@=18fd7689bf3dc402fc559af96140b20c7; @#!rsa_version!#@=default_4; v=AjZBpTdsde1rvwGJSJa5jTdvh2c6V3qRzJuu9aAeIpm049zZCOfKoZwr_gFz");
            } else {
                return "false";
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }

            return urlString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "false";
    }


    //@RequestMapping("RequstDapanData1")
    @RequestMapping("testPost")
//    @RequestMapping(value = "testPost", method = RequestMethod.POST)
    @ResponseBody
    public static String RequestData1() {
        RestTemplate restTemplate = new RestTemplate();
        String url="https://www.baidu.com";
        ResponseEntity<String> entity= restTemplate.getForEntity(url, String.class);
        String body = entity.getBody();

        return body;
    }


    @RequestMapping("testUpdate")
    @ResponseBody
    public static void UpdateDapanData(String string) {
        try {
            string = "{\"code\":0,\"message\":\"success\",\"data\":[{\"id\":259938,\"ctime\":1600423179000,\"mtime\":1600423179000,\"add_date\":1600358400000,\"zt_num\":44,\"dt_num\":1,\"zf_zero_num\":3134,\"df_zero_num\":768,\"zf_five_num\":216,\"df_five_num\":47,\"szzs\":3338.09,\"zrztbx\":1.48,\"lbl\":18.52,\"lb_stock_num\":2,\"short_fhxy\":1.04,\"medium_fhxy\":-2.82,\"blue_barometer_zf\":2.24,\"theme_concept_zf\":1.20},{\"id\":258888,\"ctime\":1600336779000,\"mtime\":1600336779000,\"add_date\":1600272000000,\"zt_num\":27,\"dt_num\":4,\"zf_zero_num\":1999,\"df_zero_num\":1812,\"zf_five_num\":190,\"df_five_num\":45,\"szzs\":3270.44,\"zrztbx\":2.10,\"lbl\":18.18,\"lb_stock_num\":1,\"short_fhxy\":-0.85,\"medium_fhxy\":-4.06,\"blue_barometer_zf\":-0.16,\"theme_concept_zf\":0.69},{\"id\":257838,\"ctime\":1600250379000,\"mtime\":1600250379000,\"add_date\":1600185600000,\"zt_num\":22,\"dt_num\":4,\"zf_zero_num\":1111,\"df_zero_num\":2711,\"zf_five_num\":119,\"df_five_num\":60,\"szzs\":3283.92,\"zrztbx\":0.92,\"lbl\":9.38,\"lb_stock_num\":1,\"short_fhxy\":0.08,\"medium_fhxy\":-3.24,\"blue_barometer_zf\":-0.30,\"theme_concept_zf\":-0.38},{\"id\":256788,\"ctime\":1600163979000,\"mtime\":1600163979000,\"add_date\":1600099200000,\"zt_num\":32,\"dt_num\":3,\"zf_zero_num\":1846,\"df_zero_num\":1950,\"zf_five_num\":190,\"df_five_num\":56,\"szzs\":3295.68,\"zrztbx\":0.31,\"lbl\":5.88,\"lb_stock_num\":1,\"short_fhxy\":0.41,\"medium_fhxy\":-3.05,\"blue_barometer_zf\":0.70,\"theme_concept_zf\":0.29},{\"id\":255738,\"ctime\":1600077580000,\"mtime\":1600077580000,\"add_date\":1600012800000,\"zt_num\":51,\"dt_num\":7,\"zf_zero_num\":2650,\"df_zero_num\":1148,\"zf_five_num\":470,\"df_five_num\":26,\"szzs\":3278.81,\"zrztbx\":4.90,\"lbl\":22.22,\"lb_stock_num\":1,\"short_fhxy\":-1.32,\"medium_fhxy\":-3.58,\"blue_barometer_zf\":0.36,\"theme_concept_zf\":1.68},{\"id\":254688,\"ctime\":1599818379000,\"mtime\":1599818379000,\"add_date\":1599753600000,\"zt_num\":36,\"dt_num\":6,\"zf_zero_num\":2957,\"df_zero_num\":864,\"zf_five_num\":353,\"df_five_num\":67,\"szzs\":3260.35,\"zrztbx\":0.58,\"lbl\":6.25,\"lb_stock_num\":0,\"short_fhxy\":-0.74,\"medium_fhxy\":-2.66,\"blue_barometer_zf\":0.82,\"theme_concept_zf\":1.56},{\"id\":253638,\"ctime\":1599731979000,\"mtime\":1599731979000,\"add_date\":1599667200000,\"zt_num\":16,\"dt_num\":73,\"zf_zero_num\":499,\"df_zero_num\":3435,\"zf_five_num\":55,\"df_five_num\":1011,\"szzs\":3234.82,\"zrztbx\":-8.15,\"lbl\":6.67,\"lb_stock_num\":0,\"short_fhxy\":3.08,\"medium_fhxy\":-1.43,\"blue_barometer_zf\":-0.65,\"theme_concept_zf\":-3.73},{\"id\":252588,\"ctime\":1599645579000,\"mtime\":1599645579000,\"add_date\":1599580800000,\"zt_num\":30,\"dt_num\":19,\"zf_zero_num\":687,\"df_zero_num\":3191,\"zf_five_num\":76,\"df_five_num\":811,\"szzs\":3254.63,\"zrztbx\":-0.73,\"lbl\":17.02,\"lb_stock_num\":2,\"short_fhxy\":0.21,\"medium_fhxy\":-5.05,\"blue_barometer_zf\":-2.35,\"theme_concept_zf\":-2.56},{\"id\":251538,\"ctime\":1599559179000,\"mtime\":1599559179000,\"add_date\":1599494400000,\"zt_num\":47,\"dt_num\":10,\"zf_zero_num\":2617,\"df_zero_num\":1286,\"zf_five_num\":297,\"df_five_num\":89,\"szzs\":3316.42,\"zrztbx\":5.26,\"lbl\":35.48,\"lb_stock_num\":5,\"short_fhxy\":-0.49,\"medium_fhxy\":-5.54,\"blue_barometer_zf\":0.53,\"theme_concept_zf\":1.02},{\"id\":250564,\"ctime\":1599472779000,\"mtime\":1599472779000,\"add_date\":1599408000000,\"zt_num\":31,\"dt_num\":15,\"zf_zero_num\":1007,\"df_zero_num\":2859,\"zf_five_num\":155,\"df_five_num\":266,\"szzs\":3292.59,\"zrztbx\":5.26,\"lbl\":38.46,\"lb_stock_num\":4,\"short_fhxy\":-1.04,\"medium_fhxy\":-5.42,\"blue_barometer_zf\":-2.04,\"theme_concept_zf\":-1.00},{\"id\":249514,\"ctime\":1599213579000,\"mtime\":1599213579000,\"add_date\":1599148800000,\"zt_num\":26,\"dt_num\":9,\"zf_zero_num\":1876,\"df_zero_num\":1961,\"zf_five_num\":167,\"df_five_num\":74,\"szzs\":3355.37,\"zrztbx\":1.73,\"lbl\":20.69,\"lb_stock_num\":2,\"short_fhxy\":-1.10,\"medium_fhxy\":-4.69,\"blue_barometer_zf\":-0.77,\"theme_concept_zf\":0.33},{\"id\":248464,\"ctime\":1599127179000,\"mtime\":1599127179000,\"add_date\":1599062400000,\"zt_num\":29,\"dt_num\":6,\"zf_zero_num\":1101,\"df_zero_num\":2742,\"zf_five_num\":117,\"df_five_num\":166,\"szzs\":3384.98,\"zrztbx\":2.60,\"lbl\":21.62,\"lb_stock_num\":1,\"short_fhxy\":0.29,\"medium_fhxy\":-3.75,\"blue_barometer_zf\":-0.54,\"theme_concept_zf\":-0.83},{\"id\":247418,\"ctime\":1599040779000,\"mtime\":1599040779000,\"add_date\":1598976000000,\"zt_num\":37,\"dt_num\":3,\"zf_zero_num\":1923,\"df_zero_num\":1904,\"zf_five_num\":264,\"df_five_num\":40,\"szzs\":3404.80,\"zrztbx\":3.02,\"lbl\":13.51,\"lb_stock_num\":1,\"short_fhxy\":-0.72,\"medium_fhxy\":-3.92,\"blue_barometer_zf\":-0.06,\"theme_concept_zf\":0.66},{\"id\":246368,\"ctime\":1598954379000,\"mtime\":1598954379000,\"add_date\":1598889600000,\"zt_num\":37,\"dt_num\":7,\"zf_zero_num\":2138,\"df_zero_num\":1652,\"zf_five_num\":206,\"df_five_num\":39,\"szzs\":3410.61,\"zrztbx\":2.00,\"lbl\":17.78,\"lb_stock_num\":0,\"short_fhxy\":-0.46,\"medium_fhxy\":-3.30,\"blue_barometer_zf\":0.59,\"theme_concept_zf\":1.05}]}";
//            JSONObject json = new JSONObject(string);
            JSONObject json = JSON.parseObject(string);

            JSONArray arrayData = json.getJSONArray("data");

            for (Object name : arrayData) {
                System.out.println(name);
            }
        } catch (Exception e) {

        }
    }

    @RequestMapping("testDate")
    //@RequestBody
    public static ResultVo testDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        String endDate = formatter.format(date);

        return ResultVo.success(endDate);
    }
}
