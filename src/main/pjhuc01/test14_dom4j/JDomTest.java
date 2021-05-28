package main.pjhuc01.test14_dom4j;

import java.io.*;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * JDom解析xml
 * 快速开发XML应用程序。
 * 是一个开源项目
 * JDOM主要用来弥补DOM和SAX在实际应用当中的不足。
 */
public class JDomTest {

    public static void readElement(Element element,String prefix){
        System.out.println(element.getName());
        System.out.println(prefix);
        List<Attribute> attributes = element.getAttributes();
        for(Attribute attr : attributes) {
            System.out.println(attr.getName()+"--------"+attr.getValue());
        }
        List<Element> childs = element.getChildren();
        for (int i = 0; i < childs.size(); i++) {
            Element child = childs.get(i);
            System.out.println("getName=="+child.getName());
            System.out.println("getText=="+child.getText());
//            System.out.println("getValue=="+child.getValue());
            prefix+="\t";
            readElement(child,prefix);
        }
    }

	public static void read() {
		InputStream   in = JDomTest.class.getClassLoader().getResourceAsStream("main/pjhuc01/test14_dom4j/test.xml");
		SAXBuilder   parse = new SAXBuilder();
        try {
            Document doc = parse.build(in);
            Element rootElement = doc.getRootElement();
            readElement(rootElement,"");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
        read();
	}

}
