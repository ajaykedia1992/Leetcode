
public class PowerFunc {
	public static void main(String args[]) {

		System.out.println(calculatePower(2, -3));
		System.out.println(calculatePower(2, 0.5f));

	}

	private static float calculatePower(float i, float j) {
		if (j == 0) {
			return 1;
		}

		int intValue = (int) j;

		float floatValue = j - intValue;

		if (floatValue == 0.0f && j > 0) {
			return positivePower(i, j);
		} else if (floatValue == 0.0f && j < 0) {
			return negativePower(i, j);
		} else if (floatValue != 0.0f && j > 0) {
			return calculateRational(i, floatValue, intValue);
		} else {
			return (float) 1 / calculateRational(i, floatValue + intValue * intValue, intValue * -1);
		}

	}

	private static float calculateRational(float i, float floatValue, float intValue) {
		return positivePower(i, intValue) * rationalPositiveValue(i, floatValue);
	}

	private static float rationalPositiveValue(float i, float floatValue) {

		return 0;
	}

	private static float negativePower(float i, float j) {
		return ((float) 1) / positivePower(i, -1 * j);
	}

	private static float positivePower(float i, float f) {
		int count = 1;
		for (int k = 0; k < f; k++) {
			count *= 2;
		}
		return count;
	}

}
