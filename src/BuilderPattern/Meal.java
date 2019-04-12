package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public float calculatePrice() {
		float totalPrice = 0.0f;
		for (Item i : items) {
			totalPrice += i.price();
		}

		return totalPrice;
	}

	public void printItem() {
		for (Item i : items) {
			System.out.print("ItemName = " + i.name() + " ");
			System.out.print("Item Packing = " + i.packing().packingName() + " ");
			System.out.print("Item Price = " + i.price() + " ");
			System.out.println("\n-----------------------------");
		}
	}
}
