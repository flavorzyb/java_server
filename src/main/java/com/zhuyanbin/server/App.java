package com.zhuyanbin.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class App 
{
	public int _connect_count = 0; 
    public static void main( String[] args )
    {
    	App app = new App();
    	ServerSocket server = null;
    	try
        {
	        server = new ServerSocket(1111);
	        System.out.println("服务器启动完成... ...");
	        for(;;)
	        {
	        	ServerThread st = new ServerThread(server.accept(), app);
	        	app.addConnection();
	        	System.out.println("接受到一个客户端的链接... ...");
	        	app.printConnection();
	        	st.start();
	        }
        }
        catch (IOException e)
        {
	        e.printStackTrace();
        }
    }
    
    public synchronized void addConnection()
    {
    	_connect_count ++;
    }
    
    public synchronized void decrConnection()
    {
    	_connect_count--;
    }
    
    public synchronized void printConnection()
    {
    	System.out.println("当前共有 " + _connect_count + " 个链接");
    }
}
