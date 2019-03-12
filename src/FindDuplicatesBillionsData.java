import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FindDuplicatesBillionsData {

	public static void main(String args[]) throws Exception{
		System.out.println(findDuplicate());
	}

	public static int findDuplicate() throws FileNotFoundException{
		byte[] byteArray = new byte[16 / 8];
		int[] arr = {1,2,3,1,4,6,7,1,8,9,10,11,14,12,13,15};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		int rst = 0;
		Iterator in = list.iterator();
		while(in.hasNext()){
			int n = (int)in.next();
			if((byteArray[n / 8] >> (n % 8) & 1) == 1){
				rst = n;
				break;
			}
			byteArray[n / 8] |= (1 << n % 8);
		}
		return rst;
	}
}
