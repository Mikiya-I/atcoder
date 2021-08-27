package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q044 {
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
		
		int[] arr = new int[N];
		strs= reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
		}
		int shiftCnt = 0;
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int t = Integer.parseInt(strs[0]);
			int x = Integer.parseInt(strs[1])-1;
			int y = Integer.parseInt(strs[2])-1;
//			int tmpX = arr[calcIdx(N, x, shiftCnt)];
//			int tmpY =arr[ calcIdx(N, y, shiftCnt)];
			shiftCnt += (t+1)%2;
			if(t == 1) {
				int tmp = arr[calcIdx(N, x, shiftCnt)];
				arr[calcIdx(N, x, shiftCnt)] = arr[calcIdx(N, y, shiftCnt)];
				arr[calcIdx(N, y, shiftCnt)]= tmp;
			}else if(t==3) {
				sb.append(arr[calcIdx(N, x, shiftCnt)]);
				sb.append("\n");
			}
		}
		return sb.toString();
	}
	
	private static int calcIdx(int N,int x,int shiftCnt) {
		if(shiftCnt > x)
			return N-(x-shiftCnt)*-1%N;
		else
			return (x-shiftCnt)%N;
	}
}
