package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Beginner213_D {
	static ArrayList<ArrayList<Integer>> path;
	static boolean[] used;
	static ArrayDeque<Integer> que ;
	
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(reader.readLine());
		path = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) {
			path.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<N-1;i++) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			path.get(a).add(b);
			path.get(b).add(a);
		}
		used = new boolean[N+1];
		que = new ArrayDeque<>();
		que.add(1);
		dfs(que,path,used,sb);
		
		return sb.toString();
	}
	
	private static void dfs(ArrayDeque<Integer> que, ArrayList<ArrayList<Integer>> path,boolean[] used,StringBuilder sb) {
		while(que.size()>0) {
			int tmp = que.pop();
			used[tmp]=true;
			sb.append(tmp +" ");
			Collections.sort(path.get(tmp));
			for(int i:path.get(tmp)) {
				if(!used[i]) {
					que.add(i);
					dfs(que,path, used, sb);
					sb.append(tmp+" ");
				}
			}
//			sb.append(tmp+" ");
		}
	}
}