package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q044 {
	public static void main(String[] args) throws IOException {
		slove();
//		System.out.println(slove());
	}
	
	public static void slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int Q = Integer.parseInt(strs[1]);
		
		int[] arr = new int[N];
		int shiftCnt = 0;
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int t = Integer.parseInt(strs[0]);
			int x = Integer.parseInt(strs[1])-1;
			int y = Integer.parseInt(strs[2])-1;
			shiftCnt += (t+1)%2;
			if(t == 1) {
				
			}else {
				
			}
			
		}
	}
}
