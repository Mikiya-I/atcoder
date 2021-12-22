package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class BFSSample {
	static ArrayDeque<Integer> que = new ArrayDeque<Integer>();
	static boolean[] used;
	

	void bfs(ArrayList<ArrayList<Integer>> path) {
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		int[] dis = new int[100];
		Arrays.fill(dis, -1);
		que.push(1);
		dis[1] = 0;
		while (!que.isEmpty()) {
			int t = que.pop();
			//		        que.pop();
			for (int x : path.get(t)) {
				if (dis[x] == -1) {
					dis[x] = dis[t] + 1;
					que.push(x);
				}
			}
		}
	}
	
	
	//01BFS(グリッドで実装)
	static int[][][] minCnt;
	static boolean[][] grid;
	static ArrayDeque<Node> que01;
	static int[] xVariation = { 0, 1, 0, -1 };
	static int[] yVariation = { -1, 0, 1, 0 };
	static int H,W;
	
	void bfs01() {
		while (!que01.isEmpty()) {
			Node node = que01.pollFirst();
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
					que01.addFirst(new Node(ni, nj, i));
				else
					que01.addLast(new Node(ni, nj, i));
			}
		}
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
}
