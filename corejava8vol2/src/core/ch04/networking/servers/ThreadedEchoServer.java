
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch04.networking.servers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ThreadedEchoServer {
    public static void main(String[] args) {
        try(ServerSocket s = new ServerSocket(8190))
        {
            int i = 1;
            while(true)
            {
                Socket incoming = s.accept();
                System.out.println("Spawning: " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
                
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }
}

class ThreadedEchoHandler implements Runnable
{
    private Socket incoming;
    
    public ThreadedEchoHandler(Socket incommingSocket)
    {
        incoming = incommingSocket;
    }
    
    @Override
    public void run()
    {
        try(InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream())
        {
            Scanner in = new Scanner(inStream, "UTF-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
            out.println("Hello Enter BYE to exit");
            boolean done = false;
            while(!done && in.hasNextLine())
            {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if(line.trim().equals("BYE"))
                {
                    done = true;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
