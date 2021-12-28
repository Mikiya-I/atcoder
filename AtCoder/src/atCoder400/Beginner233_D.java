package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Beginner233_D {
	static int N;
	static long K;
	static long[] A;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
//				slove();
		input();
		System.out.println(slove());
	}
	
	
	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		K = Long.parseLong(strs[1]);
		A = new long[N];
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			A[i] = Long.parseLong(strs[i]);
		}
		
		reader.close();
	}
	
	public static int slove() throws IOException {
		long[] sums = new long[N+1];
		HashMap<Long,Integer> map = new  HashMap<Long, Integer>();
		//初期値(最初)
		map.put((long) 0, 1);
		for(int i=1;i<N;i++) {
			long tmp = A[i-1]+sums[i-1];
			sums[i] = tmp;
			if(!map.containsKey(tmp)) {
				map.put(tmp, 0);
			}
			map.replace(tmp, map.get(tmp)+1);
		}
		
		for(int i=0;i<N+1;i++) {
			long tmp = sums[i];
			map.replace(tmp, map.get(tmp)-1);
			if(map.containsKey(K+tmp)) {
				ans += map.get(K-tmp);
			}
		}
		
		return ans;
	}
	
}

