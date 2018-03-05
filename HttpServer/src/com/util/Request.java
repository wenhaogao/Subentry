package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

public class Request {
    public static final String CRLF="\r\n";
    //请求方式
    private String method;
    //请求资源
    private String url;
    //请求参数
    private Map<String,List<String>> parameterMapValues;

    private InputStream is;
    private String requestInfo;

    public Request(){
        method="";
        url="";
        parameterMapValues=new HashMap<String, List<String>>();
        requestInfo="";
    }

    public Request(InputStream is) {
        this();
        this.is=is;
        try {
            byte[] data = new byte[20480];
            int len = is.read(data);
            requestInfo= new String(data,0,len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parseRequestInfo();
    }

    public Request(Socket client){
        this();
        try{
            this.is=client.getInputStream();
            byte[] data = new byte[20480];
            int len = is.read(data);
            requestInfo= new String(data,0,len);
        }catch(IOException e){
            return;
        }
        parseRequestInfo();

    }

    private void parseRequestInfo(){
        if(null==requestInfo || (requestInfo=requestInfo.trim()).equals("")){
            return;
        }
        String parseString="";//接受请求参数
        //1.获取请求方式
        String firstLine = requestInfo.substring(0,requestInfo.indexOf(CRLF));
        int idx = requestInfo.indexOf("/");//  /的位置
        this.method = firstLine.substring(0,idx).trim();
        String urlStr = firstLine.substring(idx,firstLine.indexOf("HTTP/")).trim();
        if(this.method.equalsIgnoreCase("post")){
            this.url = urlStr;
            parseString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        }else if(this.method.equalsIgnoreCase("get")){
            if(urlStr.contains("?")){
                String[] urlArray =  urlStr.split("\\?");
                this.url = urlArray[0];
                parseString = urlArray[1];//接受请求参数
            }else{
                this.url=urlStr;
            }
        }
        //将请求封装到Map中
        if(parseString.equals("")){
           return;
        }
        paresParameters(parseString);

    }

    //封装到Map中
    private void paresParameters(String parseString){
        //将字符串转成数据
        StringTokenizer token = new StringTokenizer(parseString,"&");
        while(token.hasMoreTokens()){
            String keyValue=token.nextToken();
            String[] keyValues = keyValue.split("=");
            if(keyValues.length ==1){
                keyValues  = Arrays.copyOf(keyValues,2);
                keyValues[1] = null;
            }
            String key  = keyValues[0].trim();
            String value = (null==keyValues[1]?null:decode(keyValues[1].trim(),"utf-8"));
            //转换成Map分拣
            if(!parameterMapValues.containsKey(key)){
                parameterMapValues.put(key,new ArrayList<String>());
            }
            List<String> values = parameterMapValues.get(key);
            values.add(value);
        }
    }
    public String getParameter(String name){
        String values[] = getParameterValues(name);
        if(values==null) {
            return null;
        }
        else {
            return values[0];
        }
    }

    public String[] getParameterValues(String name){
        List<String> values = null;
        if((values=parameterMapValues.get(name))==null){
            return null;
        }else{
            return values.toArray(new String[0]);
        }
    }

    private  String decode(String value,String code){
        try {
            return URLDecoder.decode(value,code);
        } catch (UnsupportedEncodingException e) {

        }
        return null;

    }
    public String getUrl() {
        return url;
    }

//    public Map getParameterMapValues(){
//        return parameterMapValues;
//    }
//
//    public static void main(String[] args) {
//        String params = "userName=&userPwd=a111&fav=1&fav=2";
//       Request request = new Request();
//       request.paresParameters(params);
//      Set<Map.Entry<String,List<String>>>  set=request.getParameterMapValues().entrySet();
//      Iterator it = set.iterator();
//      while(it.hasNext()){
//          System.out.println(it.next());
//
//      }
//        System.out.println(request.getParameter("userPwd"));
//    }
//    public void test(){
//        Request request = new Request();
//        Set<Map.Entry<String,List<String>>>  set=request.getParameterMapValues().entrySet();
//      Iterator it = set.iterator();
//      while(it.hasNext()){
//          System.out.println(it.next());
//      }
//    }
}
