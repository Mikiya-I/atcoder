package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
 
public class Beginner210_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		int[] sum = new int[N+1];
		strs = reader.readLine().split(" ");
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		for(int i=0;i<K;i++) {
			int tmp = Integer.parseInt(strs[i]);
			if(map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp)+1);
				//計算上+1
				sum[i+1]=sum[i];
			}else {
				map.put(tmp, 1);
//				que.add(tmp);
				//計算上の都合で+1
				sum[i+1]=sum[i]+1;
			}
		}
//		long ans = que.size();
		long ans = sum[K];
		for(int i=K;i<N;i++) {
			int removeNum = Integer.parseInt(strs[i-K]);
			int addNum = Integer.parseInt(strs[i]);
			int tmp = sum[i];
			if(map.containsKey(addNum)) {
				map.put(addNum, map.get(addNum)+1);
			}else {
				map.put(addNum, 1);
//				que.add(tmp);
				tmp++;
			}
			if(map.get(removeNum)==1) {
				tmp--;
				map.remove(removeNum);
			}else {
				map.put(removeNum, map.get(removeNum)-1);
			}
			ans = Math.max(ans, tmp);
			sum[i+1]=tmp;
		}
		return ans;
	}
}
