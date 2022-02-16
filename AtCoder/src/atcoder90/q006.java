package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
	
	static String slove2() {
		char[] arr = s.toCharArray();
		char[] ans = new char[K];
		int[][] minIndex = new int[26][N+1];
		Arrays.fill(minIndex, -1);
		//後ろから埋めていく
		for(int i=N-1;0<=i;i--) {
			int tmpChar = (int)arr[i] - 97;
			for(int j=0;j<26;j++) {
				if(j==tmpChar) {
					minIndex[j][i] = j;
				}else {
					minIndex[j][i] = minIndex[j][i+1];
				}
			}
		}
		return new String(ans);
	}
}
