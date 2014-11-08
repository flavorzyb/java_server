package com.zhuyanbin.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ServerSocket server = null;
    	try
        {
	        server = new ServerSocket(1111);
	        System.out.println("服务器启动完成... ...");
	        for(;;)
	        {
	        	ServerThread st = new ServerThread(server.accept());
	        	st.start();
	        	System.out.println("接受到一个客户端的链接... ...");
	        }
        }
        catch (IOException e)
        {
	        e.printStackTrace();
        }
    }
}
