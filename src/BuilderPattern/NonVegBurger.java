package BuilderPattern;

public class NonVegBurger extends Burger {

	@Override
	public String name() {
		return "Non-Veg Burger";
	}

	@Override
	public float price() {
		return 15.0f;
	}

}
