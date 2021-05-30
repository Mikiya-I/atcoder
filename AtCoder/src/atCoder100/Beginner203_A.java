package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner203_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		int c = Integer.parseInt(strs[2]);
		
		if(a==b) {
			System.out.println(c);
		}else if(a==c) {
			System.out.println(b);
		}else if(b==c){
			System.out.println(a);
		}else {
			System.out.println(0);
		}
	}

}
