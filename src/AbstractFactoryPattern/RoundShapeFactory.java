package AbstractFactoryPattern;

public class RoundShapeFactory extends AbstractFactory {

	@Override
	public Shape getFactory(String shape) {
		if (shape.equalsIgnoreCase("Rectangle")) {
			return new RoundedRectangle();
		}

		else if (shape.equalsIgnoreCase("Square")) {
			return new RoundedSquare();
		} else {
			return null;
		}
	}

}
