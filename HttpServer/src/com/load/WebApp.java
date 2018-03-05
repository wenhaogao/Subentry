package com.load;

import com.entity.Entity;
import com.entity.Mapping;
import com.handler.Servlet;
import com.handler.impl.WebHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WebApp {
    private static ServletContent servletContent;
    static{
        try {
            //获取解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //获取解析器
            SAXParser saxParser = factory.newSAXParser();
            //指定xml+处理器
            WebHandler handler = new WebHandler();
            saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"),handler);
            //servlet的上下文
            servletContent = new ServletContent();

            //将解析的servlet和mapping存入上下文
            Map<String,String> servletMap=servletContent.getServlet();
            for(Entity entity:handler.getServletList()){
                servletMap.put(entity.getName(),entity.getClz());
            }
            Map<String,String > mappingMap=servletContent.getMapping();
            for(Mapping mapping:handler.getMappingList()){
                List<String> urls = mapping.getUrlList();
                for(String url:urls){
                    mappingMap.put(url,mapping.getName());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static Servlet getServlet(String url) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if((null==url)|| (url=url.trim()).equals("")){
            return null;
        }

        String name = servletContent.getMapping().get(url);
        String clz = servletContent.getServlet().get(name);
        Servlet servlet = null;
        if(name!=null && clz!=null)
           servlet = (Servlet) Class.forName(clz).newInstance();
        return servlet;
    }
}
