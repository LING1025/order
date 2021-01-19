package com.funtl.myshop.plus.controller;


import com.funtl.myshop.plus.dto.DistanceParams;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LocationUtils {
    //key
    private static final String KEY = "SNABZ-2EICD-4PZ4A-PB5J4-2KYT2-TWBAK";

    /**
     * 经纬度转地址
     * @param lng
     * @param lat
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getLocation(String lng, String lat) throws Exception {

        Map<String, Object> resultMap = new HashMap<String, Object>();

        // 参数解释：lng：经度，lat：维度。KEY：腾讯地图key，get_poi：返回状态。1返回，0不返回
        String urlString = "http://apis.map.qq.com/ws/geocoder/v1/?location=" + lat + "," + lng + "&key=" + KEY + "&get_poi=1";
        String result = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            // 腾讯地图使用GET
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 获取地址解析结果
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }

        // 转JSON格式
        JSONObject jsonObject = JSONObject.fromObject(result).getJSONObject("result");
        // 获取地址（行政区划信息） 包含有国籍，省份，城市
        JSONObject adInfo = jsonObject.getJSONObject("ad_info");
        resultMap.put("nation", adInfo.get("nation"));
        resultMap.put("nationCode", adInfo.get("nation_code"));
        resultMap.put("province", adInfo.get("province"));
        resultMap.put("provinceCode", adInfo.get("adcode"));
        resultMap.put("city", adInfo.get("city"));
        resultMap.put("cityCode", adInfo.get("city_code"));
        return resultMap;
    }

    /**
     * 关键词输入提示地址
     * @param
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getLocations(String region,String keyword) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        String urlString = "https://apis.map.qq.com/ws/place/v1/suggestion/?region="
                + region
                +"&keyword="+ keyword
                + "&key=" + KEY;
        String result = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            // 腾讯地图使用GET
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 获取地址解析结果
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }



        JSONArray jsonArray = JSONObject.fromObject(result).getJSONArray("data");

//        JSONObject jsonObject = jsonArray.getJSONObject(0);
//        resultMap.put("address",jsonObject.get("address"));
//        resultMap.put("location", jsonObject.get("location"));

        resultMap.put("data", jsonArray);
        return resultMap;
    }

    /**
     * 经纬度计算距离
     * @param distanceParams
     * @return
     * @throws Exception
     */
    public static Map<String, Object> getDistance(DistanceParams distanceParams) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        String urlString = "https://apis.map.qq.com/ws/distance/v1/matrix/?mode="
                + distanceParams.getMode()
                +"&from="+ distanceParams.getFrom()
                +"&to="+ distanceParams.getTo()
                + "&key=" + KEY;
        String result = "";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            // 腾讯地图使用GET
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 获取地址解析结果
            while ((line = in.readLine()) != null) {
                result += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }

        JSONObject jsonObject = JSONObject.fromObject(result).getJSONObject("result");
        resultMap.put("result", jsonObject.toString());
        return resultMap;
    }


    public static void main(String[] args) throws Exception {

        // 测试
        String lng = "111.546112";//经度
        String lat = "24.378622";//维度
        Map<String, Object> map = getLocation(lng, lat);
        System.out.println(map);

        String region="苏州";
        String keyword="格上";
        Map<String, Object> map2 = getLocations(region,keyword);
        System.out.println(map2);

        DistanceParams distanceParams = new DistanceParams();
        distanceParams.setMode("driving");
        distanceParams.setFrom("31.288530854,120.666760427;31.288530854,120.666760427");
        distanceParams.setTo("31.35458833,120.700719984;31.35458833,120.700719984");
        distanceParams.setKey("SNABZ-2EICD-4PZ4A-PB5J4-2KYT2-TWBAK");
        Map<String, Object> map3 = getDistance(distanceParams);
        System.out.println(map3);
    }

}
