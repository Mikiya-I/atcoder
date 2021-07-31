package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner212_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);

		if(a==0 && b>0) {
			System.out.println("Silver");
		}else if(a>0&& b==0) {
			System.out.println("Gold");
		}else if(a>0 && b>0) {
			System.out.println("Alloy");
		}
	}
}
