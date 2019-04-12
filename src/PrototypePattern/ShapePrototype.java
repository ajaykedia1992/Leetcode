package PrototypePattern;

import java.util.HashMap;
import java.util.Map;

public class ShapePrototype {

	private static Map<String, Shape> map = new HashMap<>();

	public static Shape getShape(String id) {
		Shape shape = map.get(id);
		return (Shape) shape.clone();
	}

	public static void loadShapes() {
		Shape circle = new Circle();
		circle.setId("1");
		map.put(circle.getId(), circle);

		Shape rectangle = new Rectangle();
		rectangle.setId("2");
		map.put(rectangle.getId(), rectangle);

		Shape square = new Square();
		square.setId("3");
		map.put(square.getId(), square);
	}
}
