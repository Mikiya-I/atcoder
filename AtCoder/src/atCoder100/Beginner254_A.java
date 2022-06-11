package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner254_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		if(N%100 < 10)
			System.out.println("0" +( N%100));
		else
			System.out.println(N%100);
	}
	
}
