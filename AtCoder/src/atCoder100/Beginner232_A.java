package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner232_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = reader.readLine().toCharArray();
		int a = arr[0] -48;
		int b = arr[2] -48;
		System.out.println(a*b);
	}
}
