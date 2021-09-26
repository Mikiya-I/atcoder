package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner220_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int K = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		final char[] A = strs[0].toCharArray();
		final char[] B = strs[1].toCharArray();
		long tmpA=0;
		int base  = 1;
		for(int i= A.length-1;i>= 0;i--) {
			tmpA +=( (int)A[i]-48) * base;
			base *= K;
		}
		long tmpB = 0;
		base = 1;
		for(int i= B.length-1;i>= 0;i--) {
			tmpB +=( (int)B[i]-48) * base;
			base *= K;
		}
		
		return tmpA * tmpB;
	}
}
