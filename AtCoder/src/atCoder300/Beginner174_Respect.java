package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner174_Respect {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		final int K = Integer.parseInt(token.nextToken());
		reader.close();

		int[] mod = new int[K+1];
		for(int i = 1;i<=K;i++) {
			mod[i] = (mod[i-1]*10+7)%K;
			if(mod[i] % K ==0 ) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);
	}

}

