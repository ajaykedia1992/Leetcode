import java.util.ArrayList;
import java.util.List;

class Box {
	int length;
	int width;
	int height;

	public Box(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	Box() {
	}

	public Box findLarger(int height, int sd1, int sd2) {
		Box box = new Box();
		box.height = height;
		if (sd1 >= sd2) {
			box.length = sd1;
			box.width = sd2;
		} else {
			box.length = sd2;
			box.width = sd1;
		}
		return box;
	}

	@Override
	public String toString() {
		return "Box [length=" + length + ", width=" + width + ", height=" + height + "]";
	}

}

public class BoxStacking {

	public static List<Box> findLongerLengthBox(Box b, List<Box> list) {
		int i = 0;
		
		
		
		return list;

	}

	public static void main(String args[]) {
		Box b1 = new Box(1, 2, 4);
		Box b2 = new Box(3, 2, 5);

		List<Box> list = new ArrayList<>();

	}
}
