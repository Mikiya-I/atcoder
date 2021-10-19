package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q043 {
	static Map<Integer,Set<Integer>> path ;
	static boolean[] confirmed;
	//↑: -W;↓:W;→:1;←:-1;
	static int vector = 0;
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
		
		boolean[][] grid = new boolean[H+1][W+1];
		//r:→ l:← u:↑ d:↓
		char[][] vector = new char[H+2][W+2];
		path = new HashMap<Integer, Set<Integer>>();
		for(int i=1;i<=H*W;i++)
			path.put(i, new HashSet<Integer>());
		
		//グリッド情報読み込み
		for(int i=1;i<=H;i++) {
			char[] arr = reader.readLine().toCharArray();
			for(int j=1;j<=W;j++) {
				if( arr[i-1] == '.') {
					grid[i][j] = true;
				}
			}
		}
		//読み込んだグリッドからパスを通す
		for(int i=1;i<=H;i++) {
			for(int j=1;j<=W;j++) {
				int current = i*W+j;
				if(!grid[i][j])
					continue;
				if(grid[i+1][j]) {
					int under = current+W;
					path.get(current).add(under);
					path.get(under).add(current);
				}
				if(grid[i][j+1]) {
					int right = current+1;
					path.get(current).add(right);
					path.get(right).add(current);
				}
			}
		}
		
		
		
		
		return 0;
	}
}


class BFS01_43 {
	static ArrayDeque<Integer> que = new ArrayDeque<Integer>();
	 void bfs(ArrayList<ArrayList<Integer>> path) {
		 ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		    int[] dis = new int[100];
		    Arrays.fill(dis, -1);
		    que.push(1);
		    dis[1] = 0;
		    while(!que.isEmpty()){
		        int t = que.pop();
//		        que.pop();
		        for(int x: path.get(t)) { 
		        	if(dis[x] == -1) {
			            dis[x] = dis[t] + 1;
			            que.push(x);
		        	}
		        }
		    }
	 }
}
