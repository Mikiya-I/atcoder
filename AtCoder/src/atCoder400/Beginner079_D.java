package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner079_D {

	public static void main(String[] args) throws IOException {
		long  ans = slove();
//		slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		int[][] changeCost = new int[10][10];
		int[][] grid = new int[H][W];
		for(int i=0;i<10;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<10;j++) {
				changeCost[i][j] =Integer.parseInt(strs[j]);
			}
		}
		for(int i=0;i<H;i++) {
			strs = reader.readLine().split(" ");
			for(int j=0;j<W;j++) {
				grid[i][j] = Integer.parseInt(strs[j]);
			}
		}
		long ans = 0;
		//ワーシャルフロイドで各値の変換の最低値を求める
		//経由地する値
		for(int i=0;i<10;i++) {
			//スタート地点
			for(int j=0;j<10;j++) {
				//ゴール
				for(int k=0;k<10;k++) {
						changeCost[j][k] = Math.min(changeCost[j][k],changeCost[j][i]+changeCost[i][k]);
				}
			}
		}
		
		for(int[] arr: grid) {
			for(int i=0;i<W;i++) {
				if(arr[i] != -1 && arr[i] != 1) {
					ans += changeCost[arr[i]][1];
				}
			}
		}
		
		return ans;
	}
}
