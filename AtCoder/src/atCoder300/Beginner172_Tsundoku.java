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

		long[] sumA = new long[N+1];
		long[] sumB = new long[M+1];

		token = new StringTokenizer(reader.readLine());
		int ans = 0;
		//Aの累積和
		for(int i = 1;i<=N;i++) {
			sumA[i] = sumA[i-1]+ Long.parseLong(token.nextToken());
			if(sumA[i] > K)
				break;
			ans ++;
		}


		token = new StringTokenizer(reader.readLine());
		//B
		for(int i = 1;i<=M;i++) {
			sumB[i] = sumB[i-1]+ Long.parseLong(token.nextToken());
			if(sumB[i] > K)
				break;
		}

		for(int i = ans ,j = 0; i >= 0; i--) {
			for(; j <= M;j++) {
				if(sumA[i]+sumB[j] > K)
					break;

				if(i + j > ans)
					ans = i+j;
			}
			//jがmになったら増えようがないからカット
			if( j == M)
				break;
		}

		System.out.println(ans);
	}
}

