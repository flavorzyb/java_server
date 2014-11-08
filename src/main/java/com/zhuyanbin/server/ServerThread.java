/**
 * 
 */
package com.zhuyanbin.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author admin
 *
 */
public class ServerThread extends Thread
{
	private Socket _socket = null;
	
	public ServerThread(Socket sock)
	{
		_socket = sock;
	}
	
	@Override
	public void run()
	{
		try
        {
			while((_socket != null) && (_socket.isClosed() == false))
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
				String str = br.readLine().toLowerCase();
		        System.out.println("client send data:" + str);
		        if (str.equals("closed"))
		        {
		        	_socket.close();
		        }
		        else if (str.equals("sleep")) 
		        {
		        	sleep(6000);
		        	String result ="sleep ok\n";
		        	byte[] data = result.getBytes("UTF-8");
		        	_socket.getOutputStream().write(data);
				}
		        else
		        {
		        	sleep(1000);
		        	String result ="data ok\n";
		        	byte[] data = result.getBytes("UTF-8");
		        	_socket.getOutputStream().write(data);
		        }
			}
        }
        catch (IOException e)
        {
	        e.printStackTrace();
        }
        catch (InterruptedException e)
        {
	        e.printStackTrace();
        }
	}
}
