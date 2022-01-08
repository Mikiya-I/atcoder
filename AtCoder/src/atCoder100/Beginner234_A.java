package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner234_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(reader.readLine());
		reader.close();
		long val1 = functionX(t)+t;
		val1 = functionX(val1);
		
		long val2 = functionX(t);
		val2 = functionX(val2);
		
		long ans = functionX(val1 + val2);
		System.out.println(ans);
	}
	
	static long  functionX(long x) {
		return (long) (Math.pow(x, 2)+x*2 + 3);
	}
}
