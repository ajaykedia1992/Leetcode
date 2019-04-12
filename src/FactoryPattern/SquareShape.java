package FactoryPattern;

public class SquareShape {

	public static Shape getShape(String drawType) {
		if (drawType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (drawType.equalsIgnoreCase("Circle")) {
			return new Circle();
		} else {
			return new Square();
		}
	}

}
