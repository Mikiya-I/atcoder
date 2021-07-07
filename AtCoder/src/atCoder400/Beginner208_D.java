package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner208_D {

	public static void main(String[] args) throws IOException {
		long  ans = slove();
//		slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		int[][] path = new int[N+1][N+1];
		for(int[] arr:path) {
			Arrays.fill(arr, (int)1e9);
		}
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			int c = Integer.parseInt(strs[2]);
			path[a][b] =c;
		}
		for(int i=1;i<=N;i++) {
			path[i][i] = 0;
		}
		long ans = 0;
		//ワーシャルフロイド
		//経由地点
		for(int i=1;i<=N;i++) {
			//スタート地点
			for(int j=1;j<=N;j++) {
				//ゴール
				for(int k=1;k<=N;k++) {
						path[j][k] = Math.min(path[j][k],path[j][i]+path[i][k]);
						if(path[j][k] < 1e9) {
							ans += path[j][k];
						}
				}
			}
		}
		
		return ans;
	}
}
