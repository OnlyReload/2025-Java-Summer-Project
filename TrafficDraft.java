public class TrafficDraft {
	static int holderX, holderY, connectorX, connectorY, bodyX, bodyY, redX, redY, yellowX, yellowY, greenX, greenY, titleX, titleY;
    static Rectangle holder, connector, body;
    static Circle red, yellow, green;
    static Text title;

    public static void main(String[] args) {
        holder = new Rectangle(680, 300, 20, 1000, "black");
        connector = new Rectangle(600, 300, 100, 20, "black");
        body = new Rectangle(550, 200, 100, 252, "gray");
        red = new Circle(600, 242, 30, "red");
        yellow = new Circle(600, 326, 30, "yellow");
        green = new Circle(600, 410, 30, "green");
        title = new Text(550, 190, "Traffic Light", "magenta");
        update();

        moveTo(
                930, 200,    
                850, 200,    
                800, 100,    
                850, 142,                    
                850, 226,    
                850, 310,    
                800, 90      
            );
        move(-500, 100);
        
        copy(400, -100);
        printPosition();
        
        rotate();
        printPosition();
        
        for (int i = 0; i < 5; i++) {
            green.changeColor("gray");
            yellow.changeColor("gray");
            red.changeColor("gray");
            green.changeColor("green");
            yellow.changeColor("yellow");
            red.changeColor("red");
        }
        //rotate();
        scale(0.4);
        scale(2);
        scale(0.5);
        scale(0.4);
        

        
    }
    
    public static void update() {
        holderX = holder.getXposition();
        holderY = holder.getYposition();
        connectorX = connector.getXposition();
        connectorY = connector.getYposition();
        bodyX = body.getXposition();
        bodyY = body.getYposition();
        redX = (int)red.getXposition();
        redY = (int)red.getYposition();
        yellowX = (int)yellow.getXposition();
        yellowY = (int)yellow.getYposition();
        greenX = (int)green.getXposition();
        greenY = (int)green.getYposition();
        titleX = title.gatXposition();
        titleY = title.gatYposition();
    }


    public static void moveTo(int newHolderX, int newHolderY, int newConnectorX, int newConnectorY, int newBodyX, int newBodyY, int newRedX, int newRedY, int newYellowX, int newYellowY, int newGreenX, int newGreenY, int newTitleX, int newTitleY) {
        holder.moveTo(newHolderX, newHolderY);
        connector.moveTo(newConnectorX, newConnectorY);
        body.moveTo(newBodyX, newBodyY);
        red.moveTo(newRedX, newRedY);
        yellow.moveTo(newYellowX, newYellowY);
        green.moveTo(newGreenX, newGreenY);
        title.moveTo(newTitleX, newTitleY);
        update();
    }
    public static void move(int deltaX, int deltaY) {
		holder.move(deltaX, deltaY);
		connector.move(deltaX, deltaY);
		body.move(deltaX, deltaY);
		red.move(deltaX, deltaY);
		yellow.move(deltaX, deltaY);
		green.move(deltaX, deltaY);
		title.move(deltaX, deltaY);
		update();
	}
    public static void copy(int copiedX, int copiedY) {
		Rectangle holder2 = new Rectangle(holder.getXposition() + copiedX, holder.getYposition() + copiedY, 20, 1000, "black");
		Rectangle connector2 = new Rectangle(connector.getXposition() + copiedX, connector.getYposition() + copiedY, 100, 20, "black");
		Rectangle body2 = new Rectangle(body.getXposition() + copiedX, body.getYposition() + copiedY, 100, 252, "gray");
		Circle red2 = new Circle((int)red.getXposition() + copiedX, (int)red.getYposition() + copiedY, 30, "red");
		Circle yellow2 = new Circle((int)yellow.getXposition() + copiedX, (int)yellow.getYposition() + copiedY, 30, "yellow");
		Circle green2 = new Circle((int)green.getXposition() + copiedX, (int)green.getYposition() + copiedY, 30, "green");
		Text title2 = new Text(title.gatXposition() + copiedX, title.gatYposition() + copiedY, "Traffic Light", "magenta");
	}
    
    
    
    public static void eraseTraffic() {
    	holder.erase();
		connector.erase();
		body.erase();
		red.erase();
		yellow.erase();
		green.erase();
		title.erase();
    }
    
    public static void printPosition() {
	    System.out.println("Holder: " + holder.getXposition() + ", " + holder.getYposition());
		System.out.println("Connector: " + connector.getXposition() + ", " + connector.getYposition());
		System.out.println("Body: " + body.getXposition() + ", " + body.getYposition());
		System.out.println("Red: " + red.getXposition() + ", " + red.getYposition());
		System.out.println("Yellow: " + yellow.getXposition() + ", " + yellow.getYposition());
		System.out.println("Green: " + green.getXposition() + ", " + green.getYposition());
		System.out.println("Title: " + title.gatXposition() + ", " + title.gatYposition());
    }
    public static void rotate() {
        eraseTraffic();
    	holder = new Rectangle(holder.getXposition(), 600-holder.getYposition()-1000, 20, 1000, "black");
		connector = new Rectangle(connector.getXposition(), 600-connector.getYposition()-20, 100, 20, "black");
		body = new Rectangle(body.getXposition(), 600-body.getYposition()-252, 100, 252, "gray");
		red = new Circle((int)red.getXposition(), 600-(int)red.getYposition(), 30, "red");
		yellow = new Circle((int)yellow.getXposition(), 600-(int)yellow.getYposition(), 30, "yellow");
		green = new Circle((int)green.getXposition(), 600-(int)green.getYposition(), 30, "green");
		title = new Text(title.gatXposition(), 600-title.gatYposition()+20, "Traffic Light", "magenta");
		update();
    }
    static int scaleX = 50;
    static int scaleY = 126;
    
    public static void scale(double factor) {
        int centerX;
        centerX = body.getXposition() + scaleX;
        int centerY;
		centerY = body.getYposition() + scaleY;
        eraseTraffic();
        
        holder = new Rectangle(
            (int)(centerX + factor * (holderX - centerX)),
            (int)(centerY + factor * (holderY - centerY)),
            (int)(20 * factor),
            (int)(1000 * factor),
            "black"
        );

		connector = new Rectangle(
			(int)(centerX + factor * (connectorX - centerX)),
			(int)(centerY + factor * (connectorY - centerY)),
			(int)(100 * factor),
			(int)(20 * factor),
			"black"
		);

		body = new Rectangle(
			(int)(centerX + factor * (bodyX - centerX)),
			(int)(centerY + factor * (bodyY - centerY)),
			(int)(100 * factor),
			(int)(252 * factor),
			"gray"
		);

		red = new Circle(
			(int)(centerX + factor * (redX - centerX)),
			(int)(centerY + factor * (redY - centerY)),
			(int)(30 * factor),
			"red"
		);

		yellow = new Circle(
			(int)(centerX + factor * (yellowX - centerX)),
			(int)(centerY + factor * (yellowY - centerY)),
			(int)(30 * factor),
			"yellow"
		);

		green = new Circle(
			(int)(centerX + factor * (greenX - centerX)),
			(int)(centerY + factor * (greenY - centerY)),
			(int)(30 * factor),
			"green"
		);

		title = new Text(
			(int)(centerX + factor * (titleX - centerX)),
			(int)(centerY + factor * (titleY - centerY)),
			"Traffic Light",
			"magenta"
		);
        
        scaleX = (int)(scaleX * factor);
		scaleY = (int)(scaleY * factor);
    }

    }