package LockerDesign;

public class Main {

	public static void main(String args[]) throws Exception {

		Locker locker = LockerAbstract.getLocker(2, 2, 2);

		if (locker == null) {
			throw new Exception("No such locker is available");
		}

		else {

		}

	}
}
