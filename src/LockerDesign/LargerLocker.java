package LockerDesign;

public class LargerLocker extends Locker implements LockerDao {

	LargerLocker(int length, int bredth, int height) {
		super(length, bredth, height);
	}

	@Override
	public int calculateLockerSize() {
		int area = 2 * getLength() * getBredth() + 2 * getBredth() * getHeight() + 2 * getHeight() * 2 * getLength();
		return area;
	}
}
