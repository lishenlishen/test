package com.d2.ShiLi;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Shili7 {
    public static void main(String[] args) {
        showPhoneInfo();
    }
    public static void showPhoneInfo(){
        Document doc = null;
        try{
            //加载 DOM 树
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(new File("src/com/d2/ShiLi/Shili_1.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //获取 XML 的根节点
        Element root = doc.getRootElement();
        //遍历所有的Brand标签
        for (Iterator itBrand = root.elementIterator();itBrand.hasNext();){
            Element brand = (Element) itBrand.next();
            //输出标签的 name 属性
            System.out.println("品牌: " + brand.attributeValue("name"));
            //遍历Type标签
            for (Iterator itType = brand.elementIterator(); itType.hasNext();){
                Element type = (Element) itType.next();
                //输出标签的name属性
                System.out.println("\t型号: " + type.attributeValue("name"));
            }
        }
    }
}
