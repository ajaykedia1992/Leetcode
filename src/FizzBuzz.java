
public class FizzBuzz {

	public static void main(String args[]) {
		int number = 12;
		StringBuffer result = new StringBuffer("");
		if(number % 2 == 0) {
			result.append("Fizz");
		}
		if(number % 3 == 0) {
			result.append("Buzz");
		}
		if(number % 5 == 0) {
			result.append("Huzz");
		}
		
		System.out.println(result);
	}
}
