package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q043 {
	static Map<Integer,Set<Integer>> path ;
	static boolean[] confirmed;
	//↑: -W;↓:W;→:1;←:-1;
	static int vector = 0;
	static int[] distance ;
	static int nodeCnt;
	static int firstNode,goalNode;
	static ArrayDeque<Map<Integer, Integer>> que;
	
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
		nodeCnt = H*W;
		firstNode = y1*W+x1;
		goalNode = y2*W+x2;
		
		boolean[][] grid = new boolean[H+2][W+2];
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
		
		//01BFS
		
		
		
		return 0;
	}
	
//	 void bfs01() {
//		 que = new ArrayDeque<Map<Integer,Integer>>();
//		    distance = new int[nodeCnt];
//		    Arrays.fill(distance, -1);
//		   HashMap<Integer, Integer> 
//		    que.push(new HashMap<Integer, Integer>());
//		    distance[firstNode] = 0;
//		    confirmed[firstNode] = true;
//		    while(!que.isEmpty()){
//		        int start = que.pop();
//		        for(int x: path.get(start)) { 
//		        	if(distance[x] == -1) {
//			            distance[x] = distance[start] + 1;
//			            que.push(x);
//		        	}
//		        }
//		    }
//	 }
}


