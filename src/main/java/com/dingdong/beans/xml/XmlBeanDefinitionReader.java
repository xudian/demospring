package com.dingdong.beans.xml;

import com.dingdong.BeanReference;
import com.dingdong.beans.*;
import com.dingdong.beans.io.ResourceLoader;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @Title: XmlBeanDefinitionReader
 * @Description:
 * @Author xu
 * @Date 2019/3/20 14:12
 * @Version 1.0
 * @Copyright 2018 All Rights Reserved
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream = getResourceLoader().getResource(location).getInputStream();
        doLoadBeanDefinitions(inputStream);
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        // 解析document
        registerBeanDefinition(document);
        inputStream.close();
    }

    public void registerBeanDefinition(Document doc) {
        Element root = doc.getDocumentElement();

        parseBeanDefinition(root);
    }

    protected void parseBeanDefinition(Element root) {
        NodeList nl = root.getChildNodes();
        if (nl != null && nl.getLength() > 0) {
            for(int i = 0; i < nl.getLength();i++) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element element = (Element) node;
                    processBeanDefinition(element);
                }
            }
        }
    }

    protected  void processBeanDefinition(Element element) {
        String name = element.getAttribute("name");
        String className = element.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(element,beanDefinition);
        beanDefinition.setBeanName(className);
        getRegistry().put(name,beanDefinition);
    }

    private void processProperty(Element element, BeanDefinition beanDefinition) {
        NodeList nodeList = element.getElementsByTagName("property");
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++ ) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;
                    String name = ele.getAttribute("name");
                    String value = ele.getAttribute("value");
                    if (beanDefinition.getPropertyValues() == null) {
                        beanDefinition.setPropertyValues(new PropertyValues());
                    }
                    if (StringUtils.isNotBlank(value)) {
                        beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,value));
                    } else {
                        String ref = ele.getAttribute("ref");
                        if (StringUtils.isNotBlank(ref)) {
                            BeanReference beanReference = new BeanReference(ref);
                            beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name,beanReference));
                        } else {
                            throw new IllegalArgumentException("Configuration problem: <property> element for property '"
                                    + name + "' must specify a ref or value");
                        }
                    }

                }
            }
        }
    }
}
