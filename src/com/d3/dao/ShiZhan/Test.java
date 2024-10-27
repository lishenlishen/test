package com.d3.dao.ShiZhan;

import javax.xml.transform.stream.StreamResult;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("第一");
            double num1 = input.nextDouble();
            System.out.println("第二");
            double num2 = input.nextDouble();
            System.out.print("运算符--->");
            String choose = input.next();

            JiSuan jiSuan = JiSuanFactory.getInstance(choose);
            System.out.println(jiSuan.JiSuan(num1, num2));
            System.out.println("是否继续 (y / n)");
            if (input.next().equals("n")){
                return;
            }
        } while (true);
    }
}
