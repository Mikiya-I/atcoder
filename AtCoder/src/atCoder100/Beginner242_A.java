package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner242_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		double a = Integer.parseInt(strs[0]);
		double b = Integer.parseInt(strs[1]);
		double c = Integer.parseInt(strs[2]);
		double x = Integer.parseInt(strs[3]);
		
		if(x<= a) {
			System.out.println(1);
		}else if(x <= b) {
			double pai = b-a;
			System.out.println(c/pai);
		}else {
			System.out.println(0);
		}
	}
	
}
