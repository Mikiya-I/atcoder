package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner236_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] s = reader.readLine().toCharArray();
		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		char tmp = s[a-1];
		s[a-1] = s[b-1];
		s[b-1] = tmp;
		
		System.out.println(new String(s));
	}
	
}
