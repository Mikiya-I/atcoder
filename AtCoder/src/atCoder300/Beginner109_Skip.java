package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner109_Skip {
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int X = Integer.parseInt(strs[1]);

		if(N==1) {
			return Math.abs(X-Integer.parseInt(reader.readLine()));
		}
		
		strs = reader.readLine().split(" ");
		int[] cities = new int[N+1];
		cities[0] = X;
		int gcd =0;
		for(int i=0;i<N;i++) {
			cities[i+1] = Integer.parseInt(strs[i]);
			gcd = gcd(gcd,Math.abs(cities[i]-cities[i+1]));
		}
		
		return gcd;
	}
	
	public static int gcd(int a, int b ) {
		if(a==b) {
			return a;
		}
		if(a==0) {
			return b;
		}
		if(b ==0) {
			return a;
		}
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int mod = max%min;
		while(mod>0) {
			max = min;
			min = mod;
			mod = max%min;
		}
		return min;
	}
}
