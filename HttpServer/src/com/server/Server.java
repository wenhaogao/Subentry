package com.server;


import com.load.Dispachar;

import java.io.IOException;
import java.net.ServerSocket;


public class Server {
    private ServerSocket server;
    private volatile  boolean isShutDown = false;

    //默认启动8888端口
    public void start(){
        start(8888);
    }

    //启动指定端口
    public void start(int port){
        try {
            server= new ServerSocket(port);
            this.receive();//启动时接受信息
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void receive(){
        try {
            while(!isShutDown) {
                new Thread(new Dispachar(server.accept())).run();
            }
        } catch (IOException e) {
            stop();
        }
    }


    public void stop(){
        isShutDown = true;
        if(server!=null) {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
