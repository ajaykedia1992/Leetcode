package FactoryPattern;

public class FactoryDemo {

	public static void main(String args[]) {
		Shape shape = SquareShape.getShape("Rectangle");
		shape.draw();
		shape = SquareShape.getShape("Circle");
		shape.draw();
		shape = SquareShape.getShape("Square");
		shape.draw();
	}
}
