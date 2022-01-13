package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q064_2 {
	
	static long[] arr;
	static int N,Q;
	static int[]l,r;
	static long[] v;
	public static void main(String[] args) throws IOException {
//		slove();
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		Q = Integer.parseInt(strs[1]);
		arr = new long[N];
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
		}
		l = new int[Q];
		r = new int[Q];
		v = new long[Q];
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			l[i]= Integer.parseInt(strs[0])-1;
			r[i] = Integer.parseInt(strs[1])-1;
			v[i] = Integer.parseInt(strs[2]);
		}
	}
	
	public static String slove() throws  IOException {
		StringBuilder sb = new  StringBuilder();
		long ans = 0;
		//diff[i] = arr[i] - arr[i-1]
		long[] diff = new long[N];
		for(int i=1;i<N;i++) {
			long tmp = arr[i]-arr[i-1];
			ans += Math.abs(tmp);
			diff[i] = tmp;
		}
		for(int i=0;i<Q;i++) {
			int leftidx = l[i];
			int rightidx = r[i];
			if(leftidx>0) {
				ans -= Math.abs(diff[leftidx]);
				diff[leftidx] += v[i];
				ans += Math.abs(diff[leftidx]);
			}
			if(rightidx<N-1) {
				ans -= Math.abs(diff[rightidx+1]);
				diff[rightidx +1 ] -= v[i];
				ans += Math.abs(diff[rightidx+1]);
			}
			sb.append(ans);
			sb.append("\n");
		}
		return sb.toString();
	}
}
