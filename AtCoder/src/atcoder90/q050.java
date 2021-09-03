package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q050 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int L = Integer.parseInt(strs[1]);
		long e97 = (long)1e9+7;
		
		if(L==1 || N< L) {
			return 1;
		}
		long[] arr = new long[N+1];
//		long[] lCnt = new long[N+1];
		arr[0] = 1;
		int i=1;
		int loop = Math.min(L, N);
		while(i < loop) {
			arr[i] = 1;
			i++;
		}
		
		while(i<=N) {
			arr[i] = arr[i-1]+arr[i-L];
			arr[i] %= e97;
			i++;
		}
		
		return arr[N];
	}
}
