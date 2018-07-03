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
public class EchoServer 
{
    public static void main(String[] args) throws IOException {
        /*Establecemos Server Socket*/
        try(ServerSocket s = new ServerSocket(8190)) /*el serversocket monitorea el puerto 8190*/
        {
            /*esperamos indefinidamente hasta que el cliente se conecte al puerto 8190. Una vez el cliente conectado
              y enviando el request correcto por la red, el metodo accept() retorna un objeto Socket que representa una conexion
              ha sido hecha.*/
            try(Socket incoming = s.accept())
            {
                /*Con el objeto incoming de tipo Socket podemos establecer InputStream u OutputStream*/
                /*Todo lo que ServerSocket envia */
                InputStream inStream = incoming.getInputStream(); /*Entrada para el servidor*/
                OutputStream outStream = incoming.getOutputStream(); /*Salida para el cliente*/
                
                /*Transmitimos el texto por el Socket. Convertimos los Streams en Scanners y Writers*/
                try(Scanner in = new Scanner(inStream, "UTF-8"))
                {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true /*autoFlush*/);
                    out.println("Hello! ENTER BYE to exit"); /*Enviamos al cliente un saludo    */
                    
                    /*echo client input*/
                    boolean done = false;
                    while(!done && in.hasNextLine())
                    {
                        /*Leemos el input del cliente, una linea a la vez e impreso.Lo cual demuestra que el programa recibe el input. Luego
                          el server hace su procesamiento y retorna una accion dependiendo del input*/
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE"))
                        {
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
