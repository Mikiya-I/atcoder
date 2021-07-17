package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner210_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);
		int a = Integer.parseInt(strs[1]);
		int x = Integer.parseInt(strs[2]);
		int y = Integer.parseInt(strs[3]);
		if (n <= a) {
			System.out.println(n * x);
		} else {
			System.out.println(a * x + (n-a) * y);
		}
	}
}
