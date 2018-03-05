package com.load;

import com.handler.Servlet;
import com.util.Request;
import com.util.Response;

import java.io.IOException;
import java.net.Socket;

public class Dispachar implements  Runnable {

    private Socket client;
    private Response response;
    private Request request;

    private  int code = 200;
    public Dispachar(Socket client){
        this.client = client;
        try {
            request = new Request(client.getInputStream());
            response = new Response(client.getOutputStream());
        } catch (IOException e) {
            code = 500;
        }

    }
    @Override
    public void run() {
        try {
            Servlet servlet = WebApp.getServlet(request.getUrl());
            if(servlet==null){
                this.code=404;
            }else{
                servlet.service(request,response);
            }
            response.pushToClient(code);
        } catch (IOException e) {
            try {
                response.pushToClient(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        close();
    }

    private void close(){
        if(client!=null){
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
