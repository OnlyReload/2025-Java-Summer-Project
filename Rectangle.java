/*
 Rectangle class
 Version 2.1
 Copyright 2004-5 by Mordechai (Moti) Ben-Ari and Michael Kolling and Bruce Quig
(originaly as a square)
 Edited 2010 by Amir Ba-Gaon Kfar-Batia high school
    
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
public class Rectangle {
    private int widthSize;        // The size of a width of the rectangle
    private int heightSize;        // The size of a width of the rectangle
    private int xPosition;   // The x,y coordinates of its top left corner
    private int yPosition;
    private String color;    // The color of the rectangle

    //Create a new rectangle at  the position is its left top co-ordinate
    public Rectangle(int xPosition, int yPosition, int theWidthSize, int theHeightSize, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.widthSize      = theWidthSize;
        this.heightSize      = theHeightSize;
        this.color     = color;
        draw();
    }

    // Move the rectangle to a new position.
    public void moveTo(int newX, int newY) {
		erase();
		 this.xPosition = newX;
		 this.yPosition = newY;
		draw();
    }
    
    // returns the rectangles left top x co-ordinate
    public int  getXposition() 
    {
		return this.xPosition;
    }
    
    // returns the rectangles left top y co-ordinate
    public int  getYposition() 
    {
		return this.yPosition;
    }
    // Move the Rectangle by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
		 this.xPosition =  this.xPosition + deltaX;
		 this.yPosition =  this.yPosition + deltaY;
		draw();
    }

    // Change the color.
    // Valid colors for now are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
		 this.color = newColor;
		draw();
    }

    // Draw the rectangle with current specifications on screen.
    // the awt creates a rectangle with an X center but a Y+size/2 center - just for yuo to know...
    private void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        canvas.fill(new java.awt.Rectangle(this.xPosition, this.yPosition, this.widthSize, this.heightSize));
        canvas.wait(5);
    }

    // Erase the rectangle on screen.
    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.erase(new java.awt.Rectangle(this.xPosition, this.yPosition, this.widthSize, this.heightSize));
    }
}
