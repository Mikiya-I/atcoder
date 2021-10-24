package atcoder90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q043 {
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
		char[][] s = new char[h][w];
		for (int i = 0; i < h; i++) {
			s[i] = reader.readLine().toCharArray();
		}
		reader.close();
 
		
		int w4 = w * 4;
		int[] d = new int[h * w * 4];
		Arrays.fill(d, Integer.MAX_VALUE);
		Deque<Node> que = new ArrayDeque<Node>();
		for (int i = 0; i < 4; i++) {
			int v = rs * w4 + cs * 4 + i;
			d[v] = 0;
			que.add(new Node(v, 0));
		}
 
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		while (!que.isEmpty()) {
			Node cur = que.poll();
			if (cur.d > d[cur.v]) {
				continue;
			}
			int cx = cur.v / w4;
			int cy = cur.v % w4 / 4;
			if (cx == rt && cy == ct) {
				System.out.println(cur.d);
				return;
			}
			int cz = cur.v % 4;
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if (nx < 0 || h <= nx || ny < 0 || w <= ny || s[nx][ny] == '#') {
					continue;
				}
				int nz = i;
				int alt = d[cur.v];
				if (cz != nz) {
					alt++;
				}
				int nv = nx * w4 + ny * 4 + nz;
				if (alt < d[nv]) {
					d[nv] = alt;
					if (cz == nz) {
						que.addFirst(new Node(nv, alt));
					} else {
						que.addLast(new Node(nv, alt));
					}
				}
			}
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
		int v, d;
 
		public Node(int v, int d) {
			this.v = v;
			this.d = d;
		}
 
		public int compareTo(Node o) {
			return Long.compare(d, o.d);
		}
	}
}