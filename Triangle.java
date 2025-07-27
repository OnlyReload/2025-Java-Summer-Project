/*
    Triangle class
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
public class Triangle {

    private int width;       // The width of the triangle
    private int height;      // The height of the triangle
    private int xPosition;   // The x,y coordinates of its top vertex
    private int yPosition;
    private String color;    // The color of the triangle

    // Create a new triangle
    public Triangle(int xPosition, int yPosition, int width, int height, String color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width     = width;
        this.height    = height;
        this.color     = color;
        draw();
    }

    // Move the triangle to a new position.
    public void moveTo(int newX, int newY) {
		erase();
		this.xPosition = newX;
		this.yPosition = newY;
		draw();
    }

    // Move the triangle by an amount.
    public void move(int deltaX, int deltaY) {
		erase();
		this.xPosition = this.xPosition + deltaX;
		this.yPosition = this.yPosition + deltaY;
		draw();
    }

    // Change the size to the new size.
    public void changeSize(int newWidth, int newHeight) {
		erase();
		this.width  = newWidth;
		this.height = newHeight;
		draw();
    }

    // Change the color.
    // Valid colors are "red","yellow","blue","green","magenta" and "black".
    public void changeColor(String newColor) {
		erase();
		this.color = newColor;
		draw();
    }

    // Draw the triangle with current specifications on screen.
    private void draw() {
        Canvas canvas = Canvas.getCanvas();
        canvas.setForegroundColour(this.color);
        int[] xpoints =
            { this.xPosition, this.xPosition + (this.width/2), this.xPosition - (this.width/2) };
        int[] ypoints =
            { this.yPosition, this.yPosition + this.height, this.yPosition + this.height };
        canvas.fill(new java.awt.Polygon(xpoints, ypoints, 3));
        canvas.wait(50);
    }

    // Erase the triangle on screen.
    public void erase() {
        Canvas canvas = Canvas.getCanvas();
        int[] xpoints =
            { this.xPosition, this.xPosition + (this.width/2), this.xPosition - (this.width/2) };
        int[] ypoints =
            { this.yPosition, this.yPosition + this.height, this.yPosition + this.height };
        canvas.erase(new java.awt.Polygon(xpoints, ypoints, 3));
    }
}
