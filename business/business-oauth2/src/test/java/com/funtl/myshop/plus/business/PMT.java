package com.funtl.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PMT {

    /**
     *
     * 计算月供
     *
     * @param rate
     *            年利率 年利率除以12就是月利率
     * @param nper
     *            贷款期数，单位月 该项贷款的付款总数。
     * @param pv
     *            贷款金额,现值，或一系列未来付款的当前值的累积和，也称为本金。
     * @return
     *
     */
    public static double calculatePMT(double rate, double nper, double pv) {
        double v = (1 + (rate / 12));
        double t = (-(nper / 12) * 12);
        double result = (pv * (rate / 12)) / (1 - Math.pow(v, t));
        return result;
    }

    public static void main(String[] args) {
        System.out.println((calculatePMT(0.101, 36, 1) * 36-1)*100*12/36);
    }
}
