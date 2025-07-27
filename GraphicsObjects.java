
public class GraphicsObjects
{

	public static void main(String[] args) 
	{
		int placeX = 100;
		int placeY = 100;
		int size = 40;
		
		Square s1 = new Square(placeX,placeY,size,"red");
		
		for(int i=0 ; i<10 ; i++)
			s1.move(size,size);

		placeX = 400;
		placeY = 200;
		Circle c1 = new Circle(placeX,placeY,size*4,"red");
		Circle c2 = new Circle(placeX,placeY,size*3,"yellow");
		Circle c3 = new Circle(placeX,placeY,size*2,"green");
		Circle c4 = new Circle(placeX,placeY,size,"blue");
		
		Text name = new Text(600,300,"Yod OLE!","magenta");
		
		placeX = 100;
		placeY = 400;
		size = 200;
		
		Triangle t2 = new Triangle(placeX,placeY,size,140,"cyan");
		Triangle t3 = new Triangle(placeX,placeY,size,140,"cyan");
		Triangle t4 = new Triangle(placeX,placeY,size,140,"cyan");
		
		t2.move(size,0);
		t3.move(size*2,0);
		t4.move(size*3,0);
		Triangle t1 = new Triangle(placeX,placeY,size,140,"cyan");	
		
	}

}
