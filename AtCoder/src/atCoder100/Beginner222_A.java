package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner222_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int A = Integer.parseInt(strs[0]);
		
		if(A>999)
			System.out.println(A);
		else {
			System.out.println(String.format("%04d", A));
		}
		
	}
}
