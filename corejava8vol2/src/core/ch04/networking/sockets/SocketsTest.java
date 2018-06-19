/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch04.networking.sockets;

import java.io.IOException;
import java.io.InterruptedIOException;
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
        /*abrimos un socket - pasamos la direccion remota y el puerto. Si la conexion falla lanza una excepcion UnKnown
          Si hay otro problema una IOException ocurre*/
        try(Socket s = new Socket("129.6.15.28", 13); 
            Scanner in = new Scanner(s.getInputStream(), "UTF-8"))
        {
            /*Establecemos un tiempo*/
            s.setSoTimeout(10000);
            while(in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
        catch(InterruptedIOException exception)
        {
            exception.printStackTrace();
            System.out.println("Se alcanzo el timeout");
        }
    }
}
