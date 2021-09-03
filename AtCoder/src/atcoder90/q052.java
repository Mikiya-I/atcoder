package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q052 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		long e97 = (long)1e9+7;
		long[] sums = new long[N];
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			long tmp = 0;
			for(int j=0;j<6;j++) {
				tmp += Long.parseLong(strs[j]);
			}
			sums[i] = tmp;
		}
		reader.close();
		
		long ans = 1;
		for(int i=0;i<N;i++) {
			ans *= sums[i];
			ans %= e97;
		}
		
		return ans;
	}
}
