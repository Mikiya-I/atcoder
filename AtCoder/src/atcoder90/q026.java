package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class q026 {
	
	static Set<Integer>[] path;
	static ArrayDeque<Integer> que;
	static boolean[] used ;
	//2部グラフ
	static boolean[] pattern;
	static int trueCnt ;
	
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(reader.readLine());
		path = new HashSet[N];
		used = new boolean[N];
		for(int i=0;i<N;i++) {
			path[i] = new HashSet<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			String[] strs = reader.readLine().split(" ");
			int A = Integer.parseInt(strs[0])-1;
			int B = Integer.parseInt(strs[1])-1;
			path[A].add(B);
			path[B].add(A);
		}
		
		pattern = new boolean[N];
		pattern[0] = true;
		que = new ArrayDeque<Integer>();
		que.add(0);
		trueCnt =0;
		dfs();
		
		boolean major = trueCnt >=N/2;
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(pattern[i]  == major) {
				sb.append(i+1);
				sb.append(" ");
				cnt ++;
			}
			if(cnt >= N/2)
				break;
		}
		return sb.toString();
	}
	
	private static void dfs() {
		while(que.size()>0) {
			int tmp = que.pop();
			if(pattern[tmp])
				trueCnt++;
			for(int i:path[tmp]) {
				if(!used[i]) {
					used[i] = true;
					pattern[i] =  ! pattern[tmp];
					que.add(i);
					dfs();
				}
			}
		}
	}
	
}
