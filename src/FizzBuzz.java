/*
 * FizzBuzz: Output number from 1 to x. If the number is divisible by 3, replace it with "Fizz". If it is divisible by 5, 
 * replace it by Buzz and if it's divisible by 3 and 5 then print FizzBuzz.
 */
public class FizzBuzz {

	public static void main(String args[]) {
		int N = 30;
		for (int number = 1; number <= N; number++) {
			if (number % 15 == 0) {
				System.out.println("FizzBuzz");
			} else if (number % 3 == 0) {
				System.out.println("Fizz");
			} else if (number % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(number);
			}
		}
	}
}
