package com.stock.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@RestController
public class GetBlockDataController {

    @RequestMapping("GetBlockDataHotTrack")
    public static String GetBlockDataHotTrack() {
        try {
            URL url = new URL("http://l2.10jqka.com.cn/hottrack/api/getcircleblocks");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                // 设置下 cookies
                //connection.setRequestProperty("Cookie", "searchGuide=sg; __utma=156575163.232964267.1582016786.1582016786.1582016786.1; Hm_lvt_78c58f01938e4d85eaf619eae71b4ed1=1598589480,1599119768; user=MDp0ZXN0anJkczQ6Ok5vbmU6NTAwOjM5MzIzMjYzMTo0LDEwMDAwMDAwMTAwMTAwMDAwMDExMTExMSwzNTc7NSwxLDQwOzYsMSw0MDs3LDExMTExMTExMTExMCw0MDs4LDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAxMDAwMDEwMDExLDQwOzIwLDEsMzU3OzIyLDEsMzU3OzI2LDEsMzU3OzI3LDEsMzU3OzI5LDEsMzU3OzMzLDAwMTEwMDAwMDAxMSwzNTc7MzYsMTAwMTExMTExMDAwMTExMTEwMTExMTExLDM1Nzs0MSwxMTExMSwzNTc7NDIsMTAwMTAxLDM1Nzs0MywxMDExMTExMTExMTExMTExMTExMTExMTEsMzU3OzQ0LDExMTExLDQwOzQ1LDEwMTExMTExMSwzNTc7NDYsMDExMDExMTExMDAwMDAxMTExMTExMTExLDM1Nzs0NywxMTExMTExMTExMTExMTEsMzU3OzQ4LDExMTExMTExMTExMTExMTExMTExMTExMTExMTExMTExLDM1Nzs1MCwxMSwzNTc7NTEsMTEwMDAwMDAwMDAwMDAwMCwzNTc7NTIsMDExMDAsMzU3OzU0LDEwMDAwMDAwMDAwMDAwMDAwMDAwMDAxMDAwMDAwMDAwLDM1Nzs1NiwxMSwzNTc7NTcsMTExMTExMTExMTExMTExMTExMTExMTExMTExMSwzNTc7NTgsMTExMTExMTExMTExMTExMTEsMzU3OzYwLDExMTExMTExMTExMTExMTExLDM1Nzs2MSwxMSwzNTc7NjIsMTEwMDAwMDAwMDAwMDAwMDEwMDAwMDAwLDM1Nzs2MywxMDAxMDAwMTAwMDAwMDAwMDAwMDAwMDAsMzU3OzY0LDAwMDExMTEwMDEwMDAwMDAwMDAxMDAwMCwzNTc7NjYsMTExMTExMTExMTExMTAsMzU3OzY4LDExMTExMTExMTAxMTExMTExMDAwLDM1Nzs3MywxMTExMDAsMzU3Ozc3LDEwMDAwMTAsMzU3Ozc4LDEsMzU3OzkxLDExMTExMTEsMzU3OzkyLDAwMDAwMTAwLDM1NzsxLDEwMSw0MDsyLDEsNDA7MywxLDQwOzEwMiwxLDQwOjk6OjozODMyMzI2MzE6MTYwMDczNzk1Nzo6OjE0ODkwMzgxODA6MjI4ODQzOjA6MWFhMmFiODk1YTE0NmZkN2VmOTI1YTAwZTE5MmFjZTE4Ojow; userid=383232631; u_name=testjrds4; escapename=testjrds4; ticket=df1384d64259c29360f28af895f70e89; user_status=0; laravel_session=hx10jqka480a17e262b5d24cdf07407e122d8ee6; @#!userid!#@=383232631; @#!sessionid!#@=18fd7689bf3dc402fc559af96140b20c7; @#!rsa_version!#@=default_4; v=AjZBpTdsde1rvwGJSJa5jTdvh2c6V3qRzJuu9aAeIpm049zZCOfKoZwr_gFz");
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
}
