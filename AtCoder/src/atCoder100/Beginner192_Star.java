package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner192_Star {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		int N = Integer.parseInt(reader.readLine());
		System.out.println(100-N%100);
	}

}
