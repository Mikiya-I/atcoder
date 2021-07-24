package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner211_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		double a = Integer.parseInt(strs[0]);
		double b = Integer.parseInt(strs[1]);
		System.out.println((a-b)/3 + b);
		
	}
}
