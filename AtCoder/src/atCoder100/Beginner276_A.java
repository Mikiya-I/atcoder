package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner276_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] s  = reader.readLine().toCharArray();
		for(int i= s.length-1;i>=0;i--) {
			if(s[i]=='a') {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(-1);
	}
	
}
