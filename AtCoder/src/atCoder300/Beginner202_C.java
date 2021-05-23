package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner202_C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		long[] a = new long[N+1];
		int [] b = new int[N+1];
		long[] c = new long[N+1];
		
		String strs[] = reader.readLine().split(" ");
		for(int i= 0;i<N;i++) {
//			a[i] = Integer.parseInt(strs[i]);
			a[Integer.parseInt(strs[i])]++;
		}
		
		strs = reader.readLine().split(" ");
		for(int i= 1;i<=N;i++) {
			b[i] = Integer.parseInt(strs[i-1]);
		}
		
		strs = reader.readLine().split(" ");
		for(int i= 0;i<N;i++) {
			c[Integer.parseInt(strs[i])]++;
		}
		
		long ans = 0;
		
		for(int i=0;i<=N;i++) {
			if(a[b[i]] != 0) {
				ans  += a[b[i] ] *c[i];
			}
		}
		return ans;
	}
}
