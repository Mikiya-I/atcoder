package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner206_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int a = Integer.parseInt(reader.readLine());
		String ans;
		int p = (int) (a*1.08);
		if(p==206) {
			ans ="so-so";
		}else if(p< 206) {
			ans="Yay!";
		}else {
			ans=":(";
		}
		System.out.println(ans);
	}

}
