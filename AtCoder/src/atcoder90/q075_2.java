package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q075_2 {
	static long N;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(reader.readLine());
		reader.close();
	}
	
	public static int slove() throws  IOException {
		long origin = N;
		//xのn乗
		HashMap<Long,Integer> map = new HashMap<Long, Integer>();
		int loop = (int) Math.sqrt(N);
		for(int i=2;i<=loop;i++) {
			//iで割り切れなくなるまで
			if(N%i==0) {
				int cnt = 0;
				while(N%i ==0) {
					N/=i;
					cnt++;
				}
				map.put((long) i, cnt);
			}
		}
		//残った数は素数or1
		if(N == origin)
			return 0;
		else if ( N != 1)
			map.put(N, 1);
			
		int sum = 0;
//		int maxIdx = 0;
		for(Long key: map.keySet()) {
			sum += map.get(key);
//			maxIdx  = Math.max(maxIdx, map.get(key));
		}
		int ans = 1;
		long idx = 2;
		while(idx < sum) {
			idx *= 2;
			ans ++;
		}
		return ans;
	}
	
}
