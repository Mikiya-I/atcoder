package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner179_A_B_C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());

		long ans =0;

		for(int i=1;i<N;i++) {
			ans+= (N-1)/i;
		}

		System.out.println(ans);
	}
}
