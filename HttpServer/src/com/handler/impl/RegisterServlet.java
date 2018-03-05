package com.handler.impl;

import com.handler.Servlet;
import com.util.Request;
import com.util.Response;

import java.io.IOException;

public class RegisterServlet extends Servlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        response.println("<html><head><title>返回注册</title>");
        response.println("</head><body>");
        response.println("你的用户名为：").println(request.getParameter("userName"));
        response.println("</body></html>");
        response.pushToClient(200);
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        this.doGet(request,response);
    }
}
