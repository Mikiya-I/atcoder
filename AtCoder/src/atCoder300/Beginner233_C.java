
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Beginner233_C {
	static int N;
	static long X;
	static long ans = 0;
	static Map<Long,Integer>[] balls;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		X = Long.parseLong(strs[1]);
		balls = new Map[N];
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			int l = Integer.parseInt(strs[0]);
			HashMap<Long,Integer> map = new HashMap<Long, Integer>();
			for(int j=0;j<l;j++) {
				long a = Long.parseLong(strs[j+1]);
				if(X%a != 0 || X< a)
					continue;
				if(!map.containsKey(a)) {
					map.put(a, 0);
				}
				map.replace(a, map.get(a)+1);
			}
			balls[i] = map;
		}
		reader.close();
	}

	public static long slove() throws IOException {
		ans  = 0;
//		for( long i: balls[0].keySet()) {
//			long tmp = X/i;
//			long cnt = balls[0].get(i);
//			for(int j=1;j<N;j++) {
//				long tmpCnt = 0;
//				
//				for(long k:balls[j].keySet()) {
//					if(tmp % k ==0) {
//						tmpCnt = balls[j].get(k);
//						tmp /= k;
//						break;
//					}
//				}
//				cnt *= tmpCnt;
//				if(cnt ==0) {
//					break;
//				}
//			}
//			if(tmp == 1)
//				ans += cnt;
//		}
		for( long i: balls[0].keySet()) {
			long tmp = X/i;
			long cnt = balls[0].get(i);
			nextValue(1, tmp, cnt);
		}
		
		return ans;
	}
	
	static void nextValue(int idx ,long tmp,long cnt) {
		for( long i: balls[idx].keySet()) {
			if(tmp% i == 0) {
				if(idx == N-1) {
					if(tmp / i == 1)
						ans += cnt * balls[idx].get(i);
				}else {
					nextValue(idx+1, tmp/i, cnt*balls[idx].get(i));
				}
			}
		}
	}
	

}