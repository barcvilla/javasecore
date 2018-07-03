/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch13.deploying.resource;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author PC
 */
public class ResourceTest 
{
    public static void main(String[] args) 
    {
        EventQueue.invokeLater(() -> 
        {
            JFrame frame = new ResourceTestFrame();
            frame.setTitle("Resource Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ResourceTestFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;
    
    public ResourceTestFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        /*Obtenemos el objeto Class de la clase que tien el recurso ejemplo: ResourceTestFrame.class
          el metodo getResource() obtiene la ubicacion del recurso en un objeto de tipo URL*/
        URL aboutURL = getClass().getResource("info.png");
        /*Leemos el contenido del recursos usando metodos getImage() para imagen o getAudioClip() para audios*/
        Image img = new ImageIcon(aboutURL).getImage();
        setIconImage(img);
        
        JTextArea textArea = new JTextArea();
        /*Para otros recursos distintos a imagen y audio usamos getResourceAsStream()*/
        InputStream stream = getClass().getResourceAsStream("about.txt");
        
        try(Scanner in = new Scanner(stream, "UTF-8"))
        {
            while(in.hasNext())
            {
                textArea.append(in.nextLine() + "\n");
            }
        }
        
        add(textArea);
    }
}
