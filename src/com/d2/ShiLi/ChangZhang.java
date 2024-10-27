package com.d2.ShiLi;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class ChangZhang {
    public static DocumentBuilderFactory dbf;
    public static DocumentBuilder db;
    public static Document doc;
    public static void main(String[] args) throws Exception {
//        ShowTest2();
//        ShowTest3_delete();
//        ShowTest3_update();
//        ShowText3_add();
    }


    //简答题3_3
    private static void ShowText3_add() throws Exception {
        //得到 DOM 解析器的工厂实例
        dbf = DocumentBuilderFactory.newInstance();
        //从 DOM 工厂获得 DOM 解析器
        db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document对象,即DOM树
        doc = db.parse("src/com/d2/ShiLi/ChangZhang.xml");

        //添加
        //创建 Student 节点
        Element studentElement = doc.createElement("student");
        studentElement.setAttribute("id","2");
        //创建 name 节点
        Element nameElement = doc.createElement("name");
        nameElement.setTextContent("小明");
        //创建 course 节点
        Element courseElement = doc.createElement("course");
        courseElement.setTextContent("数学");
        //创建 score 节点
        Element scoreElement = doc.createElement("score");
        scoreElement.setTextContent("90");

        //添加父子关系
        studentElement.appendChild(nameElement);
        studentElement.appendChild(courseElement);
        studentElement.appendChild(scoreElement);
        Element element = (Element) doc.getElementsByTagName("scores").item(0);
        element.appendChild(studentElement);


        //调用保存到XML文件方法
        XML();
    }

    //简答题3_2
    private static void ShowTest3_update() throws Exception {
        //得到DOM解析器的工厂实例
        dbf = DocumentBuilderFactory.newInstance();
        //从 DOM 工厂获得 DOM 解析器
        db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document对象,即DOM树
        doc = db.parse("src/com/d2/ShiLi/ChangZhang.xml");

        //修改
        NodeList list = doc.getElementsByTagName("student");
        for (int i = 0; i < list.getLength(); i ++){
            Element studentElement = (Element) list.item(i);
            String name = studentElement.getAttribute("id");
            NodeList list2 = studentElement.getElementsByTagName("score");
            for (int j = 0; j < list2.getLength(); j ++){
                Element element = (Element) list2.item(j);
                if (name.equals("2")){
                    element.setAttribute("name","88");
                    element.setTextContent("88");
                }
            }
        }
        XML();
    }

    //简答题3_1
    private static void ShowTest3_delete() throws Exception {
        //得到 DOM 解析器的工厂实例
        dbf = DocumentBuilderFactory.newInstance();
        //从DOM工厂获得DOM解析器
        db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个Document对象,即DOM树
        doc = db.parse("src/com/d2/ShiLi/ChangZhang.xml");

        //删除
        NodeList list = doc.getElementsByTagName("student");
        for (int i = 0; i < list.getLength(); i ++){
            Element studentElement = (Element) list.item(i);
            String studentName = studentElement.getAttribute("id");
            if (studentName.equals("1")){
                studentElement.getParentNode().removeChild(studentElement);
            }
        }
        //调用保存XML文件方法
        XML();
    }


    //简答题2
    private static void ShowTest2() throws Exception {
        //得到 DOM 解析器的工厂实例
        dbf = DocumentBuilderFactory.newInstance();
        //从 DOM 工厂获得 DOM 解析器
        db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document 对象,即 DOM 树
        doc = db.parse("src/com/d2/ShiLi/ChangZhang.xml");
        //读取 scores 节点
        NodeList list = doc.getElementsByTagName("name");
        // scores 元素节点
        Element name = (Element) list.item(0);
        //读取文本节点
        String nameElement = name.getFirstChild().getNodeValue();
        System.out.println(nameElement);
    }

    //保存XML文件
    private static void XML() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);

        //设置编码类型
        transformer.setOutputProperty(OutputKeys.ENCODING,"gb2312");
        StreamResult result = new StreamResult(new FileOutputStream("src/com/d2/ShiLi/ChangZhang.xml"));

        //把 DOM 树转换为 XML 文件
        transformer.transform(domSource,result);
    }
}
