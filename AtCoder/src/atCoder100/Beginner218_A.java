package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner218_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		char[] arr = reader.readLine().toCharArray();

		if(arr[N-1] == 'o')
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
