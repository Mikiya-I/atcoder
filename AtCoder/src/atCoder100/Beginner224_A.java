package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner224_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = reader.readLine().toCharArray();
		if(arr[arr.length-1]=='r')
			System.out.println("er");
		else
			System.out.println("ist");
	}
}
