package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beginner225_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
				slove();
//		System.out.println(slove2());
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int Q = Integer.parseInt(strs[1]);
		
		SimpleUF uf = new SimpleUF(N);
		
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			if(strs.length == 2) {
//				sb.append(uf.createLine(Integer.parseInt(strs[1])));
//				sb.append("\n");
				uf.showLine(Integer.parseInt(strs[1]));
			}else if(strs[0].equals("1")) {
				uf.joint(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
			}else {
				uf.divide(Integer.parseInt(strs[1]), Integer.parseInt(strs[2]));
			}
		}
		
		System.out.println(sb.toString());
	}
}

class SimpleUF{
	int[] parent;
//	int[] root;
	int[] next;
	
	public SimpleUF( int N) {
		parent = new int[N+1];
//		root = new int[N+1];
		next = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
//			root[i] = i;
			next[i] = i;
		}
	}
	
	void joint(int first,int second) {
//		parent[second] = parent[first];
//		next[first] = second;
//		root[second] = root[second];
		int x = first;
        int y = second;
        next[x] = y;
        parent[y] = x;
	}
	
	void divide(int first,int second) {
//		parent[second] = second;
//		next[first] = first;
		int x = first;
        int y = second;
        next[x] = x;
        parent[y] = y;
	}
	
	void showLine(int x) {
//		StringBuilder sb = new StringBuilder();
//		int current = parent[x];
//		while(parent[current] != current) {
//			current = parent[current];
//		}
//		int cnt = 1;
//		sb.append(current +" ");
//		while(next[current] != current) {
//			current = next[current];
//			sb.append(current +" ");
//			cnt++;
//		}
//		System.out.println(cnt + " " + sb.toString());
		List<Integer> ans = new ArrayList<>();
        while(parent[x] != x) {
            x = parent[x];
        }
        ans.add(x);
        while(next[x] != x) {
            x = next[x];
            ans.add(x);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size());
        for(int a : ans) {
            sb.append(" ");
            sb.append(a);
        }
        System.out.println(sb);
	}
}

