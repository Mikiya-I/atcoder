package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Beginner235_D {
	static int N,a,possibleMax;
	static int[] cnt;
	static boolean[] used;
	static ArrayDeque<pair> que;
	int depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		a = Integer.parseInt(strs[0]);
		N = Integer.parseInt(strs[1]);
		reader.close();
	}

	public static int slove() throws IOException {
		possibleMax = (int) Math.pow(10, (int)Math.log10(N)+1);
		used = new boolean[possibleMax];
		cnt = new int[possibleMax];
		Arrays.fill(cnt, -1);
		cnt[1] = 0;
		used[1] = true;
		que =  new ArrayDeque<pair>();
		que.add(new pair(1,0));
		bfs();
		
		return cnt[N];
	}
	
	static long method1(long x) {
		return x*a;
	}
	
	static long method2(long x) {
		long num =  x%10;
		x/= 10;
		int digit = 10;
		while(digit <= x) {
			digit *=10;
		}
		x += digit * num;
		return x;
	}
	
	//xに対し、操作1,2で行けるかをbfsで探索
	static void bfs() {
		while(que.size()>0) {
			pair tmp = que.poll();
			long m1 = method1(tmp.num);
			if(m1 < possibleMax && !used[(int) m1]) {
				used[(int) m1] = true;
				cnt[(int) m1] = tmp.cnt+1;
				que.add(new pair(m1,tmp.cnt+1));
			}
			if(tmp.num%10 != 0) {
				long m2 = method2(tmp.num);
				if(m2 < possibleMax && !used[(int) m2]) {
					used[(int) m2] = true;
					cnt[(int) m2] = tmp.cnt+1;
					que.add(new pair(m2,tmp.cnt+1));
				}
			}
		}
	}
	
	static class pair{
		int  cnt;
		long num;
		public pair(long num,int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}