package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner219_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		
		if(N<40) {
			System.out.println(40-N);
		}else if(N < 70) {
			System.out.println(70-N);
		}else if(N < 90) {
			System.out.println(90-N);
		}else {
			System.out.println("expert");
		}
	}
}
