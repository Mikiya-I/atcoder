package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q028 {
	
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(reader.readLine());
		int[][] grid = new int[1001][1001];
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int x1 = Integer.parseInt(strs[0]);
			int y1 = Integer.parseInt(strs[1]);
			int x2 = Integer.parseInt(strs[2]);
			int y2 = Integer.parseInt(strs[3]);
			grid[y1][x1] ++;
			grid[y1][x2]--;
			grid[y2][x1]--;
			grid[y2][x2]++;
		}
		
		//累積和計算
		//x軸方向
		for(int i=0;i<grid.length;i++) {
			for(int j=1;j<grid[i].length;j++) {
				grid[i][j] += grid[i][j-1];
			}
		}
		//y軸方向
		for(int i=1;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				grid[i][j] += grid[i-1][j];
			}
		}
		
		int[] sums = new int[N+1];
		for(int[] arr:grid) {
			for(int i:arr) {
				sums[i]++;
			}
		}
		
		for(int i = 1;i<N+1;i++) {
			sb.append(sums[i]);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
