package com.d2.ShiLi;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Text4 {
    public static void main(String[] args) throws Exception {
        Document doc = null;
        try{
            //加载 DOM 树
            SAXReader saxReader = new SAXReader();
            doc = saxReader.read(new File("src/com/d2/ShiLi/ChangZhang.xml"));

        }catch (Exception e){
            e.printStackTrace();
        }

        //获取 XML 的根节点
        Element root = doc.getRootElement();
        //遍历所有的 student 标签
        for (Iterator itStudent = root.elementIterator(); itStudent.hasNext();){
            Element student = (Element) itStudent.next();
            //输出标签的name属性
//            System.out.println("姓名: " + student.attributeValue("name"));
            //遍历course标签
            for (Iterator itCourse = student.elementIterator();itCourse.hasNext();){
                Element course = (Element) itCourse.next();
                //输出标签的name属性
                if (course.getName().trim().equals("score"))
                System.out.println( course.getText());
            }
        }
    }
}
