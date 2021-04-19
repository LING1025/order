package com.funtl.myshop.plus.business.controller;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestController {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        String line = null;
        File f1 = new File("D:\\twoWork\\log.txt");//获取接收到的数据
        File f2 = new File("D:\\twoWork\\logNew.txt");

        try {
            // 读取“log.txt”文件
            FileReader fileReader = new FileReader(f1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //正则
            String patternStr = "E6,";
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher("");
            while ((line = bufferedReader.readLine()) != null) {
                matcher.reset(line);
                if (matcher.find()) {
                    list.add(line);
                }
            }

            // 写入“logNew.txt”文件
            FileWriter fileWriter = new FileWriter(f2);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).split("E6,")[1]);//只记录TBox中AT指令
                bufferedWriter.newLine();
            }

            // 关闭流
            bufferedReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
