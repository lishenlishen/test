package com.d2.ShiLi;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.NodeList;

import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Iterator;
import java.util.List;

public class ShiZhan3 {
    public static void main(String[] args) throws Exception {
//        ShowShiZhan1();//实战1
        ShiZhan3();
    }
    public static void ShowShiZhan1() throws Exception {
        Document doc = null;
        try {
            //加载 Dom 树
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(new File("src/com/d2/ShiLi/Shili_1.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }

        //获取 XML 的根节点
        Element root = doc.getRootElement();
        //添加属性
        //创建一个Brand节点
        Element brand = root.addElement("Brand");
        //给Brand设置属性
        brand.addAttribute("name","三星");
        //创建Type节点
        Element typeEle = brand.addElement("Type");
        //给Type添加属性
        typeEle.addAttribute("name","NoteX");

        OutputFormat format = OutputFormat.createPrettyPrint();//设置格式化
        format.setEncoding("GBK");//制定XML编码
        XMLWriter writer = new XMLWriter(new FileWriter("src/com/d2/ShiLi/Shili_1.xml"));
        writer.write(doc);//写入数据
        writer.close();//清空

//        for (Iterator it = root.attributeIterator();it.hasNext();){
//            Attribute attribute = (Attribute) it.next();
//            String text = attribute.getText();
//            System.out.println(text);
//        }
        for (Iterator iterator = root.elementIterator();iterator.hasNext();){
            Element brand2 = (Element) iterator.next();
            //输出标签的name属性
            System.out.println(brand2.attributeValue("name"));
            //遍历Type标签
            for (Iterator itType = brand2.elementIterator();itType.hasNext();){
                Element type = (Element) itType.next();
                //输出标签的name属性
                System.out.println(type.attributeValue("name"));
            }
        }
    }
    public static void ShiZhan3() throws Exception {

        //删除
//        SAXReader saxReader=new SAXReader();
//        Document doc=null;
//        try {
//            doc=saxReader.read(new File("src/com/d2/ShiLi/Shili_1.xml"));
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        Element root=doc.getRootElement();
//        List elbarnd=root.elements("Brand");
//        for (Iterator iterator=elbarnd.iterator();iterator.hasNext();){
//            Element element= (Element) iterator.next();
//            if (element.attributeValue("name").equals("三星")){
//                root.remove(element);
//            }
//        }
//        OutputFormat format = OutputFormat.createPrettyPrint();//设置格式化
//        format.setEncoding("GBK");//制定XML编码
//        XMLWriter writer = new XMLWriter(new FileWriter("src/com/d2/ShiLi/Shili_1.xml"));
//        writer.write(doc);//写入数据
//        writer.close();//清空


        //添加
        Document doc = null;
        SAXReader saxReader ;
        try {
            // 加载 DOM 树
            saxReader = new SAXReader();
            doc = saxReader.read(new File("src/com/d2/ShiLi/Shili_1.xml"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //获取 XML 的根节点
        Element root = doc.getRootElement();
        //创建一个子节点
//        Element Brand = root.addElement("Brand");
//        //为该节点添加属性
//        Brand.addAttribute("name","learningdom4j");
//        //创建Type节点
//        Element Type = root.addElement("Type");
//        //为该节点添加属性
//        Type.addAttribute("name","213");
//
//
//        //删除
        List del = root.elements("Brand");
//        for (Iterator it = del.iterator();it.hasNext();){
//            Element element = (Element) it.next();
//            if (element.attributeValue("name").equals("213")){
//                root.remove(element);
//            }
//        }

        //修改
        for (Iterator it = root.elementIterator();it.hasNext();){
            Element element = (Element) it.next();
            String name = element.attributeValue("name");
            if (name.equals("123")){
                element.addAttribute("name","qq");
            }
        }


        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("GBK");
        XMLWriter writer = new XMLWriter(new FileWriter("src/com/d2/ShiLi/Shili_1.xml"));
        writer.write(doc);
        writer.close();
    }
}
