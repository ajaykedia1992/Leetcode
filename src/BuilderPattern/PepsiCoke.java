package BuilderPattern;

public class PepsiCoke extends Coke {

	@Override
	public String name() {
		return "Pepsi Coke";
	}

	@Override
	public float price() {
		return 5.0f;
	}

}
