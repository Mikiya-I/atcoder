
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeMap;

public class Beginner254_C {
	static int N,K;
	static int[] a;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input();
//		System.out.println(slove3());
		for(int i=0;i<10;i++) {
			if(!test())
				break;
		}
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		a = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = Integer.parseInt(strs[i]);
		}
	}

	public static String slove() throws IOException {
//		int[] arr = a.clone();
//		Arrays.sort(arr);
		TreeMap<Integer,HashSet<Integer>> map = new TreeMap<Integer, HashSet<Integer>>();
		for(int i=0;i<N;i++) {
			int tmp = a[i];
			if(!map.containsKey(tmp))
				map.put(tmp, new HashSet<Integer>());
			map.get(tmp).add(i);
		}
		boolean[] used = new boolean[N];
		int tmpIdx = 0;
		for(int key:map.keySet()) {
			int range = map.get(key).size();
			for(int idx:map.get(key)) {
//				あり得る欄を埋める
				int possibleIdx = tmpIdx+(Math.abs(idx - tmpIdx) % K);
				while(possibleIdx< N&& possibleIdx<tmpIdx + range) {
					used[possibleIdx] = true;
					possibleIdx += K;
				}
			}
			tmpIdx += range;
		}
		for(boolean ok:used) {
			if(!ok)
				return "No";
		}
		return "Yes";
	}
	
	static String slove2() {
		TreeMap<Integer,HashSet<Integer>> map = new TreeMap<Integer, HashSet<Integer>>();
		for(int i=0;i<N;i++) {
			int tmp = a[i];
			if(!map.containsKey(tmp))
				map.put(tmp, new HashSet<Integer>());
			map.get(tmp).add(i);
		}
		boolean[] used = new boolean[N];
		int tmpIdx = 0;
		for(int key:map.keySet()) {
			int range = map.get(key).size();
			for(int idx:map.get(key)) {
				int MinpossibleIdx = tmpIdx+(Math.abs(idx - tmpIdx) % K);
				while(MinpossibleIdx<N&&tmpIdx + range<MinpossibleIdx && used[MinpossibleIdx]) {
					MinpossibleIdx += K;
				}
				if(tmpIdx + range<MinpossibleIdx || N<=MinpossibleIdx )
					return "No";
				used[MinpossibleIdx] = true;
			}
			tmpIdx += range;
		}
		
		return "Yes";
	}
	
	static String slove3() {
		int[][] grid = new int[K][N/K+1];
		for(int i=0;i<K;i++)
			Arrays.fill(grid[i], Integer.MAX_VALUE);
		for(int i=0;i<N;i++) {
			int arrIdx = i%K;
			int idx = i/K;
			grid[arrIdx][idx] = a[i];
		}
		for(int i=0;i<K;i++) {
			Arrays.sort(grid[i]);
		}
		int tmpNum = grid[0][0];
		for(int i=0;i<N;i++) {
			int arrIdx = i%K;
			int idx = i/K;
			if(tmpNum> grid[arrIdx][idx])
				return "No";
			tmpNum = grid[arrIdx][idx];
		}
		return "Yes";
	}
	
	static boolean test() {
		Random rand = new  Random();
		N = rand.nextInt(5)+2;
		while(N<2) {
			N = rand.nextInt(5)+2;
		}
		K = rand.nextInt(N-1)+1;
		while(K < 0) {
			K = rand.nextInt(N-2)+1;
		}
		a = new int[N];
		for(int i=0;i<N;i++) {
			a[i] = rand.nextInt(10);
		}
		if (!slove2().equals(slove3())) {
			System.out.println(N+ " " + K);
			for(int i:a)
				System.out.print(i+" ");
			return false;
		}
		return true;
	}
}