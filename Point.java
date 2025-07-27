
public class Point
{
	private int cordX;
	private int cordY;
	
	private static int counter = 0;
	
	// **************************  בנאים  ************************
	public Point (int cordX, int cordY){
		this.cordX = cordX;
		this.cordY = cordY;
		counter++;
	}
	
	public Point (Point p){		// copy constructor
		this.cordX = p.cordX;
		this.cordY = p.cordY;
		counter++;
	}
	
	public Point ( )
	{
		this (0, 0); // פעולה זו מפעילה את הבנאי שמקבלת שני מספרים 
		counter++;
	}
	
	
	// **************************  Set + Get **********************
	
	public void setX (int cordX){
		this.cordX = cordX;
	}
	
	public void setY (int cordY){
		this.cordY = cordY;
	}
	
	public int getX ( ) {
		return this.cordX;
	}
	
	public int getY ( ) {
		return this.cordY;
	}
	
	public int getCounter ( ) {
		return Point.counter;
	}
	
	// *****************************************************

	public String toString ( ) {
		return ("(" + this.cordX + "," + this.cordY + ")");
	}
	
	
	public void move (int dx, int dy){
		this.cordX += dx;
		this.cordY += dy;
	}
	
	public boolean equals (Point p){
		return ((this.cordX == p.cordX) && (this.cordY == p.cordY));
	}
	
}