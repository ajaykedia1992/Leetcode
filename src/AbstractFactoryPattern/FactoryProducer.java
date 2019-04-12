package AbstractFactoryPattern;

public class FactoryProducer {

	public static AbstractFactory getShape(boolean rounded) {
		if (rounded) {
			return new RoundShapeFactory();
		}
		return new ShapeFactory();
	}
}
