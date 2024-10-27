package com.d2.ShiLi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Shili2 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //得到 Dom 解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从DOM工厂获得DOM解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析XML文档,得到一个Document对象,即DOM树
        Document doc = db.parse("src/com/d2/ShiLi/Shili_2.xml");
        //读取 pubDate
        NodeList list = doc.getElementsByTagName("pudDate");
        //pubDate元素节点
        Element pubDateElement = (Element) list.item(0);
        //读取文本节点
        String pubDate = pubDateElement.getFirstChild().getNodeValue();
        System.out.println(pubDate);
    }
}
