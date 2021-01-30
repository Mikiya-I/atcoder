package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner190_BowlsAndDishes {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[] A = new int[M+1];
		int[] B = new int[M+1];

		for(int i = 1;i<=M;i++) {
			token = new StringTokenizer(reader.readLine());
			A[i] = Integer.parseInt(token.nextToken());
			B[i] = Integer.parseInt(token.nextToken());
		}

		token = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(token.nextToken());

		int[] C = new int[k+1];
		int[] D= new int[k+1];

		for(int i=0;i<k;i++) {
			token = new StringTokenizer(reader.readLine());
			C[i] = Integer.parseInt(token.nextToken());
			D[i] = Integer.parseInt(token.nextToken());
		}

		int ans =0;
		//bit全探索(Max 2^16)
		for(int i=0,loop=1<<k;i<loop;i++) {
			boolean[] checkList = new boolean[N+1];
			int count =0;
			//k回ボールを入れる
			for(int j = 0;j<k;j++) {
				//bitが立っていたらdにボールをいれる
				if((i>>j & 1)==1) {
					checkList[D[j]]= true;
				//bitが立っていなければcにボールを入れる
				}else {
					checkList[C[j]] = true;
				}
			}

			for(int l = 1;l<=M;l++) {
				if(checkList[A[l]] && checkList[B[l]]) count++;
			}

			if(ans < count) ans = count;
		}
		System.out.println(ans);
	}
}
