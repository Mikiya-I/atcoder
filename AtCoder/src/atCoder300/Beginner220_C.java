
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner220_C {
	static char[] dict;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//		 slove();
		//		long ans = slove();
		System.out.println(slove());
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		final long X = Long.parseLong(reader.readLine());
		reader.close();
		long[] A = new long[N];
		long sum = 0;
		for(int i=0;i<N;i++) {
			A[i] = Long.parseLong(strs[i]);
			sum+= A[i];
		}
		long loop = X/sum;
		long remain = X%sum;
		long tmpSum = 0;
		int idx = 0;
		while(tmpSum<= remain) {
			tmpSum += A[idx];
			idx++;
		}
		
		return loop*N + (long)idx;
	}
}
