package atcoder90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class q043 {
	static char[][] grid;
	static int[][][] grid4;
	static ArrayDeque<Node> que;
	static int[] xVariation = { 0, 1, 0, -1 };
	static int[] yVariation = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//読み込み部
		String[] strs = reader.readLine().split(" ");
		int h = Integer.parseInt(strs[0]);
		int w = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		int rs = Integer.parseInt(strs[0]) - 1;
		int cs = Integer.parseInt(strs[1]) - 1;
		strs = reader.readLine().split(" ");
		int rt = Integer.parseInt(strs[0]) - 1;
		int ct = Integer.parseInt(strs[1]) - 1;
		grid = new char[h][w];
		for (int i = 0; i < h; i++) {
			grid[i] = reader.readLine().toCharArray();
		}
		reader.close();

		//[i][j][0]:(i,j)で↑を向くまでの最小回数/1:→/2:↓/3:←
		grid4 = new int[h][w][4];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				Arrays.fill(grid4[i][j], (int) 1e9);
			}
		}

		//キュー
		que = new ArrayDeque<Node>();

		//スタート地点は0 && スタートをキューに入れる(4方向分)
				for (int i = 0; i < 4; i++) {
					grid4[rs][cs][i] = 0;
					que.add(new Node(rs, cs, i));
				}

		while (!que.isEmpty()) {
			Node node = que.pollFirst();
			for (int i = 0; i < 4; i++) {
				int ni = node.y + yVariation[i];
				int nj = node.x + xVariation[i];
				int c = grid4[node.y][node.x][node.vector] + (node.vector != i ? 1 : 0);
				if (ni < 0 || ni >= h || nj < 0 || nj >= w || grid[ni][nj] == '#' || c >= grid4[ni][nj][i])
					continue;
				grid4[ni][nj][i] = c;
				if (i == node.vector)
					que.addFirst(new Node(ni, nj, i));
				else
					que.addLast(new Node(ni, nj, i));
			}
		}

		int min = (int) 1e9;
		for (int i = 0; i < 4; i++) {
			min = Math.min(grid4[rt][ct][i], min);
		}

		System.out.println(min != Integer.MAX_VALUE ? min : -1);
	}


	static class edge {
		int v, c;

		public edge(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

	static class Node implements Comparable<Node> {
		int x, y;
		//向いている方向(1:↑/2:→/3:↓/4:←)
		int vector
		//距離(ここでは方向転換した回数)
				, distance;

		public Node(int y, int x, int v) {
			this.vector = v;
			this.x = x;
			this.y = y;
		}

		public int compareTo(Node o) {
			return Long.compare(distance, o.distance);
		}
	}
}