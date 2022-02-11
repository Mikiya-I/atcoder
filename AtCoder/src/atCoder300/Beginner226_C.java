package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Beginner226_C {
	static long[] T;
	static int N;
	static int[][] conditions;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();
		slove();
//		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		T = new long[N];
		conditions = new int[N][];
		for(int i=0;i<N;i++) {
			String strs[] = reader.readLine().split(" ");
			T[i] =  Long.parseLong(strs[0]);
			int K = Integer.parseInt(strs[1]);
			int[] a = new int[K];
			for(int j=0;j<K;j++) {
				a[j] = Integer.parseInt(strs[2+j])-1;
			}
			conditions[i] = a;
		}
		reader.close();
	}

	public static void slove() throws IOException {
		long ans = 0;
		long ans2 =0;
		HashSet<Integer> set = new HashSet<Integer>();
		//Nの条件の習得をqueに入れる→入れたものの条件の習得をqueに入れるの繰り返し
		ArrayDeque<Integer>  que = new ArrayDeque<Integer>();
		boolean[] used = new boolean[N];
		int[] cnt = new int[N];
		set.add(N-1);
		used[N-1] = true;
		que.add(N-1);
//		for(int i:conditions[N-1]) {
//			que.add(i);
//			set.add(i);
//			used[i] = true;
//		}
		while(que.size()>0) {
			int tmp = que.poll();
			cnt[tmp]++;
			used[tmp] = true;
			ans += T[tmp];
			for(int i:conditions[tmp]) {
				if(used[i])
					continue;
				que.add(i);
				used[i] = true;
				set.add(i);
			}
		}
		
//		ans += T[N-1];
		for(int i:set) {
			ans2 += T[i];
		}
//		return ans;
		System.out.println("ans = "+ ans);
		System.out.println("ans2= " +ans2);
		
		for(int i=0;i<N;i++) {
			if(cnt[i]==2)
				System.out.println(i +":2つ");
			if(cnt[i] != 0 && !set.contains(i))
				System.out.println(i + ":無");
		}
	}

}
