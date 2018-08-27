/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.write;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ReadData {

    public static void readInt(InputStreamReader ir) throws IOException {
        StringBuffer str = new StringBuffer();
        int c = ir.read();
        while (c != -1) {
            str.append(Character.toString((char) c));
            
            c = ir.read();
            
        }
        System.out.println(str.toString());
    }

    public static void obtnerArchivo() {
        try {
            InputStreamReader ois = new InputStreamReader(new BufferedInputStream(new FileInputStream("lista.txt")));
            readInt(ois);
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        obtnerArchivo();
    }
}
