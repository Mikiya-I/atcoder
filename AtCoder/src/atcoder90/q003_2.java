package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class q003_2 {
	static HashMap<Integer,HashSet<Integer>> path;
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
		path = new HashMap<Integer, HashSet<Integer>>();
		used = new boolean[N+1];
		//グラフ構築
		for(int i=0;i<N-1;i++) {
			strs = reader.readLine().split(" ");
			int A = Integer.parseInt(strs[0]);
			int B = Integer.parseInt(strs[1]);
			
			if(!path.containsKey(A)) {
				path.put(A, new HashSet<Integer>());
			}
			path.get(A).add(B);
			
			if(!path.containsKey(B)) {
				path.put(B, new HashSet<Integer>());
			}
			path.get(B).add(A);
		}
		
		//任意のノードから一番遠いノードを調べる
		que = new ArrayDeque<Integer>();
		que.add(1);
		//何回道を通ったか
		tmp = -1;
		maxDepth =0;
		farest = -1;
		dfs();
		//調べたノードから一番遠いノードを調べる
		que.add(farest);
		maxDepth = 0;
		dfs();
		
		return maxDepth+1;
	}
	
	private static void dfs() {
		while(que.size()>0) {
			int tmpNode = que.poll();
			tmp++;
			used[tmpNode] = true;
			if(maxDepth < tmp) {
				maxDepth = tmp;
				farest = tmpNode;
			}
			for(int i:path.get(tmpNode)) {
				if(used[tmpNode])
					continue;
				que.add(i);
				dfs();
			}
			used[tmpNode] = false;
			tmp--;
		}
	}
	
	private static void dfs2() {
		while(que.size() > 0) {
			tmp++;
			int x = que.pop();
			used[x] = true;
			for(int point : path.get(x)) {
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
