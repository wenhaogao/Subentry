package com.handler;

import com.util.Request;
import com.util.Response;

import java.io.IOException;

public abstract class Servlet {
    public void service(Request request, Response response)throws IOException{
        doGet(request,response);
        doPost(request,response);
    }

    public abstract void doGet(Request request, Response response) throws IOException;
    public abstract void doPost(Request request, Response response) throws IOException;
}
