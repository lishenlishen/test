package com.d3.dao.ShiZhan;


public class JiSuanFactory {

    public static JiSuan getInstance(String key) {
        switch (key) {
            case "+":
                return new Jia();
            case "-":
                return new Jian();
            case "*":
                return new Cheng();
            case "/":
                return new Chu();
            default:
                throw new RuntimeException("。。。");
        }
    }
}
