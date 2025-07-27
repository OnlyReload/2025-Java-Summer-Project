// עבודת קיץ 2025 תיכון שמעון בן צבי מגמת מחשבים
// משימה ראשונה
// תוכנת על ידי אופק רוזנטל
// הפרויקט מציג בנייה של רמזור בעזרת גרפיקה דו מימדית, והפרוקיט בנוי על מנת לתת חופש לבצע כל פעולה מספר פעמים.

public class TrafficMain2 {
    static Rectangle holder, connector, body, loading;
    static Circle red, yellow, green;
    static Text title, message1;
    static Boolean animate = false;
    static int holderX, holderY, connectorX, connectorY, bodyX, bodyY, redX, redY, yellowX, yellowY, greenX, greenY, titleX, titleY;

    public static void main(String[] args) {

        Generate(1, false); //מספר ראשון מציג גדול (לא עובד עם מובטו, תא שני מייצג האם להפעיל הנפשות

        moveTo( // מזיז את הרמזור למיקום קבוע
            930, 200,
            850, 200,
            800, 100,
            850, 142,
            850, 226,
            850, 310,
            800, 90
        );
        
        int dx = -500; int dy = 100; 
        move(dx, dy); // מזיז את הרמזור למיקום יחסי

        copy(400, -100); // מעתיק את הרמזור למיקום יחסי
        
        rotate(270); // מסובב את הרמזור. ניתן לבחור ב-90, 180 או 270 מעלות.
        rotate(90);
        printPosition(); // מדפיס את המיקום של הצורות ברמזור
        scale(0.4); // משנה את גודל הרמזור
        scale(5);
    }
    
    
    
    static int holderW = 20, holderH = 1000, connectorW = 100, connectorH = 20, bodyW = 100, bodyH = 252;
	static int redR = 30, yellowR = 30, greenR = 30;
	static String holderC = "black", connectorC = "black", bodyC = "gray", redC = "red", yellowC = "yellow", greenC = "green", titleC = "magenta";

    public static void Generate(double scale, boolean useAnimation) {
        animate = useAnimation;

        holder = new Rectangle(680, 300, holderW, holderH, holderC);
        connector = new Rectangle(600, 300, connectorW, connectorH, connectorC);
        body = new Rectangle(550, 200, bodyW, bodyH, bodyC);
        red = new Circle(600, 242, redR, redC);
        yellow = new Circle(600, 326, yellowR, yellowC);
        green = new Circle(600, 410, greenR, greenC);
        title = new Text(550, 190, "Traffic Light", titleC);
        update();
        if (scale !=1)scale(scale);
    }

    public static void startAnimation(String message) {
        message1 = new Text(80, 270, message, "BLACK");
        loading = new Rectangle(60, 300, 10, 10, "red");
        for (int i = 0; i < 25; i++) {
            loading.erase();
            loading = new Rectangle(10, 300, 10 + i * 10, 10, "red");
            try { Thread.sleep(60); } catch (InterruptedException e) {}
        }
        try { Thread.sleep(300); } catch (InterruptedException e) {}
        message1.erase();
        loading.erase();
    }
    public static void endAnimation(String message) {
        message1 = new Text(80, 270, message, "red");
        for (int i = 0; i < 5; i++) {
            green.changeColor("gray");
            yellow.changeColor("gray");
            red.changeColor("gray");
            green.changeColor("green");
            yellow.changeColor("yellow");
            red.changeColor("red");
        }
        message1.erase();
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
        if(animate) startAnimation("Moving Traffic Light");
        holder.moveTo(newHolderX, newHolderY);
        connector.moveTo(newConnectorX, newConnectorY);
        body.moveTo(newBodyX, newBodyY);
        red.moveTo(newRedX, newRedY);
        yellow.moveTo(newYellowX, newYellowY);
        green.moveTo(newGreenX, newGreenY);
        title.moveTo(newTitleX, newTitleY);
        update();
        if(animate) endAnimation("Traffic Light Moved");
    }

    public static void move(int deltaX, int deltaY) {
        if(animate) startAnimation("Moving Traffic Light (relative)");
        holder.move(deltaX, deltaY);
        connector.move(deltaX, deltaY);
        body.move(deltaX, deltaY);
        red.move(deltaX, deltaY);
        yellow.move(deltaX, deltaY);
        green.move(deltaX, deltaY);
        title.move(deltaX, deltaY);
        update();
        if(animate) endAnimation("Traffic Light Moved (relative)");
    }

