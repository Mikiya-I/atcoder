package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner193_Discount {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] str = reader.readLine().split(" ");
		double a = Double.parseDouble(str[0]);
		double b = Double.parseDouble(str[1]);
		System.out.println((a-b)/a*100);
	}

}
