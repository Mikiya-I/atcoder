package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner231_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double N = Integer.parseInt(reader.readLine());
		
		System.out.println(N/100);
	}
}
