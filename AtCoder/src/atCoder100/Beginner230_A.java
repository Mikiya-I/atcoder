package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner230_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String ans  = "AGC";
		
		if(N >= 42) {
			N+= 1;
		}
		ans += String.format("%03d", N);
		System.out.println(ans);
	}
}
