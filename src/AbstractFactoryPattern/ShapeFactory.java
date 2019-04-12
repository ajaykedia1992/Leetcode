package AbstractFactoryPattern;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getFactory(String shape) {
		if (shape.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		} else if (shape.equalsIgnoreCase("Square")) {
			return new Square();
		} else {
			return null;
		}

	}

}
