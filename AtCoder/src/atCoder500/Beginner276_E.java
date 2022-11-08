package atCoder500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Beginner276_E {
	static int H,W,start,size;
	static boolean[][] grid;
	static ArrayDeque<Integer> que ;
	static boolean[] used;
//	↑,→,↓,←
	static int[] move = {-(W+2),1,W+2,-1};
	static int[][] gridNum;
	static boolean ans = false;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//				slove();
		input();
//		System.out.println(slove());
		slove();
	}

	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		grid = new boolean[H+2][W+2];
		for(int i=1;i<=H;i++) {
			char[] s = reader.readLine().toCharArray();
			for(int j=1;j<=W;j++) {
				if(s[j-1]=='#')
					continue;
				if(s[j-1]=='S')
					start = i*(W+2) + j%(W+2);
				grid[i][j] = true;
			}
		}
		reader.close();
	}

	public static void slove() throws IOException {
		que = new ArrayDeque<Integer>();
		que.add(start);
		used = new boolean[(H+2)*(W+2)];
		gridNum = new int[(H+2)][(W+2)];
		size = 0;
//		dfs();
		System.out.println(ans?"Yes":"No");
	}
	
	static void bfs(){
		que.push(1);
		while (!que.isEmpty()) {
			int t = que.pop();
			for (int i:move) {
				int tmp = t + i;
				int tmpY = tmp/(W+2);
				int tmpX = tmp%(W+2);
				if(grid[tmpY][tmpX] ==true)
					ans = true;
				}
			}
		}
	}
}
