package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q043 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		final int y1 = Integer.parseInt(strs[0]);
		final int x1 = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		final int y2 = Integer.parseInt(strs[0]);
		final int x2 = Integer.parseInt(strs[1]);
		
		boolean[][] grid = new boolean[H+2][W+2];
		int[][] dp = new int[H+2][W+2];
		//r:→ l:← u:↑ d:↓
		char[][] vector = new char[H+2][W+2];
		
		for(int i=0;i<H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=1;j<=W;j++) {
				if( arr[i-1] == '.')
					grid[i][j] = true;
			}
		}
		
		
		
		return 0;
	}
}
