package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner239_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		double H = Long.parseLong(reader.readLine());
		
		H*=(H+12800000);
		System.out.println(Math.sqrt(H));
	}
	
}
