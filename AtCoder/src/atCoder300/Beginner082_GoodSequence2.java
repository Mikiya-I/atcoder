package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Beginner082_GoodSequence2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		
		String[] strs = reader.readLine().split(" ");
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		//ai <= N なら0に　それ以外ならNまで引く
		for(int i=0;i<N;i++) {
			int current = Integer.parseInt(strs[i]);
			if(map.containsKey(current)) {
				map.merge(current, 1,Integer::sum );
			}else {
				map.put(current, 1);
			}
		}
		
		int ans = 0;
		for(Map.Entry<Integer, Integer>  set:map.entrySet()) {
			if(set.getValue()<set.getKey()) {
				ans += set.getValue();
			}else {
				ans += set.getValue()-set.getKey();
			}
		}
		
		return ans;
	}
}

