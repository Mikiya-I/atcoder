package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner223_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int A = Integer.parseInt(strs[0]);
		
		if(A!= 0 && A %100 == 0)
			System.out.println("Yes");
		else {
			System.out.println("No");
		}
		
	}
}
