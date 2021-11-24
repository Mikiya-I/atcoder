package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q007_2 {

	static int[] arr,B;
	static int N,Q;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		arr = new int[N];
		for(int i = 0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		
		Q = Integer.parseInt(reader.readLine());
		B = new int[Q];
		for(int i=0;i<Q;i++)
			B[i] = Integer.parseInt(reader.readLine());
		reader.close();
	}

	static String slove() {
		StringBuilder sb = new StringBuilder();
		//計算短縮用
		int max = arr[N-1];
		int min = arr[0];
		//二分探索で一番近い値を求める
		for(int i=0;i<Q;i++) {
			int tmp = B[i];
			if(B[i] <= min)
				sb.append(min - tmp);
			else if(B[i] >= max)
				sb.append(tmp -max );
			else {
				sb.append(binary(tmp));
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	private static int binary(int x) {
		int left = -1;
		int right = N;
		while(right - left >1) {
			int mid = (right + left)/2;
			if(arr[mid] >= x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		
		return Math.min(x - arr[left] ,  arr[right] -x );
	}
}
