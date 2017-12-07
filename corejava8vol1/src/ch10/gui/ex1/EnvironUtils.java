/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch10.gui.ex1;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.SwingConstants;

/**
 *
 * @author barcvilla
 */
public final class EnvironUtils 
{
    /**
     *  Show in the center of the screen.
     *  (pack, set location and set visibility)
     * 	@param window Window to position
     */
    public static void showCenterScreen(Window window)
    {
        positionCenterScreen(window);
        showWindow(window);
    }   //  showCenterScreen
    
    /**
     * Show window: de-iconify and bring it to front
     * @author teo_sarca [ 1707221 ]
     */
    public static void showWindow(Window window) 
    {
        window.setVisible(true);
        if (window instanceof Frame) 
        {
            Frame f = (Frame)window;
            int state = f.getExtendedState();
            if ((state & Frame.ICONIFIED) > 0)
                    f.setExtendedState(state & ~Frame.ICONIFIED);
        }
        window.toFront();
    }
    
    /**
     *	Position window in center of the screen
     * 	@param window Window to position
     */
    public static void positionCenterScreen(Window window)
    {
        positionScreen(window, SwingConstants.CENTER);
    }	//	positionCenterScreen

    /**
     *	Position window in center of the screen
     * 	@param window Window to position
     * 	@param position SwingConstants
     */
    public static void positionScreen (Window window, int position)
    {
        window.pack();
        // take into account task bar and other adornments
        GraphicsConfiguration config = window.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Dimension sSize = bounds.getSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        sSize.width -= (insets.left + insets.right);
        sSize.height -= (insets.top + insets.bottom);

        Dimension wSize = window.getSize();
        //	fit on window
        if (wSize.height > sSize.height)
                wSize.height = sSize.height;
        if (wSize.width > sSize.width)
                wSize.width = sSize.width;
        window.setSize(wSize);
        //	Center
        int x = (sSize.width - wSize.width) / 2;
        int y = (sSize.height - wSize.height) / 2;
        if (position == SwingConstants.CENTER)
                ;
        else if (position == SwingConstants.NORTH_WEST)
        {
                x = 0;
                y = 0;
        }
        else if (position == SwingConstants.NORTH)
        {
                y = 0;
        }
        else if (position == SwingConstants.NORTH_EAST)
        {
                x = (sSize.width - wSize.width);
                y = 0;
        }
        else if (position == SwingConstants.WEST)
        {
                x = 0;
        }
        else if (position == SwingConstants.EAST)
        {
                x = (sSize.width - wSize.width);
        }
        else if (position == SwingConstants.SOUTH)
        {
                y = (sSize.height - wSize.height);
        }
        else if (position == SwingConstants.SOUTH_WEST)
        {
                x = 0;
                y = (sSize.height - wSize.height);
        }
        else if (position == SwingConstants.SOUTH_EAST)
        {
                x = (sSize.width - wSize.width);
                y = (sSize.height - wSize.height);
        }
        //
        window.setLocation(bounds.x + x + insets.left, bounds.y + y + insets.top);
    }	//	positionScreen

}
