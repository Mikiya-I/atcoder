package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Beginner234_D {
	static int N,K;
	static int[] P;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//				slove();
		input();
		System.out.println(slove2());
	}

	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		P = new int[N];
		strs = reader.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(strs[i]);
		}
		reader.close();
	}

	public static String slove2() throws IOException {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
//		int[] tmpArr = new int[K];
		for(int i=0;i<K;i++) {
//			tmpArr[i] = P[i];
			que.add(P[i]);
		}
		int tmpNum =que.poll();
		sb.append(tmpNum);
		sb.append("\n");
		for(int i=K;i<N;i++) {
			if(tmpNum<P[i]) {
				que.add(P[i]);
				tmpNum = que.poll();
			}
			
			sb.append(tmpNum);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		List<Integer> list  = new ArrayList<Integer>();
		for(int i=0;i<K;i++) {
			list.add(P[i]);
		}
		Collections.sort(list);
		sb.append(list.get(list.size()-K));
		sb.append("\n");
		for(int i=K;i<N;i++) {
			int idx = binarySearch(list, P[i]);
			list.add(idx,P[i]);
			sb.append(list.get(list.size()-K));
			sb.append("\n");
		}
		return sb.toString();
	}
	
	static int binarySearch(List<Integer> list, int x) {
		//left x未満　right x以上
		int left = -1;
		int right = list.size();
		while(right-left >1) {
			int mid= (left+right)/2;
			if(list.get(mid) >=x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		return right;
	 }
}
