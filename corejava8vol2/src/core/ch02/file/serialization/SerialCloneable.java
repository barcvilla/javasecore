/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch02.file.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class SerialCloneable implements Cloneable, Serializable
{
    public Object clone() throws CloneNotSupportedException
    {
        try
        {
            /*guardamos el objeto en un array byte*/
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try(ObjectOutputStream out = new ObjectOutputStream(bout))
            {
                out.writeObject(this);
            }
            
            /*leemos el objeto clonado de un array byte*/
            try(InputStream bin = new ByteArrayInputStream(bout.toByteArray()))
            {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        }
        catch(IOException | ClassNotFoundException e )
        {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
        
    }
}
