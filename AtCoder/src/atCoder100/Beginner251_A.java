package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner251_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		int cnt = 6/s.length();
		for (int i=0;i<cnt;i++) {
			System.out.print(s);
		}
	}
	
}
