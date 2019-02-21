import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validity {

	public static void main(String args[]) {
		int[] a = { 1, 3, 4, 5, 6 };
		int[] b = Arrays.copyOfRange(a, 0, 2);

		System.out.println(Arrays.toString(a));

		System.out.println(Arrays.toString(b));

		b[0] = 4;

		System.out.println(Arrays.toString(a));

		System.out.println(Arrays.toString(b));

		List<Integer> li = Arrays.stream(a).boxed().collect(Collectors.toList());
		System.out.println(li);
	}
}
