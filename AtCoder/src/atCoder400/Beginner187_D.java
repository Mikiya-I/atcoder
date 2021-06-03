package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner187_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		long[] A = new long[N];
		long[] B = new long[N];
		long[] sums = new long[N];
		long[] differences = new long[N];
		long aSum =0;
		
		String[] strs;
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			A[i] = Long.parseLong(strs[0]);
			B[i] = Long.parseLong(strs[1]);
			sums[i] = A[i] + B[i];
			aSum += A[i];
			differences[i] = A[i]*2+B[i];
		}
		
		long dSum =0;
		long ans =0;
		int i=N-1;
		Arrays.sort(differences);
		while(aSum >= dSum) {
			dSum += differences[i];
			i--;
			ans++;
		}
		
		return ans;
	}
}