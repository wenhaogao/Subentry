package com.load;

import java.util.HashMap;
import java.util.Map;

public class ServletContent {
    private Map<String,String> servlet;
    private Map<String,String> mapping;

    public ServletContent(){
        servlet = new HashMap<String, String>();
        mapping = new HashMap<String, String>();
    }

    public Map<String,String> getServlet(){
        return  servlet;
    }

    public void setSetvlet(Map<String,String> servlet){
        this.servlet = servlet;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, String> mapping) {
        this.mapping = mapping;
    }

}
