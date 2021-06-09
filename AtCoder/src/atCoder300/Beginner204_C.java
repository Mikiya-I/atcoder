package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class Beginner204_C{
	static long ans =0;
	static boolean[][] root; 
	static boolean[] used;
	static List<Integer>[] path =null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		slove();
		System.out.println(ans);
	}
 
	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		root = new boolean[N][N];
		path = new ArrayList[N];
		for(int i=0;i<N;i++) {
			path[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int start = Integer.parseInt(strs[0])-1;
			int goal = Integer.parseInt(strs[1])-1;
			root[start][goal]= true;
			path[start].add(goal);
		}
		for(int i=0;i<N;i++) {
			root[i][i]=true;
		}
//			for(int i=0;i<N;i++) {
//				Arrays.fill(used, false);
//					dfs(i,root[i],used);
//				}
//			}
//		for(int i=1;i<=N;i++) {
//			boolean[] used = new boolean[N+1];
//			Deque<Integer> deque = new ArrayDeque<> ();
//			bfs(i,root[i],used);
////			System.out.println();
//		}
		used = new boolean[N];
		for ( int i = 0 ; i < N ; i++ ) {
			Arrays.fill(used, false);
			ans += dfs(i);
		}
	}
 
	//深さ優先探索
		static void dfs(int point,boolean[] edge,boolean[] used) {
			ans++;
			used[point] = true;
			//現在の頂点から繋がっている点を探す
			for(int i= 0; i<edge.length;i++) {
				//現在の頂点から線が繋がっていて使っていない頂点で再起
				if(edge[i] &&! used[i]) {
					dfs(i,root[i],used);
				}
			}
		}
		 
		static int dfs(int pos) {
			//自身はあらかじめ足しておく
			int ret = 1;
			used[pos] = true;
			for ( int next : path[pos] ) {
				if ( !used[next] ) {
					ret += dfs(next);
				}
			}
			return ret;
		}
		
		//幅優先探索
		static void bfs(int point,boolean[] edge,boolean[] used) {
			used[point] = true;
			//現在の頂点から繋がっている点を探す
			for(int i= 1; i<edge.length;i++) {
				//現在の頂点から線が繋がっていて使っていない頂点で再起呼び出し、該当する頂点が無ければ再起元に戻る
				if(edge[i] &&! used[i]) {
					ans++;
				}
			}
		}
}