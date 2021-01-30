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

		//重複あり
		int[][] map = new int[N+1][N+1];

		for(int i = 1;i<=M;i++) {
			token = new StringTokenizer(reader.readLine());
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());

			map[A][B]++;
			map[B][A]++;
		}

		token = new StringTokenizer(reader.readLine());
		int k = Integer.parseInt(token.nextToken());

		int[][] kList = new int[k][2];
		for(int i=0;i<k;i++) {
			token = new StringTokenizer(reader.readLine());
			int c = Integer.parseInt(token.nextToken());
			int d = Integer.parseInt(token.nextToken());
			kList[i][0]= c;
			kList[i][1] = d;
		}

		int ans =0;
		//bit全探索(Max 2^16)
		for(int i=0,loop=1<<k;i<loop;i++) {
			//0→ボール無し 1→ボールあり 2→チェック済
			boolean[][] checkList = new boolean[N+1][N+1];
			int count =0;
			//k回ボールを入れる
			for(int j = 0;j<k;j++) {
				int z =0;
				//bitが立っていたらdにボールをいれる
				if((i>>j & 1)==1) {
					z =kList[j][1];
				//bitが立っていなければcにボールを入れる
				}else {
					z = kList[j][0];
				}
				checkList[0][z] =true;
				for(int l = 1;l<=N;l++) {
					if(checkList[0][l] == true&& checkList[z][l] == false) {
						count += map[z][l];

					checkList[z][l] =true;
					checkList[l][z] =true;
					}
				}
			}
			if(ans < count) ans = count;
		}
		System.out.println(ans);
	}
}
