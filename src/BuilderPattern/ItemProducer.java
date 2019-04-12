package BuilderPattern;

public class ItemProducer {

	public Meal VegMealProducer() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new PepsiCoke());
		return meal;
	}

	public Meal NonVegMealProducer() {
		Meal meal = new Meal();
		meal.addItem(new NonVegBurger());
		meal.addItem(new SpriteCoke());
		return meal;
	}

}
