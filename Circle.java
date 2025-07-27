/*
    Circle class
	Version 2.0
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari and Michael Kolling.
     
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
public class Circle {
    private double radius;               // Radius of the circle
    private double xCenter, yCenter;     // The x,y coordinates of the center  
    private String color;    		  // The color of the circle

    // Create a new circle 
    public Circle(int xCenter, int yCenter, int radius, String color) {
        this.radius  = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.color     = color;
        draw();
    }

	// Move the circle to a new position.
    public void moveTo(int newX, int newY) {
		erase();
		this.xCenter = newX;
		this.yCenter = newY;
		draw();
    }

    // Move the circle by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
		this.xCenter = this.xCenter + deltaX;
		this.yCenter = this.yCenter + deltaY;
		draw();
    }
    public double getXposition() 
    {
		return this.xCenter;
    }
    
    // returns the rectangles left top y co-ordinate
    public double getYposition() 
    {
		return this.yCenter;
    }

    // Change the size to the new size.
    public void changeSize(int newRadius) {
		erase();
		this.radius = newRadius;
		draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
		this.color = newColor;
		draw();
    }

    // Draw the circle with current specifications on screen.
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        canvas.fill(new java.awt.geom.Ellipse2D.Double(
        		this.xCenter - this.radius, this.yCenter - this.radius, 2*this.radius, 2*this.radius));
        canvas.wait(50);
    }

    // Erase the circle on screen.
    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new java.awt.geom.Ellipse2D.Double(
        		this.xCenter - this.radius, this.yCenter - this.radius, 2*this.radius, 2*this.radius));
    }
}
