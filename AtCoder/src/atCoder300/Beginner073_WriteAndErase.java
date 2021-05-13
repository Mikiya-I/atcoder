package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class Beginner073_WriteAndErase {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long ans = slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(int i= 0;i<N;i++) {
			int tmp = Integer.parseInt(reader.readLine());
			if(map.containsKey(tmp)) {
				map.replace(tmp, map.get(tmp)+1);
			}else {
				map.put(tmp, 1);
			}
		}
		
		long ans = 0;
		for(Entry<Integer, Integer> set : map.entrySet()) {
			ans += set.getValue() %2 ;
		}
		
		return ans ;
	}
}
