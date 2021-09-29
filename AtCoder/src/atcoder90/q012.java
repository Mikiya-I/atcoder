package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class q012 {
//	static ArrayList<ArrayList<Integer>> path;
	static boolean[] used;
	static ArrayDeque<Integer> que;
	static int H;
	static int W;
	static boolean[][] grid;
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		H = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
	
		grid = new boolean[H+2][W+2];
		used = new boolean[ (H+2) * (W+2)  ];
		que = new ArrayDeque<Integer>();
		
		final int Q = Integer.parseInt(reader.readLine());  
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int[] query = new int[strs.length];
			for(int j=0;j<strs.length;j++) {
				query[j] = Integer.parseInt(strs[j]);
			}
			if(query.length==3) {
				grid[query[1]][query[2]]= true;
				Arrays.fill(used, false);
			}else {
				if(!grid[query[1]][query[2]] || ! grid[query[3]][query[4]]) {
					sb.append("No");
				}else {
					que.add((W+2)*query[1]+query[2] );
					if(!bfs( (W+2)*query[3]+query[4] )) {
						sb.append("No");
					}else {
						sb.append("Yes");
					}
			}
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	
	private static boolean bfs(int goal) {
		boolean ok = false;
		 while(que.size() > 0) {
			 int tmp = que.pop();
			 used[tmp] = true;
			 if(tmp == goal)
				 return true;
			 int y = tmp/(W+2);
			 int x = tmp%(W+2);
			 //真上
			 if(!used[tmp-W-2] && grid[y-1][x] )
				 que.add(tmp-W-2);
			 //真下
			 if(!used[tmp+W+2] && grid[y+1][x] )
				 que.add(tmp+W+2);
			 //左
			 if(!used[tmp-1] && grid[y][x-1] )
				 que.add(tmp-1);
			 //右
			 if(!used[tmp+1] && grid[y][x+1] )
				 que.add(tmp+1);
			 ok = bfs(goal);
		 }
		return ok;
	}
}
