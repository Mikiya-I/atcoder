package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Beginner203_C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int  N = Integer.parseInt(strs[0]);
		long  K = Long.parseLong(strs[1]);
		Map<Long,Long> map = new HashMap<Long,Long>();
		long[] points = new long[N];
		
		for(int i= 0;i<N;i++) {
			strs = reader.readLine().split(" ");
			long point = Long .parseLong(strs[0]);
			long value = Long.parseLong(strs[1]);
			if(map.containsKey(point)) {
				map.replace(point, map.get(point) + value);
			}else {
				map.put(point, value);
				points[i] = point;
			}
		}
		
		Arrays.sort(points);
//		long ans = 0;
//		for (Long key : map.keySet()) {
//			if(K + ans >= key) {
//				K += map.get(key);
//				K -= key-ans;
//				ans += key-ans;
//			}else {
//				ans += K;
//				K =0;
//				break;
//			}
//		}
		for(long current:points) {
			if(current ==0)
				continue;
			if(K >=current) {
				K+= map.get(current);
			}else {
				break;
			}
		}
		
		return K;
	}
	
}
