package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Regular119_A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long N = Long.parseLong(reader.readLine());
		
		long a=0;
		long b= 0;
		long c =0;
		long ans = Long.MAX_VALUE;
		while(N>Math.pow(2, b)) {
			b++;
		}
		for(int i=0;i<=b;i++) {
			a= N/(long)Math.pow(2, i);
			c = N-(long)Math.pow(2, i)*a;
			ans = Math.min(ans, a+i+c);
		}
		
		return ans;
	}
}
