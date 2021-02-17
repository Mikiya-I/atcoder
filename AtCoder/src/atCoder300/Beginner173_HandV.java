package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner173_HandV {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		final int H = Integer.parseInt(token.nextToken());
		final int V = Integer.parseInt(token.nextToken());
		final int K = Integer.parseInt(token.nextToken());

		boolean[][]field = new boolean[H][V];

		int markCnt = 0;
		for(int i=0;i<H;i++) {
			char[] row = reader.readLine().toCharArray();
			for(int j=0;j<V;j++) {
				if(row[j] =='#') {
					field[i][j] = true;
					markCnt ++;
				}
			}
		}

		int ans = 0;
		//縦横でbit全探索
		for(int i= 0,loop = 1 << H; i< loop;i++) {
			int current = markCnt;
			boolean[] hLine = new boolean[H];
			//縦
			int j = 0;
			while( i >> j > 0){
				if((i >> j&1)==1){
					hLine[j] = true;
					for(boolean mark:field[j]) {
						if(mark) {
							current --;
						}
					}
				}
				j++;
			}
			//横
			for(int k =0, wLoop = 1<<V;k < wLoop;k++) {
				int l =0;
				int current2 = 0;
				while((k  >> l) > 0) {
					if((k >> l&1)==1){
						for(int row=0;row <H;row++) {
							if(!hLine[row] && field[row][l]) {
								current2 ++;
							}
						}
					}
					l++;
				}
				if(current - current2 == K) ans ++;
			}
		}
		System.out.println(ans);
	}
}

