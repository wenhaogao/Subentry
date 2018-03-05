package com.handler.impl;

import com.entity.Entity;
import com.entity.Mapping;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class WebHandler extends DefaultHandler {
    private List<Entity> servletList;
    private List<Mapping> mappingList;
    private Entity entity;
    private Mapping mapping;

    private String beginTag;//记录开始标签
    private boolean isMapping;//标记是否是mapping，方便处理

    public List<Entity> getServletList() {
        return servletList;
    }

    public List<Mapping> getMappingList() {
        return mappingList;
    }

    //文档处理开始
    @Override
    public void startDocument() throws SAXException {
        servletList = new ArrayList<Entity>();
        mappingList = new ArrayList<Mapping>();
    }

    //元素处理开始
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName!=null){
            beginTag = qName;
            if(qName.equals("servlet")){
                entity = new Entity();
                isMapping=false;
            }else if(qName.equals("servlet-mapping")){
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    //处理内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(beginTag!=null){
            String str =  new String(ch,start,length);
            if(!isMapping){//不是mapping
                if(beginTag.equals("servlet-name")){
                    entity.setName(str);
                }else if(beginTag.equals("servlet-class")){
                    entity.setClz(str);
                }
            }else{
                if(beginTag.equals("servlet-name")){
                    mapping.setName(str);
                }else if(beginTag.equals("url-pattern")){
                    mapping.getUrlList().add(str);
                }
            }
        }
    }

    //元素处理结束
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName!=null){
            if(qName.equals("servlet")){
                servletList.add(entity);
            }else if(qName.equals("servlet-mapping")){
               mappingList.add(mapping);
            }
        }
        beginTag = null;//结束当前标签
    }


    //文档处理结束
    @Override
    public void endDocument() throws SAXException {
    }

//    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//            //获取解析工厂
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            //获取解析器
//            SAXParser saxParser = factory.newSAXParser();
//            //指定xml+处理器
//            WebHandler handler = new WebHandler();
//            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/ck/server/web.xml"),handler);
//
//
//        List<Entity> listS = handler.getServletList();
//        for(Entity entity:listS){
//            System.out.println(entity);
//        }
//
//        List<Mapping> listM = handler.getMappingList();
//        for(Mapping mapping:listM){
//            System.out.println(mapping);
//        }
//    }
}
