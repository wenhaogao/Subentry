package com.handler.impl;

import com.handler.Servlet;
import com.util.Request;
import com.util.Response;

import java.io.IOException;

public class LoginServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        //响应
        response.println("<html><head><title>登录</title>");
        response.println("</head><body>");
        if(request.getParameter("userName").equals("admin") && request.getParameter("userPwd").equals("a111")){
          response.println("登录成功！");
        }else{
            response.println("登录失败！");
        }
//        response.println("欢迎:").println(request.getParameter("userName")).println("回来!");
        response.println("</body></html>");
        response.pushToClient(200);
    }
}
