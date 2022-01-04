package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q052_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long ans = 1;
		final long mod = (long)1e9+7;
		final int N = Integer.parseInt(reader.readLine());
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			long tmp = 0;
			for(String str:strs)
				tmp += Long.parseLong(str);
			ans *= tmp;
			ans%= mod;
		}
		return ans;
	}
}
