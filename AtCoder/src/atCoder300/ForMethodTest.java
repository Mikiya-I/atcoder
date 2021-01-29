package atCoder300;

import java.util.Arrays;

public class ForMethodTest {

	public static void main(String[] args) {
		int[] A = {1,2,2,2,3,3,4,5,5,5,6,7,8,9,10,9,9,10,10,11,100,2,3,4,5,0};
		Arrays.sort(A);
		for(int a:A) {
			System.out.print(a + " ");
		}
		Beginner077_SunukeFestival binary = new Beginner077_SunukeFestival();
		System.out.println(A.length);
		int x=binary.lower_bound(A, 5);
		System.out.println(x);
		System.out.println(A[x]);
		System.out.println(A[x+1]);
		int y=binary.upper_bound(A, 5);
		System.out.println(y);
		System.out.println(A[y]);
		System.out.println(binary.lower_bound(A,1));
		System.out.println(binary.upper_bound(A,10));

	}

}
