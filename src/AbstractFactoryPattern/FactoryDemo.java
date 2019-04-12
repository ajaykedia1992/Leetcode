package AbstractFactoryPattern;

public class FactoryDemo {

	public static void main(String args[]) {
		AbstractFactory abstractFactory = FactoryProducer.getShape(false);
		Shape shape = abstractFactory.getFactory("Rectangle");
		shape.draw();
	}
}
