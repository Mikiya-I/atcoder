package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Beginner232_D {
	static char[][] grid;
	static ArrayDeque<Point> que ;
	static boolean[][] used;
	static int ans;
	static int tmpCnt;
	static int[] diffY = {0,1};
	static int[] diffX = {1,0};

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
//				slove();
		input();
		System.out.println(slove());
	}
	
	static class Point{
		int x,y;
		Point(int y,int x){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		grid = new char[H][W];
		used = new boolean[H][W];
		for(int i=0;i<H;i++) {
			char[] tmp = reader.readLine().toCharArray();
			grid[i] = tmp;
		}
		reader.close();
	}
	
//	public static int slove2() throws IOException {
//		int[][] dp = new int[grid.length][grid[0].length];
//		dp[0][0] = 1;
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[i].length;j++) {
//				
//			}
//		}
//		
//		for(int i=0;i<dp.length;i++) {
//			for(int j=0;j<dp[i].length;i++) {
//				ans = Math.max(ans, dp[i][j]);
//			}
//		}
//	}


	public static int slove() throws IOException {
		ans = 1;
		tmpCnt = 1;
		que = new ArrayDeque<Point>();
		que.add(new Point(0, 0));
		dfs();
		
		return ans;
	}
	static void dfs() {
		while(que.size()>0) {
			ans = Math.max(ans, tmpCnt);
			Point tmp=que.pop();
			int tmpY = tmp.y;
			int tmpX = tmp.x;
			for(int i = 0;i<2;i++) {
				int nextX = tmpX+diffX[i];
				int nextY = tmpY+diffY[i];
				if(nextX >= grid[0].length || nextY >= grid.length || used[nextY][nextX])
					continue;
				if(grid[nextY][nextX] == '.') {
					que.add(new Point(nextY,nextX));
					used[nextY][nextX] = true;
					tmpCnt++;
					dfs();
				}
			}
			tmpCnt--;
		}
	}
	
}

