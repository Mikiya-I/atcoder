package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q048 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final long K = Integer.parseInt(strs[1]);
//		long[] arrA = new long[N];
//		long[] arrB = new long[N];
//		Map<Long,Integer> mapA  = new TreeMap<Long, Integer>();
//		Map<Long,Integer> mapB = new TreeMap<Long, Integer>();
		long[] arr = new long[N*2];
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			long tmpA = Long.parseLong(strs[0]);
			long tmpB = Long.parseLong(strs[1]);
			arr[i*2]= tmpA - tmpB;
			arr[i*2+1] = tmpB;
		}
		reader.close();
		Arrays.sort(arr);
		
		long ans = 0;
		//満点-部分点、部分点を大きい順に取っていく
		for(int i=0;i<K;i++) {
			ans += arr[arr.length - i -1];
		}
		
		
		return ans;
	}
}
