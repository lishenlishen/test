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

public class Shili6 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        //得到 DOM 解析器的工厂实例
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //从 DOM 工厂获得 DOM 解析器
        DocumentBuilder db = dbf.newDocumentBuilder();
        //解析 XML 文档,得到一个 Document 对象,即 DOM 树
        Document doc = db.parse("src/com/d2/ShiLi/Shili_1.xml");

        //找到要删除的节点
        NodeList list = doc.getElementsByTagName("Brand");
        for (int i = 0; i < list.getLength(); i ++){
            Element brandElement = (Element) list.item(i);
            String brandName = brandElement.getAttribute("name");
            if (brandName.equals("SAMSUNG")){
                brandElement.getParentNode().removeChild(brandElement);
            }
        }
        //保存 XML 文件
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(doc);
        //设置编码类型
        transformer.setOutputProperty(OutputKeys.ENCODING,"gb2312");
        StreamResult result = new StreamResult(new FileOutputStream("src/com/d2/ShiLi/Shili_1.xml"));
        //把 DOM 树转换为 XML 文件
        transformer.transform(domSource,result);
    }
}
