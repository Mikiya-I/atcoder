
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner242_C {
	static int N;
	static int mod = 998244353;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		
		reader.close();
	}

	public static long slove() throws IOException {
//		long ans = 9;
		long ans = 0;
		int[] lastDigits = new int[10];
		Arrays.fill(lastDigits, 1);
		for(int i=0;i<N-1;i++) {
//			ans *= 3;
//			ans %= mod;
			int[] tmp = new int[10];
			for(int j=1;j<10;j++) {
				for(int k=-1;k<2;k++) {
					tmp[ (j+k)%10] += lastDigits[j];
					tmp[ (j+k)%10] %= mod;
				}
			}
			lastDigits = tmp;
		}
		for(int i=1;i<10;i++) {
			ans += lastDigits[i];
			ans %= mod;
		}
		return ans;
	}
	
}