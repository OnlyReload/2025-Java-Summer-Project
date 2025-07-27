/*
    Canvas class
	Version 2.0
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari and Michael Kolling and Bruce Quig
     
    This program is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public License
    as published by the Free Software Foundation; either version 2
    of the License, or (at your option) any later version.
    This program is distributed in the hope that it will be useful
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
    02111-1307, USA.
*/
import javax.swing.*;
import java.awt.*;
public class Canvas {
    private static int width = 1000;
    private static int height = 600;
    private static Canvas canvasSingleton;
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;

	// Create canvas singleton object.
	static Canvas getCanvas() {
		if(canvasSingleton == null)
			canvasSingleton = 
				new Canvas("Ofek's traffic light", 
					width, height, Color.white);
		canvasSingleton.setVisible(true);
		return canvasSingleton;
	}

    public static void changeSize(int w, int h) {
        width = w;
        height = h;
        getCanvas().canvas.setPreferredSize(new Dimension(width, height));
    }
    
    public static void changeLocation(int x, int y) {
        getCanvas().frame.setLocation(x, y);
    }
    
    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background colour of the canvas
     */
    Canvas(String title, int width, int height, Color bgColour) {
        this.backgroundColour = bgColour;
        this.canvas = new CanvasPane();
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.frame = new JFrame();
        this.frame.setContentPane(this.canvas);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setTitle(title);
        this.frame.setSize(width, height);
        this.frame.setLocationRelativeTo(null); 
        this.frame.pack();
        this.frame.toFront();
    }

    /**
     * Sets the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    private void setVisible(boolean visible) {
        if(this.graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background colour
            Dimension size = this.canvas.getSize();
            this.canvasImage = this.canvas.createImage(size.width, size.height);
            this.graphic = (Graphics2D)this.canvasImage.getGraphics();
            this.graphic.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
            this.graphic.setColor(this.backgroundColour);
            this.graphic.fillRect(0, 0, size.width, size.height);
            this.graphic.setColor(Color.black);
        }
        this.frame.setVisible(visible);
    }

	/**
     * Fills the internal dimensions of a given shape with the current 
     * foreground colour of the canvas.
     * @param  shape  the shape object to be filled 
     */
    void fill(Shape shape) {
    	this.graphic.fill(shape);
    	this.canvas.repaint();
    }

    /**
     * Erases a given shape's interior on the screen.
     * @param  shape  the shape object to be erased 
     */
    void erase(Shape shape) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.fill(shape);              // erase by filling background colour
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    void drawString(String text, int x, int y) {
    	this.graphic.drawString(text, x, y);   
    	this.canvas.repaint();
    }

    /**
     * Erases a String on the Canvas.
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    void eraseString(String text, int x, int y) {
        Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.drawString(text, x, y);   
        this.graphic.setColor(original);
        this.canvas.repaint();
    }

    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    void drawLine(int x1, int y1, int x2, int y2) {
    	this.graphic.drawLine(x1, y1, x2, y2);   
    	this.canvas.repaint();
    }

    /**
     * Erases a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    void eraseLine(int x1, int y1, int x2, int y2) {
        //Color original = this.graphic.getColor();
        this.graphic.setColor(this.backgroundColour);
        this.graphic.drawLine(x1, y1, x2, y2);   
        this.canvas.repaint();
	}

    /**
     * Sets the foreground colour of the Canvas.
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    void setForegroundColour(String colour) {
		String c = colour.toLowerCase();
		if(c.equals("red"))
			this.graphic.setColor(Color.red);
		else if(c.equals("black"))
			this.graphic.setColor(Color.black);
		else if(c.equals("blue"))
			this.graphic.setColor(Color.blue);
		else if(c.equals("yellow"))
			this.graphic.setColor(Color.yellow);
		else if(c.equals("green"))
			this.graphic.setColor(Color.green);
		else if(c.equals("magenta"))
			this.graphic.setColor(Color.magenta);
		else if(c.equals("white"))
			this.graphic.setColor(Color.white);
		else if(c.equals("gray"))
			this.graphic.setColor(Color.gray);
		else
			this.graphic.setColor(Color.black);
    }

    void wait(int milliseconds) {
        try { Thread.sleep(milliseconds); } 
        catch (Exception e) { }
    }

    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(Canvas.this.canvasImage, 0, 0, null);
        }
    }
}
