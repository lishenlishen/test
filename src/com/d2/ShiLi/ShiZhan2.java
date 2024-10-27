package com.d2.ShiLi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class ShiZhan2 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //得到 DOM 解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从 DOM 工厂获得 DOM 解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document 对象,即 DOM 树
        Document doc = db.parse("src/com/d2/ShiLi/Shili_1.xml");


        //添加
        //创建 Brand 节点
        Element brandElement = doc.createElement("Brand");
        brandElement.setAttribute("name","三星");
        //创建 Type 节点
        Element typeElement = doc.createElement("Type");
        typeElement.setAttribute("name","NoteX");

        //添加父子关系
        brandElement.appendChild(typeElement);
        Element phoneElement = (Element) doc.getElementsByTagName("PhoneInfo").item(0);
        phoneElement.appendChild(brandElement);


        //修改
        //找到修改的节点
        NodeList list = doc.getElementsByTagName("Brand");
        for (int i = 0; i < list.getLength(); i ++){
            Element brandElement2 = (Element) list.item(i);
            String brandName = brandElement2.getAttribute("name");
            if (brandElement2.equals("三星")){
                brandElement2.setAttribute("name","SAMSUNG");//修改属性
            }
        }


        //删除
        //找到要删除的节点
        NodeList list2 = doc.getElementsByTagName("Brand");
        for (int i = 0; i < list2.getLength(); i ++){
            Element brandElement3 = (Element) list2.item(i);
            String brandName = brandElement3.getAttribute("name");
            if (brandElement3.equals("SAMSUNG")){
                brandElement3.getParentNode().removeChild(brandElement3);
            }
        }


        //保存 XML 文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        //设置编码类型
        transformer.setOutputProperty(OutputKeys.ENCODING,"gb2312");
        StreamResult result = new StreamResult(new FileOutputStream("src/com/d2/ShiLi/Shili_1.xml"));
        //把DOM树转换为 XML 文件
        transformer.transform(domSource,result);
    }
}