    public static void copy(int copiedX, int copiedY) {
        if(animate) startAnimation("Copying Traffic Light");
        Rectangle holder2 = new Rectangle(holder.getXposition() + copiedX, holder.getYposition() + copiedY, 20, 1000, "black");
        Rectangle connector2 = new Rectangle(connector.getXposition() + copiedX, connector.getYposition() + copiedY, 100, 20, "black");
        Rectangle body2 = new Rectangle(body.getXposition() + copiedX, body.getYposition() + copiedY, 100, 252, "gray");
        Circle red2 = new Circle((int)red.getXposition() + copiedX, (int)red.getYposition() + copiedY, 30, "red");
        Circle yellow2 = new Circle((int)yellow.getXposition() + copiedX, (int)yellow.getYposition() + copiedY, 30, "yellow");
        Circle green2 = new Circle((int)green.getXposition() + copiedX, (int)green.getYposition() + copiedY, 30, "green");
        Text title2 = new Text(title.gatXposition() + copiedX, title.gatYposition() + copiedY, "Traffic Light", "magenta");
        if(animate) endAnimation("Traffic Light Copied");
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
    
    
    public static Rectangle rotateRectangle90(Rectangle rectangle, int x, int y, int w, int h, String c) {
    	int cx = body.getXposition() + bodyW/2;
        int cy = body.getYposition() + bodyH/2;
    	int ocx = x + w/2;
		int ocy = y + h/2;
		int ncx = cx - (ocy - cy), newCy = cy + (ocx - cx);
		int nw = h, nh = w;
        int nx = ncx - nw/2, ny = newCy - nh/2;
        //holderW = nw; holderH = nh; connectorW = nw; connectorH = nh; bodyW = nw; bodyH = nh;
        return new Rectangle(nx, ny, nw, nh, c);
    }
    public static Circle rotateCircle90(Circle circle, int x, int y, String c) {
    	int cx = body.getXposition() + bodyW/2;
        int cy = body.getYposition() + bodyH/2;
    	int oldX = x;
        int oldY = y;
        int radius = redR;
        int newX = cx - (oldY - cy);
        int newY = cy - (oldX - cx);
        return new Circle(newX, newY, redR, c);
    }
    public static Text rotateText90(Text text, int x, int y) {
    	int cx = body.getXposition() + bodyW/2;
        int cy = body.getYposition() + bodyH/2;
    	int nx = cx - (titleY - cy), ny = cy + (titleX - cx);
        return new Text(nx, ny, "Traffic Light", titleC);
	}

    public static void rotate(int degrees) {
    	int cx = body.getXposition() + bodyW/2;
        int cy = body.getYposition() + bodyH/2;
    	cx = body.getXposition() + bodyW/2; cy = body.getYposition() + bodyH/2;
        if(animate) startAnimation("Rotating Traffic Light");
        eraseTraffic();
        
        
        
        if (degrees == 180) {
        holder = new Rectangle(holder.getXposition(), 600-holder.getYposition()-1000, 20, 1000, "black");
        connector = new Rectangle(connector.getXposition(), 600-connector.getYposition()-20, 100, 20, "black");
        body = new Rectangle(body.getXposition(), 600-body.getYposition()-252, 100, 252, "gray");
        red = new Circle((int)red.getXposition(), 600-(int)red.getYposition(), 30, "red");
        yellow = new Circle((int)yellow.getXposition(), 600-(int)yellow.getYposition(), 30, "yellow");
        green = new Circle((int)green.getXposition(), 600-(int)green.getYposition(), 30, "green");
        title = new Text(title.gatXposition(), 600-title.gatYposition()+20, "Traffic Light", "magenta");
        }
        
	        
        
        else if (degrees == 90) {
        	holder = rotateRectangle90(holder, holderX, holderY, holderW, holderH, holderC);
			connector = rotateRectangle90(connector, connectorX, connectorY, connectorW, connectorH, connectorC);
			body = rotateRectangle90(body, bodyX, bodyY, bodyW, bodyH, bodyC);
            red = rotateCircle90(red, redX, redY, redC);
			yellow = rotateCircle90(yellow, yellowX, yellowY, yellowC);
			green = rotateCircle90(green, greenX, greenY, greenC);
			title = rotateText90(title, titleX, titleY);
			int tempHolderW = holderW; holderW = holderH; holderH = tempHolderW; int tempConnectorW = connectorW; connectorW = connectorH; connectorH = tempConnectorW; int tempBodyW = bodyW; bodyW = bodyH; bodyH = tempBodyW;
			update();
        }

        else if (degrees == 270) {
	        
	        	holder = rotateRectangle90(holder, holderX, holderY, holderW, holderH, holderC);
				connector = rotateRectangle90(connector, connectorX, connectorY, connectorW, connectorH, connectorC);
				body = rotateRectangle90(body, bodyX, bodyY, bodyW, bodyH, bodyC);
	            red = rotateCircle90(red, redX, redY, redC);
				yellow = rotateCircle90(yellow, yellowX, yellowY, yellowC);
				green = rotateCircle90(green, greenX, greenY, greenC);
				title = rotateText90(title, titleX, titleY);
				int tempHolderW = holderW; holderW = holderH; holderH = tempHolderW; int tempConnectorW = connectorW; connectorW = connectorH; connectorH = tempConnectorW; int tempBodyW = bodyW; bodyW = bodyH; bodyH = tempBodyW;
				update();
				eraseTraffic();
				holder = rotateRectangle90(holder, holderX, holderY, holderW, holderH, holderC);
				connector = rotateRectangle90(connector, connectorX, connectorY, connectorW, connectorH, connectorC);
				body = rotateRectangle90(body, bodyX, bodyY, bodyW, bodyH, bodyC);
	            red = rotateCircle90(red, redX, redY, redC);
				yellow = rotateCircle90(yellow, yellowX, yellowY, yellowC);
				green = rotateCircle90(green, greenX, greenY, greenC);
				title = rotateText90(title, titleX, titleY);
				tempHolderW = holderW; holderW = holderH; holderH = tempHolderW; tempConnectorW = connectorW; connectorW = connectorH; connectorH = tempConnectorW;  tempBodyW = bodyW; bodyW = bodyH; bodyH = tempBodyW;
				update();
				eraseTraffic();
				holder = rotateRectangle90(holder, holderX, holderY, holderW, holderH, holderC);
				connector = rotateRectangle90(connector, connectorX, connectorY, connectorW, connectorH, connectorC);
				body = rotateRectangle90(body, bodyX, bodyY, bodyW, bodyH, bodyC);
	            red = rotateCircle90(red, redX, redY, redC);
				yellow = rotateCircle90(yellow, yellowX, yellowY, yellowC);
				green = rotateCircle90(green, greenX, greenY, greenC);
				title = rotateText90(title, titleX, titleY);
				tempHolderW = holderW; holderW = holderH; holderH = tempHolderW; tempConnectorW = connectorW; connectorW = connectorH; connectorH = tempConnectorW; tempBodyW = bodyW; bodyW = bodyH; bodyH = tempBodyW;
				update();
        }
        else {
        	startAnimation("You must enter a valid angle (90 or 180)");
        }

        update();
			
			
			
			printPosition();
            


        
        update();
        if(animate) endAnimation("Traffic Light Rotated");
    }

    static int scaleX = 50;
    static int scaleY = 126;

    public static void scale(double factor) {
    	update();
        if(animate) startAnimation("Scaling Traffic Light");
        int centerX = body.getXposition() + scaleX;
        int centerY = body.getYposition() + scaleY;
        eraseTraffic();

        holder = new Rectangle(
            (int)(centerX + factor * (holderX - centerX)),
            (int)(centerY + factor * (holderY - centerY)),
            (int)(holderW * factor),
            (int)(holderH * factor),
            "black"
        );
        connector = new Rectangle(
            (int)(centerX + factor * (connectorX - centerX)),
            (int)(centerY + factor * (connectorY - centerY)),
            (int)(connectorW * factor),
            (int)(connectorH * factor),
            "black"
        );
        body = new Rectangle(
            (int)(centerX + factor * (bodyX - centerX)),
            (int)(centerY + factor * (bodyY - centerY)),
            (int)(bodyW * factor),
            (int)(bodyH * factor),
            "gray"
        );
        red = new Circle(
            (int)(centerX + factor * (redX - centerX)),
            (int)(centerY + factor * (redY - centerY)),
            (int)(redR * factor),
            "red"
        );
        yellow = new Circle(
            (int)(centerX + factor * (yellowX - centerX)),
            (int)(centerY + factor * (yellowY - centerY)),
            (int)(redR * factor),
            "yellow"
        );
        green = new Circle(
            (int)(centerX + factor * (greenX - centerX)),
            (int)(centerY + factor * (greenY - centerY)),
            (int)(redR * factor),
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
        if(animate) endAnimation("Traffic Light Scaled");
        
        holderW = (int) (holderW*factor); holderH = (int) (holderH*factor); 
		connectorW = (int) (connectorW*factor); connectorH = (int) (connectorH*factor); 
		bodyW = (int) (bodyW*factor); bodyH = (int) (bodyH*factor); 
		redR = (int) (redR*factor); 
		yellowR = (int) (yellowR*factor); 
		greenR = (int) (greenR*factor);
    }
}
