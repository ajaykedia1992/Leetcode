
public class ReverseInteger {

	public static void main(String args[]) {
		int number = -1223;
		int reverseNumber = 0;
		while(number != 0) {
			int rem = number%10;
			reverseNumber = reverseNumber*10 + rem;
			number /= 10;
		}
		
		System.out.println(reverseNumber);
	}
}
