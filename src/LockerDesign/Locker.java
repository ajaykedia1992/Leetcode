package LockerDesign;

public class Locker {

	int length;
	int bredth;
	int height;

	Locker(int length, int bredth, int height) {
		this.length = length;
		this.bredth = bredth;
		this.height = height;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBredth() {
		return bredth;
	}

	public void setBredth(int bredth) {
		this.bredth = bredth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
