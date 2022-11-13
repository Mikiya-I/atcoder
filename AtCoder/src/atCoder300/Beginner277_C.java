
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Beginner277_C {
	static int N;
	static int[] p;
	static HashMap<Integer,Set<Integer>> path;
	static ArrayDeque<Integer> que ;
	static HashSet<Integer> used;
	static long max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		path = new HashMap<Integer, Set<Integer>>();
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			if(!path.containsKey(a)) {
				path.put(a, new HashSet<Integer>());
			}
			if(!path.containsKey(b)) {
				path.put(b, new HashSet<Integer>());
			}
			path.get(a).add(b);
			path.get(b).add(a);
		}
	}

	public static long slove() throws IOException {
		max = 1;
		used = new HashSet<Integer>();
		que = new ArrayDeque<Integer>();
		que.add(1);
		if(path.get(1) != null)
			dfs();
		return max;
	}
	
	
	static void dfs() {
		while(que.size()>0) {
			int tmp=que.pop();
			used.add(tmp);
			for(int i: path.get(tmp)) {
				if(!used.contains(i)) {
					que.add(i);
					max = Math.max(max, i);
					dfs();
				}
			}
		}
	}
}