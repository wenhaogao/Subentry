package com.hellojava.database.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configuraction {
	private static Properties properties;
	private static String configFilePath="/db.properties";
	private static Logger log=Logger.getLogger(Configuraction.class);
	
	public static void setConfigFilePath(String configFilePath) {
		Configuraction.configFilePath = configFilePath;
	}
	
	static {
		InputStream inStream=Configuraction.class.getResourceAsStream(configFilePath);
		if(inStream!=null) {
			properties=new Properties();
			try {
				properties.load(inStream);
			} catch (IOException e) {
				log.debug("数据库配置文件没有找到");
			}
		}
	}
	
	public static void rebuilderProperties() throws Exception{
		InputStream inStream=Configuraction.class.getResourceAsStream(configFilePath);
		if(inStream!=null) {
			properties=new Properties();
			try {
				properties.load(inStream);
			} catch (IOException e) {
				log.debug(e.getMessage());
			}
		}else {
			throw new Exception("数据库配置找不到");
		}
	}
	
	public static String getProperty(String key) {
		if(properties==null) {
			try {
				rebuilderProperties();
			}catch(Exception e) {
				log.debug(e.getMessage());
			}
		}
		
		return properties.getProperty(key);
	}
}
