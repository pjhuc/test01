package main.pjhuc01.test14_dom4j;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 树形结构，直观好理解
 * dom解析会将整个文件读到内存中，如果文件太大，很影响效率
 */
public class DomParse {

    public static void main(String[] args) {
        //E:\IDEA_workspace\test01\src\main\pjhuc01\test14_dom4j\test.xml
        InputStream in = DomParse.class.getClassLoader().getResourceAsStream("main/pjhuc01/test14_dom4j/test.xml");
        //文档对象工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //
        Document doc;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            try {
                //利用文档对象工厂，把流对象变成文档对象
                doc = db.parse(in);
                //
                Element element = doc.getDocumentElement();
                System.out.println("##################################根节点######################################");
                System.out.println(element.getNodeType());
                System.out.println(element.getNodeValue());
                System.out.println(element.getNodeName());
                System.out.println("##################################根节点######################################");
                NodeList nodes = element.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE) {
                        //得到每个节点下的属性
                        NamedNodeMap nodeMap = node.getAttributes();
                        for (int j = 0; j < nodeMap.getLength(); j++) {
                            Node attrNode = nodeMap.item(j);
                            System.out.println(attrNode.getNodeValue());
                            System.out.println(attrNode.getNodeName());
                        }
                        System.out.println(node.getNodeName());
                        //得到子节点
                        // #text 是回车符
                        NodeList node03 = node.getChildNodes();
                        for (int j = 0; j < node03.getLength(); j++) {
                            Node item03 = node03.item(j);
                            if(item03.getNodeType() == Node.ELEMENT_NODE) {
                                System.out.println(item03.getNodeName());
                                System.out.println(item03.getNodeValue());
                                System.out.println(item03.getFirstChild());
                            }
                        }
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
