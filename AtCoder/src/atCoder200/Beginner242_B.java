package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner242_B {
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		arr = reader.readLine().toCharArray();
		reader.close();
	}

	public static String slove() throws IOException {
		Arrays.sort(arr);
		return new String(arr);
	}
	
}
 