package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q048_2 {
	
	static int K,N;
	static long[] arr;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
//		 slove();
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		arr = new long[N*2];
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			long tmpA = Long.parseLong(strs[0]);
			long tmpB = Long.parseLong(strs[1]);
			arr[i*2]= tmpA - tmpB;
			arr[i*2+1] = tmpB;
		}
		reader.close();
		Arrays.sort(arr);
	}

	static long slove() throws IOException {
		long ans = 0;
		//満点-部分点、部分点を大きい順に取っていく
		for(int i=0;i<K;i++) {
			ans += arr[arr.length - i -1];
		}
		return ans;
	}
	
}