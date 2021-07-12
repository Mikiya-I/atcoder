package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Beginner209_D {
	static int[][] shortestDistance;
	static boolean[][] findRoot;
	static boolean[] used;
	static ArrayList<ArrayList<Integer>> path;
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int Q = Integer.parseInt(strs[1]);
//		boolean[][] path = new boolean[N+1][N+1];
		path = new ArrayList<ArrayList<Integer>>();
		shortestDistance = new int[N+1][N+1];
		findRoot = new boolean[N+1][N+1];
		used = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			path.add(new ArrayList<Integer>());
		}
		for(int i=0;i<N-1;i++) {
			strs= reader.readLine().split(" ");
			path.get(Integer.parseInt(strs[0])).add(Integer.parseInt(strs[1]));
			path.get(Integer.parseInt(strs[1])).add(Integer.parseInt(strs[0]));
		}
//		return ans;
		return "";
	}
	
	public static void bfs209(int start,int end,int index) {
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		used[start]= true;
		for(int i: path.get(start)) {
			if(!used[i]) {
				shortestDistance[start][i]++;
				findRoot[start][i]=true;
				que.add(i);
				if(i==end) {
					shortestDistance[start][end]=index;
					findRoot[start][end]=true;
					return;
				}
			}
			while(que.size() >0) {
				bfs209(que.pop(),end,index+1);
			}
			return ;
		}
	}
}
