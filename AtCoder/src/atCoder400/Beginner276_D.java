
package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner276_D {
	static int N;
	static long[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		a = new long[N];
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++)
			a[i] = Long.parseLong(strs[i]);
	}

	public static int slove() throws IOException {
		int ans = 0;
		long gcd = a[0];
		for(int i=0;i<N;i++) {
			gcd = gcd(gcd,a[i]);
		}
		for(int i=0;i<N;i++) {
			long val = a[i]/gcd;
			while(val != 1) {
				if(val%2 != 0 && val%3 != 0)
					return -1;
				if(val%2==0) {
					val/=2;
					ans++;
				}
				if(val%3==0) {
					val/=3;
					ans++;
				}
			}
		}
		return ans;
	}
	
	static long gcd(long x,long y) {
		if(x==0) {
			return y;
		}
		if(y==0) {
			return x;
		}
		long max = Math.max(x, y);
		long min = Math.min(x, y);
		long mod = max%min;
		while(mod>0) {
			max=min;
			min=mod;
			mod=max%min;
		}
		
		return min;
	}
}