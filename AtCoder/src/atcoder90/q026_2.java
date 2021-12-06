package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q026_2 {

	static int N;
	static Map<Integer,Set<Integer>> path ;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb ;
	static ArrayDeque<Integer> que;
	static boolean[] used;
	static boolean[] pattern;
	static int trueCnt;
//	static List<HashSet<Integer>> path;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		path = new HashMap<Integer, Set<Integer>>();
		for(int i=0;i< N-1; i++) {
			String[] strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0])-1;
			int b = Integer.parseInt(strs[1])-1;
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

	static String slove() throws IOException {
		used = new boolean[N];
		pattern = new boolean[N];
		pattern[0] = true;
		trueCnt = 1;
		sb = new StringBuilder();
		que = new ArrayDeque<Integer>();
		que.add(0);
		dfs();
		
		int cnt = 0;
		boolean usePattern = trueCnt >= N/2;
		for(int i=0;i<N;i++) {
			if(pattern[i] == usePattern) {
				sb.append(i+1 + " ");
				cnt++;
				if(cnt == N/2)
					break;
			}
		}
		return sb.toString();
    }
	
	static void dfs() {
		while(que.size() > 0) {
			int point = que.poll();
			used[point] = true;
			for(int tmp : path.get(point)){
				if(used[tmp])
					continue;
				pattern[tmp] = ! pattern[point];
				if(pattern[tmp]) {
					trueCnt++;
				}
				que.add(tmp);
				dfs();
			}
		}
		
	}
}