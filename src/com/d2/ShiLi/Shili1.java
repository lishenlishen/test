package com.d2.ShiLi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Shili1 {
    public static void main(String[] args) throws Exception {
        //得到DOM解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从DOM工厂获得DOM解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document 对象,即Dao树
        Document doc = db.parse("src/com/d2/ShiLi/Shili_1.xml");//收藏信息.xml为保存手机收藏信息的xml文档
        //得到所有 Brand 节点列表信息
        NodeList brandList = doc.getElementsByTagName("Brand");
        //循环Brand信息
        for (int i = 0; i < brandList.getLength(); i++) {
            if (Node.ELEMENT_NODE == brandList.item(i).getNodeType()) {
                //获取第 i 个Brand 元素信息
                Node brand = brandList.item(i);
                //获取第 i 个Brand 元素的name属性的值
                Element element = (Element) brand;
                String attrValue = element.getAttribute("name");
                //获取第 i 个Brand 元素的所有子元素的name属性值
                NodeList types = element.getChildNodes();
                for (int j = 0; j < types.getLength(); j++) {
                    if (Node.ELEMENT_NODE == types.item(j).getNodeType()) {
                        Element typeElement = ((Element) types.item(j));  //Type节点
                        String type = typeElement.getAttribute("name");//获得手机型号
                        System.out.println("手机: " + attrValue + type);
                    }
                }
            }
        }
    }
}

