package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class Beginner276_B {
	static int N,M;
	static int[] A,B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		A = new int[M];
		B = new int[M];
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			A[i] = Integer.parseInt(strs[0]);
			B[i] = Integer.parseInt(strs[1]);
		}
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>();
		for(int i=0;i<N;i++) {
			TreeSet<Integer> set = new TreeSet<Integer>();
			map.put(i+1, set);
		}
		for(int i=0;i<M;i++) {
			int a = A[i];
			int b = B[i];
			map.get(a).add(b);
			map.get(b).add(a);
		}
		for(int i=0;i<N;i++) {
			TreeSet<Integer> set = map.get(i+1);
			sb.append(set.size() + " ");
			for(int j: set)
				sb.append(j+" ");
			sb.append("\n");
		}
		return sb.toString();
	}

}