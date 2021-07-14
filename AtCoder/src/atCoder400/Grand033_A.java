package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Grand033_A {
	static ArrayList<ArrayList<Integer>> path;
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int H = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		//表の情報(外枠に1マス分余裕を持つと計算が楽)
		int[][] grid = new int[H+2][W+2];
		//スタート地点を保持
		ArrayList<ArrayList<Integer>> startPosition = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=H;i++) {
			startPosition.add(new ArrayList<Integer>());
		}
		//白い点の個数
		int whiteCnt=0;
		//表の情報の読み込み
		for(int i=1;i<=H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=1;j<=W;j++) {
				if(arr[j-1]=='.') {
					grid[i][j]=-1;
					whiteCnt++;
				}else {
					startPosition.get(i).add(j);
				}
			}
		}
		
		int ans =0;
		ArrayDeque<int[]> que = new ArrayDeque<int[]>();
		for(int i=0;i<startPosition.size();i++) {
			for(int j:startPosition.get(i)) {
				checkAroud(i, j, grid, que);
			}
		}
		while(que.size()>0) {
			int[] position = que.pollFirst();
			checkAroud(position[0], position[1], grid, que);
		}
		
		for(int[] row:grid) {
			for(int i:row) {
				ans = Math.max(ans, i);
			}
		}
		return ans;
	}
	
	public static boolean checkAroud(int row,int column ,int[][] grid,ArrayDeque<int[]> que) {
		boolean flag = false;
		if(grid[row+1][column] == -1) {
			grid[row+1][column] = grid[row][column]+1;
			que.add(new int[]{row+1,column});
			flag = true;
		}
		if(grid[row-1][column] == -1) {
			grid[row-1][column] = grid[row][column]+1;
			que.add(new int[]{row-1,column});
			flag= true;
		}
		if(grid[row][column-1] == -1) {
			grid[row][column-1] = grid[row][column]+1;
			que.add(new int[]{row,column+-1});
			flag = true;
		}
		if(grid[row][column+1] == -1) {
			grid[row][column+1] = grid[row][column]+1;
			que.add(new int[] {row,column+1});
			flag=true;
		}
		return flag;
	}
}
