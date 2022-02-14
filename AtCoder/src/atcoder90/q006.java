package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q006 {
	static int N,K;
	static String s;
	public static void main(String[] args) throws IOException {
//		slove();
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		s = reader.readLine();
		reader.close();
	}
	public static String slove() throws  IOException {
		char[] arr = s.toCharArray();
		char[] ans = new char[K];
//		PriorityQueue<Character> que = new PriorityQueue<Character>();
		int tmpIdx = 0;
		for(int i= 0;i<K;i++) {
			char tmp = '}';
			for(int j=tmpIdx;j<N-(K-i)+1;j++) {
				if(arr[j] < tmp) {
					tmp =arr[j];
					tmpIdx = j;
				}
			}
			ans[i] = arr[tmpIdx];
			tmpIdx++;
		}
		return new String(ans);
	}
}
