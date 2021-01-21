package パ研杯2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Karaoke {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[][] points = new int [N][M];
		for(int i=0;i<N;i++) {
			token = new StringTokenizer(reader.readLine());
			for(int j=0;j<M;j++) {
				points[i][j] = Integer.parseInt(token.nextToken());
			}
		}
		reader.close();

		//組み合わせ全探索
		long max = 0;
		//T1
		for(int i=0;i<M-1;i++) {
			//T2
			for(int j= i+1;j<M;j++) {
				long now = 0;
				//人数分
				for(int n=0;n<N;n++) {
					now += Math.max(points[n][i], points[n][j]);
				}
				if(now> max) max= now;
			}
		}

		System.out.println(max);


	}

}
