/*
    Line class
	Version 2.0
    Copyright 2004-5 by Mordechai (Moti) Ben-Ari
     
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
public class Line {
    private int    xPosition;   // The x,y coordinates of its start
    private int    yPosition;
    private int    xEnd;        // The x,y coordinates of its end
    private int    yEnd;
    private String color;       // The color of the line

    // Create a new line 
    public Line(int xPosition, int yPosition, int xEnd, int yEnd, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xEnd      = xEnd;
        this.yEnd      = yEnd;
        this.color     = color;
        draw();
    }

    // Move the line to a new position.
    public void moveTo(int newX, int newY) {
		erase();
		this.xEnd      = (this.xEnd-this.xPosition) + newX;
		this.yEnd      = (this.yEnd-this.yPosition) + newY;
		this.xPosition = newX;
		this.yPosition = newY;
        draw();
    }

    // Move the line by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
		this.xPosition = this.xPosition + deltaX;
		this.yPosition = this.yPosition + deltaY;
		this.xEnd      = this.xEnd      + deltaX;
		this.yEnd      = this.yEnd      + deltaY;
        draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
		this.color = newColor;
        draw();
    }

    // Draw the line with current specifications on screen.
    public void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        canvas.drawLine(this.xPosition, this.yPosition, this.xEnd, this.yEnd);
        canvas.wait(50);
    }

    // Erase the line on screen.
    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        canvas.eraseLine(this.xPosition, this.yPosition, this.xEnd, this.yEnd);
    }
    
    
	public int getX ( ) {
		return this.xPosition;
	}
	
	public int getY ( ) {
		return this.yPosition;
	}
}
