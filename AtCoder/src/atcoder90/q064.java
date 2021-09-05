package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q064 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int Q = Integer.parseInt(strs[1]);
		long[] arr = new long[N+1];
		long[] difference = new long[N+1];
		strs= reader.readLine().split(" ");
		arr[0] = Integer.parseInt(strs[0]);
		long defTotal = 0;
		for(int i=1;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
			difference[i] =arr[i] -arr[i-1];
			defTotal += Math.abs( difference[i]);
		}
		
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int left = Integer.parseInt(strs[0])-1;
			int right = Integer.parseInt(strs[1])-1;
			int v = Integer.parseInt(strs[2]);
			long before = Math.abs(difference[left])+ Math.abs(difference[right+1]);
			if(left != 0) {
				difference[left] += v;
			}
			if(right != N-1) {
				difference[right+1] -= v;
			}
			long after =  Math.abs(difference[left])+ Math.abs(difference[right+1]);
			defTotal += after- before;
			sb.append(defTotal);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
