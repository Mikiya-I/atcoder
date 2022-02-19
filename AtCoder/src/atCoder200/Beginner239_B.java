package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner239_B {
	static long N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(reader.readLine());
		reader.close();
	}

	public static long slove() throws IOException {
		long ans = N/10;
		if(N%10 != 0 && N < 0) {
			ans --;
		}
		return ans;
	}
	
}
 