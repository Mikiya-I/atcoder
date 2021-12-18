package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class q043_2 {
	
	static int H,W;
	static int startRow;
	static int startColumn;
	static int endRow;
	static int endColumn;
	static int[][][] minCnt;
	static boolean[][] grid;static ArrayDeque<Node> que;
	static int[] xVariation = { 0, 1, 0, -1 };
	static int[] yVariation = { -1, 0, 1, 0 };
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
//		 slove();
	}
	
	static class Node implements Comparable<Node>{
		//入ってきた方向(0から時計回り)
		int vector;
		int x,y;
		int distance;
		public Node( int height,int width, int v) {
			x = width;
			y = height;
			vector = v;
		}
		public int compareTo(Node o) {
			return Long.compare(distance, o.distance);
		}
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		minCnt = new int [H][W][4];
		grid = new boolean[H][W];
		strs = reader.readLine().split(" ");
		startRow = Integer.parseInt(strs[0]);
		startColumn = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		endRow = Integer.parseInt(strs[0]);
		endColumn = Integer.parseInt(strs[1]);
		for(int i=0;i<H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j = 0;j<W;j++) {
				grid[i][j] = arr[j]=='.';
			}
		}
		reader.close();
	}

	static long slove() throws IOException {
		
		//[i][j][0]:(i,j)で↑を向くまでの最小回数/1:→/2:↓/3:←
		minCnt = new int[H][W][4];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Arrays.fill(minCnt[i][j], (int) 1e9);
			}
		}
		que = new ArrayDeque<Node>();
		//スタート地点は0 && スタートをキューに入れる(4方向分)
		for (int i = 0; i < 4; i++) {
			minCnt[startRow -1][startColumn-1][i] = 0;
			que.add(new Node(startRow-1, startColumn-1, i));
		}
		bfs01();
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<4;i++) {
			ans = Math.min(ans, minCnt[endRow-1][endColumn-1][i]);
		}
		return ans;
    }
	
	static void bfs01() {
		while (!que.isEmpty()) {
			Node node = que.pollFirst();
			for (int i = 0; i < 4; i++) {
				//次に行く座標
				int ni = node.y + yVariation[i];
				int nj = node.x + xVariation[i];
				//その座標に行くまでの距離の合計
				int c = minCnt[node.y][node.x][node.vector] + (node.vector != i ? 1 : 0);
				//座標が存在しないorその座標に行けないor最小値を更新できない時はスキップ
				if (ni < 0 || ni >= H || nj < 0 || nj >= W || !grid[ni][nj] || c >= minCnt[ni][nj][i]) {
					continue;
				}
				minCnt[ni][nj][i] = c;
				//距離が追加されていなければ先頭に、そうでなければ後ろに追加
				if (i == node.vector)
					que.addFirst(new Node(ni, nj, i));
				else
					que.addLast(new Node(ni, nj, i));
			}
		}
	}
}