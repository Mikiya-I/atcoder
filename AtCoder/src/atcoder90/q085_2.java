package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q085_2 {
	
	static long K;
	public static void main(String[] args) throws IOException {
		input();
//		test();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		K = Long.parseLong(reader.readLine());
		reader.close();
	}
	
	
	public static long slove() throws  IOException {
		long ans = 0;
		long a = (long) Math.cbrt(K);
		for(int i=1;i<=a;i++) {
			if(K%i != 0) {
				continue;
			}
			long remain = K/i;
			long b = (long) Math.sqrt(remain);
			for(int j=(int) i;j<=b;j++) {
				if(remain % j == 0) {
					ans ++;
				}
			}
		}
		return ans;
	}
	
}
