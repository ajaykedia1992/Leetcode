package BuilderPattern;

public class BuilderDemo {

	public static void main(String args[]) {
		ItemProducer itemProducer = new ItemProducer();
		Meal meal = itemProducer.VegMealProducer();
		meal.printItem();
		System.out.println(meal.calculatePrice());
	}
}
