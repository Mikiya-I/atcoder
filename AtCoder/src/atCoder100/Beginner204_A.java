package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner204_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] strs = reader.readLine().split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		
		if(a==b) {
			System.out.println(a);
		}else if(a!=b && a+b==1) {
			System.out.println(2);
		}else if(a!=b && a+b == 3){
			System.out.println(0);
		}else {
			System.out.println(1);
		}
	}

}
