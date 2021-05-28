package main.pjhuc01.test14_dom4j;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * 效率高  边解析边加载流文件
 */
public class SaxParse {

    public static void main(String[] args) {
        InputStream in = SaxParse.class.getClassLoader().getResourceAsStream("main/pjhuc01/test14_dom4j/test.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();
            sp.parse(in, new DefaultHandler(){
                @Override
                public void startDocument() throws SAXException {
                    super.startDocument();
                    System.out.println("解析开始。。。");
                }

                @Override
                public void endDocument() throws SAXException {
                    super.endDocument();
                    System.out.println("解析结束");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    super.startElement(uri, localName, qName, attributes);
                    System.out.println("uri=="+uri);
                    System.out.println("localName=="+localName);
                    System.out.println("qName=="+qName);
                    for(int i = 0;i < attributes.getLength();i++) {
                        System.out.println(attributes.getQName(i));
                        System.out.println(attributes.getValue(i));
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    super.endElement(uri, localName, qName);
                }


                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    super.characters(ch, start, length);
                    String value = new String(ch,start,length).trim();
                    if (!value.equals("")) {
                        System.out.println(value);
                    }
                }
            });

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
