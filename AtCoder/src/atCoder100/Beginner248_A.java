package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner248_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] s = reader.readLine().toCharArray();
		boolean[] find = new boolean[10];
		for(char c : s) {
			find[(int)c - 48] = true;
		}
		for(int i= 0;i<10;i++) {
			if(! find[i])
				System.out.println(i);
		}
	}
	
}
