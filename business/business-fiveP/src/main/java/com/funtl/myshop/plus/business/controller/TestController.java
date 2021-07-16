package com.funtl.myshop.plus.business.controller;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestController {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(22);
                add(22);
                add(23);
                add(159);
                add(12);
            }
        };
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(p -> p,Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println(map);

        List<Integer> list1 = new ArrayList() {
            {
                add(12);
                add(20);
                add(129);
                add(23);
                add(159);
                add(120);
            }
        };
        List<Integer> list2 = new ArrayList() {
            {
                add(112);
                add(20);
                add(129);
                add(213);
                add(59);
                add(120);
            }
        };
        list1.retainAll(list2);//交集
        list2.addAll(list1);//并集
        System.out.println("交集是"+list1);
        System.out.println("并集是"+list2);
    }
}
