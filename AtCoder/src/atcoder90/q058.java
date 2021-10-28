package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		int beforeLoopCnt = 0;
		int x = N;
		while(true) {
			int digits = 0;
			int y=0;
			while(x >= Math.pow(10, digits)) {
				y += x/(Math.pow(10, digits))%10;
				digits++;
			}
			x = (x+y)%100000;
			if(used[x])
				break;
			used[x]=true;
			beforeLoopCnt++;
		}
		
		return 0;
	}
}
