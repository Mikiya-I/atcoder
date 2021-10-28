package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class q058 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ");
		reader.close();
		final int N = Integer.parseInt(strs[0]);
		final long K = Long.parseLong(strs[1]);
		
		boolean[] used = new boolean[100001];
		int totalCnt= 0;
		ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
		int x = N;
		boolean isLoop=false;
		for(int i=0;i<K;i++){
			int digits = 0;
			int y=0;
			while(x >= Math.pow(10, digits)) {
				y += x/(Math.pow(10, digits))%10;
				digits++;
			}
			x = (x+y)%100000;
			if(used[x]) {
				isLoop = true;
				break;
			}
			used[x]=true;
			totalCnt++;
			nums.add(x);
		}
		
		if(! isLoop) {
			for(int i=0;i<K-1;i++) {
				nums.poll();
			}
			return nums.poll();
		}
		
		int beforeLoopCnt = 0;
		while(x != nums.peek()) {
			nums.poll();
			beforeLoopCnt++;
		}
		long ansIdx = (K-beforeLoopCnt)%(totalCnt-beforeLoopCnt);
		if(ansIdx ==0)
			ansIdx=nums.size();
		for(int i=0;i<ansIdx-1;i++)
			nums.poll();
		
		return nums.poll();
	}
}
