package com.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
    public static final String CRLF="\r\n";
    public static final String BLACK=" ";

    //存储头信息
    private StringBuilder headerInfo;
    //存储正文长度
    private int len = 0;
    //正文
    private StringBuilder content;
    //流
    private BufferedWriter bufferedWriter;

    public Response(){
        headerInfo = new StringBuilder();
        content = new StringBuilder();
        len=0;
    }
    public Response(OutputStream os){
        this();
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
    }
    public Response(Socket client) {
        this();
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
           headerInfo=null;
        }
    }
    /**
     * 构建响应头
     */
    private void createHeadInfo(int code){
        headerInfo.append("HTTP/1.1").append(BLACK).append(code).append(BLACK);
        switch (code){
            case 200:
                headerInfo.append("OK");
                break;
            case 404:
                headerInfo.append("Not Found");
                break;
            case 500:
                headerInfo.append("Server Error");
                break;
            default:
                    break;
        }
        headerInfo.append(CRLF);
        headerInfo.append("Server:CK&HTTP Server/0.0.1").append(CRLF);
        headerInfo.append("Date:").append(new Date()).append(CRLF);
        headerInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        headerInfo.append("Content-Length:").append(len).append(CRLF);
        headerInfo.append(CRLF);
    }

    /**
     * 构建正文
     */
    public Response print(String info){
        content.append(info);
        len+=info.getBytes().length;
        return this;
    }

    public Response println(String info){
        content.append(info).append(CRLF);
        len+=(info+CRLF).getBytes().length;
        return this;
    }
    public void pushToClient(int code) throws IOException {
        if(headerInfo==null) {
            code = 500;
        }
        createHeadInfo(code);
        bufferedWriter.append(headerInfo.toString());
        bufferedWriter.append(content.toString());
        bufferedWriter.flush();
    }
    public void close() throws IOException {
        if(bufferedWriter!=null){
            bufferedWriter.close();
        }
    }
}
