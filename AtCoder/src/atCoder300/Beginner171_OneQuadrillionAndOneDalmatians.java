package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner170_OneQuadrillionAndOneDalmatians {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(reader.readLine());
		String ans = "";

		while(N != 0) {
			N--;
			ans += (char)('a' + (N % 26));
			N /=26;
		}

		System.out.println(new StringBuilder(ans).reverse().toString());
	}
}

