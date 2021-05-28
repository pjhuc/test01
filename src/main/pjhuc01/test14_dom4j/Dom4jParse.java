package main.pjhuc01.test14_dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * dom4j 把所有的节点对象都看成element节点
 */
public class Dom4jParse {
    public static void main(String[] args) {
        //方法一
        SAXReader ser = new SAXReader();
        try {
            Document document = ser.read(new File("src/main/pjhuc01/test14_dom4j/test.xml"));
            Element rootElement = document.getRootElement();
            System.out.println("root节点Name==="+rootElement.getName());
            Iterator<Element> iterator = rootElement.elementIterator();
            while(iterator.hasNext()) {
                Element user = iterator.next();
                List<Attribute> attributes = user.attributes();
                System.out.println("======获取属性值=====");
                for(Attribute attribute : attributes) {
                    System.out.println(attribute.getValue());
                }
                System.out.println("======遍历子节点======");
                Iterator<Element> iterator1 = user.elementIterator();
                while (iterator1.hasNext()) {
                    Element userChild = iterator1.next();
                    System.out.println("节点名："+userChild.getName()+"---节点值："+userChild.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

/*

    //方法二
    public static void readElement(Element element) {
        if(element.getNodeType() == 1){
            System.out.println(element.getName());
            List<Attribute> atts = element.attributes();
            for(int i = 0;i < atts.size();i++) {
                Attribute a = atts.get(i);
                System.out.println(a.getName()+"-------"+a.getValue());
            }
            //  获取子节点
            List<Element> elements = element.elements();
            for(Element node : elements) {
                if(node.getName().equals("name")) {
                    System.out.println(node.getText());
                }
                if(node.getName().equals("password")) {
                    System.out.println(node.getText());
                }
                //  递归调用
                readElement(node);
            }
        }
    }

    public static void main(String[] args) {
        InputStream   in =  Dom4jParse.class.getClassLoader().getResourceAsStream("main/pjhuc01/test14_dom4j/test.xml");
        SAXReader   sr = new  SAXReader();
        try {
            Document doc = sr.read(in);
            // dom4j  把所有的节点对象 都看成 element 节点
            Element rootElement = doc.getRootElement();
            readElement(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/

}
