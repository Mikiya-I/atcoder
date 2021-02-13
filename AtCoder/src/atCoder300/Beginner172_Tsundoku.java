package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner172_Tsundoku {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		final int N = Integer.parseInt(token.nextToken());
		final int M = Integer.parseInt(token.nextToken());
		final int K = Integer.parseInt(token.nextToken());

		int[] sumA = new int[N];
		int[] sumB = new int[M];

		token = new StringTokenizer(reader.readLine());
		int canRead = 0;
		//Aの累積和
		for(int i = 0;i<N;i++) {
			sumA[i] = Integer.parseInt(token.nextToken());
			if(sumA[i] > K)
				break;
			canRead ++;
		}
	}
}

