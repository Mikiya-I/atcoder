package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner189_Alcoholic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int X = Integer.parseInt(token.nextToken());

		int sum = 0;

		int ans;
		for (ans = 0; ans < N;) {
			token = new StringTokenizer(reader.readLine());
			int v = Integer.parseInt(token.nextToken());
			int p = Integer.parseInt(token.nextToken());
			ans++;

			sum += v*p;

			if (X*100 < sum) {
				System.out.println(ans);
				return;
			}

		}
		System.out.println(-1);

	}

}
