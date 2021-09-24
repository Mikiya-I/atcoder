package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q003 {
	static List<Integer>[] path;
	static int N;
	static boolean[] used ;
	static ArrayDeque<Integer> que;
	static int tmp;
	static int maxDepth;
	static int farest;
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		String[] strs ;
		used = new boolean[N];
		path = new ArrayList[N];
		for(int i=0;i<N;i++) {
			path[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<N-1 ;i++) {
			strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0])-1;
			int b = Integer.parseInt(strs[1])-1;
			path[a].add(b);
			path[b].add(a);
		}
		que = new ArrayDeque<Integer>();
		que.add(0);
		dfs();
		que.add(farest);
		Arrays.fill(used, false);
		dfs();
		
		return maxDepth+1;
	}
	
	private static void dfs() {
		while(que.size() > 0) {
			tmp++;
			int x = que.pop();
			used[x] = true;
			for(int point : path[x]) {
				if(!used[point]) {
					que.add(point);
					dfs();
					if(tmp > maxDepth) {
						maxDepth=tmp;
						farest = point;
					}
				}
			}
			tmp--;
		}
		
		
	}
}
