package PrototypePattern;

public class PatternDemo {

	public static void main(String args[]) {
		ShapePrototype.loadShapes();

		Shape circle = ShapePrototype.getShape("1");
		
		circle.draw();
		System.out.println(circle.getType());
	}
}
