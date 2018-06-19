/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch04.networking.sockets;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author PC
 */
public class InetAddressTest 
{
    public static void main(String[] args) throws IOException 
    {
        InetAddress address = InetAddress.getByName("google.com");
        System.out.println(address);
    }
}
