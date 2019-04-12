package LockerDesign;

public class LockerAbstract {

	static Locker getLocker(int length, int bredth, int height) {

		int area = 2 * length * bredth + 2 * bredth * height + 2 * height * length;

		if (area < 10) {
			return new SmallLocker(length, bredth, height);
		} else if (area >= 10 && area < 20) {
			return new MediumLocker(length, bredth, height);
		}

		else if (area >= 20 && area < 30) {
			return new LargerLocker(length, bredth, height);
		} else {
			return null;
		}
	}
}
