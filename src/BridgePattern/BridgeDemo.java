package BridgePattern;

public class BridgeDemo {

	public static void main(String args[]) {
		Circle circle = new Circle(10, 5, 4, new RedCircle());
		circle.drawCircle();
		
		circle = new Circle(10, 5, 4, new GreenCircle());
		circle.drawCircle();
	}
}
