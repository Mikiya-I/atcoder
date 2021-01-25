package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner002_Habatsu {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());

		int[][] line = new int[N][N];

		if(M==0) {
			System.out.println(1);
			return;
		}

		for(int i=0;i<M;i++) {
			token = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			line[x][y] = 1;
			line[y][x] = 1;
			line[x][x] = 1;
			line[y][y] = 1;
		}

		int max = 1;


		System.out.println(max);
	}

	void dfs (int[] aaa,int n){
		if(
	}
}
