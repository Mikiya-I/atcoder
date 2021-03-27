package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner197_Rorate {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		char[] c = reader.readLine().toCharArray();
		char tmp = c[0];
		c[0]=c[1];
		c[1]=c[2];
		c[2]= tmp;

		System.out.println(String.valueOf(c));
	}

}
