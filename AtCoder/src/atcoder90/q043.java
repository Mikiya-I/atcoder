package atcoder90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class q043 {
	static char[][] grid;
	static int[][][] grid4;
	static PriorityQueue<Node> que;

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
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				Arrays.fill(grid4[i][j], -1);
			}
		}
		
		
		//キュー
		que = new PriorityQueue<Node>();
		//スタート地点はdis=0
		for (int i = 0; i < 3; i++)
			grid4[0][0][i] = 0;

		//スタートをキューに入れる(4方向分)
		for(int i=1;i<5;i++)
			que.add(new Node(0, 0, i, 0));
		//スタート地点から繋がっている所をキューに入れる
//		checkAround(que.poll());
		
		while (!que.isEmpty()) {
			Node current = que.poll();
			
			//同じ方向を向いていて値を更新しないときはスルー
			if(grid4[current.y][current.x][current.vector-1] <= current.distance  && grid4[current.y][current.x][current.vector-1] != -1) 
				continue;
			checkAround(current);
			grid4[current.y][current.x][current.vector-1] = current.distance;
		}

		int min = Integer.MAX_VALUE;
		for(int i=0;i<4;i++) {
			min = Math.min(grid4[rt][ct][i],min);
		}
		
		System.out.println(min!= Integer.MAX_VALUE?min:-1);
	}

	//周囲の経路をキューに入れる
	static void checkAround(Node node) {
		//上
		if (node.y != 0 && grid[node.y - 1][node.x] == '.') {
			que.add(new Node(node.x, node.y - 1, 1,node.vector == 1 || node.vector == 0 ? node.distance : node.distance + 1));
		}
		//右
		if (node.x != grid[0].length-1 && grid[node.y ][node.x+1] == '.') {
			que.add(new Node(node.x+1, node.y, 2,node.vector == 2 || node.vector == 0 ? node.distance : node.distance + 1));
		}
		//下
		if (node.y != grid.length-1 && grid[node.y + 1][node.x] == '.') {
			que.add(new Node(node.x, node.y + 1, 3,node.vector == 3 || node.vector == 0 ? node.distance : node.distance + 1));
		}
		//左
		if (node.x != 0 && grid[node.y ][node.x-1] == '.') {
			que.add(new Node(node.x-1, node.y, 2,node.vector == 4 || node.vector == 0 ? node.distance : node.distance + 1));
		}
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

		public Node(int x, int y, int v, int d) {
			this.vector = v;
			this.distance = d;
			this.x = x;
			this.y = y;
		}

		public int compareTo(Node o) {
			return Long.compare(distance, o.distance);
		}
	}
}