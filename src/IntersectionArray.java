import java.util.ArrayList;
import java.util.List;

public class IntersectionArray {
	
	public static void main(String args[]) {
		int[] A = {2,3,6,7,8,10};
		int[] B = {1,3,5,7,8,9};
		int[] C = {4,6,7,8,10};
		
		List<Integer> output = findIntersection(A,B,C);
		
		for(Integer i : output) {
			System.out.println(i);
		}
	}

	private static List<Integer> findIntersection(int[] A, int[] B, int[] C) {
		if(A == null || B == null || C == null || A.length == 0 || B.length == 0 || C.length == 0) {
			throw new IllegalArgumentException();
		}
		
		List<Integer> output = new ArrayList<>();
		for(int i = 0, j = 0, k = 0; i < A.length && j < B.length && k < C.length;) {
			if(A[i] == B[j] && B[i] == C[k]) {
				output.add(A[i]);
				i++; j++; k++;
			}
			else {
				if(A[i] < B[j]) {
					i++;
				}
				else if(B[j] < C[k]) {
					j++;
				}
				else {
					k++;
				}
			}
		}
		
		return output;
	}

}
