package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner217_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");

		if(strs[0].compareTo(strs[1]) < 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
