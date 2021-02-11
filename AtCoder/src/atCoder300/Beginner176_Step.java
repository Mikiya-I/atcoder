package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner176_Step {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		final int N = Integer.parseInt(token.nextToken());
		token = new StringTokenizer(reader.readLine());
		reader.close();
		long ans = 0;
		long base = 0;
		for(int i = 0;i<N;i++) {
			long current = Long.parseLong(token.nextToken());
			if(base < current) {
				base =current;
			}else if(base > current) {
				ans += base-current;
			}
		}
		System.out.println(ans);
	}

}

