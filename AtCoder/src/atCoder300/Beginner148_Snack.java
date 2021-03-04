package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner148_Snack {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String[] strs = reader.readLine().split(" ");
		reader.close();

		final int A = Integer.parseInt(strs[0]);
		final int B = Integer.parseInt(strs[1]);
		int max = Math.max(A, B);
		int min = Math.min(A, B);

		//ユークリッドの互除法
		while(true) {
			int mod =max%min;
		}
	}
}