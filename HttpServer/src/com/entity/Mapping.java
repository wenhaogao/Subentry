package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    private String name;
    private List urlList=new ArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getUrlList() {
        return urlList;
    }

    @Override
    public String toString() {
        return "Mapping{" +
                "name='" + name + '\'' +
                ", urlList=" + urlList +
                '}';
    }
}
