
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner231_C {
	static int N,Q;
	static int[] arr,query;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		Q = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		arr= new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arr);
		
		query = new int[Q];
		for(int i=0;i<Q;i++) {
			query[i] = Integer.parseInt(reader.readLine());
		}
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			int idx = binarySearch(arr, query[i]);
			sb.append(N-idx );
			sb.append( " \n");
		}
		
		return sb.toString() ;
	}
	
	static int binarySearch(int[] arr, int x) {
		//left x未満　right x以上
		int left = -1;
		int right = arr.length;
		while(right-left >1) {
			int mid= (left+right)/2;
			if(arr[mid] >=x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		return right;
	 }

}