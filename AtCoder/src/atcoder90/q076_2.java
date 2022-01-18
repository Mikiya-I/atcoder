package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class q076_2 {
	static int N;
	static int[] arr;
	static long total;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = new int[N];
		total = 0;
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(strs[i]);
			arr[i] = tmp;
			total += tmp;
		}
		reader.close();
	}
	
	public static String slove() throws  IOException {
		if(total%10 != 0)
			return "No";
		//尺取り
		ArrayDeque<Integer> que  = new ArrayDeque<Integer>();
		long sum = 0;
		int idx = 0;
		for(int i=0;i<N;i++) {
			while(sum < total/10) {
				//円状になっているため周回できるようにする
				sum += arr[idx % N];
				que.add(arr[idx % N]);
				idx++;
			}
			if(sum == total/10) {
				return "Yes";
			}
			sum -= que.poll();
		}
		return "No";
		
	}
	
}
