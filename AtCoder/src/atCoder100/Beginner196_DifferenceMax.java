package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner196_DifferenceMax {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] str = reader.readLine().split(" ");
		final int A = Integer.parseInt(str[0]);
		final int B = Integer.parseInt(str[1]);

		String[] str2 = reader.readLine().split(" ");
		final int C = Integer.parseInt(str2[0]);
		final int D = Integer.parseInt(str2[1]);

		System.out.println(Math.max(A, B)-Math.min(C, D));
	}

}
