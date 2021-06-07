package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner204_C{
	static long ans =0;
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		slove();
		System.out.println(ans);
	}
 
	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		boolean[][] root = new boolean[N+1][N+1];
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int start = Integer.parseInt(strs[0]);
			int goal = Integer.parseInt(strs[1]);
			root[start][goal]= true;
		}
		for(int i=1;i<=N;i++) {
			root[i][i]=true;
		}
//		for(int i=1;i<=N;i++) {
//			boolean[] used = new boolean[N+1];
//			for(int j=1;j<=N;j++) {
//				if(root[i][j])
//			}
//		}
//		dfs(1,1,root,used);
//		return 1;
			for(int i=1;i<=N;i++) {
				boolean[]used = new boolean[N+1];
				dfs(i,root,used);
			}
	}
	
 
	//深さ優先探索
		static void dfs(int point,boolean[][] edge,boolean[] used) {
			//現在の頂点から繋がっている点を探す
			for(int i= 1,length = edge.length; i<length;i++) {
				//現在の頂点から線が繋がっていて使っていない頂点で再起呼び出し、該当する頂点が無ければ再起元に戻る
				if(edge[point][i]  && !used[i]) {
					ans++;
					used[point] = true;
					dfs(i,edge,used);
				}
			}
		}
		
		
	
}