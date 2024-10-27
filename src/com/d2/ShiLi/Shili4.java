package com.d2.ShiLi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class Shili4 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //得到DOM解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从DOM工厂获得DOM解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析XML文档,得到一个Document对象,即DOM树
        Document doc = db.parse("src/com/d2/ShiLi/Shili_1.xml");
        //创建Brand节点
        Element brandElement = doc.createElement("Brand");
        brandElement.setAttribute("name","三星");
        //创建 Type 节点
        Element typeElement = doc.createElement("Type");
        typeElement.setAttribute("name","NoteX");
        //添加父子关系
        brandElement.appendChild(typeElement);
        Element phoneElement = (Element) doc.getElementsByTagName("PhoneInfo").item(0);
        phoneElement.appendChild(brandElement);
        //保存XML文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        //设置编码类型
        transformer.setOutputProperty(OutputKeys.ENCODING,"gb2312");
        StreamResult result = new StreamResult(new FileOutputStream("src/com/d2/ShiLi/Shili_1.xml"));
        //把DOM树转换为XML文件
        transformer.transform(domSource,result);
    }
}
