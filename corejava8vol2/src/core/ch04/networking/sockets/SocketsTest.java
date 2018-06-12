/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch04.networking.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class SocketsTest 
{
    public static void main(String[] args) throws IOException
    {
        /*abrimos un socket*/
        try(Socket s = new Socket("time-a.nist.gov", 13); 
            Scanner in = new Scanner(s.getInputStream(), "UTF-8"))
        {
            while(in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
