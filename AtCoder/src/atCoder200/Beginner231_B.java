package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Beginner231_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		Map<String,Integer> map =  new HashMap<>();
		for(int i=0;i<N;i++) {
			String s = reader.readLine();
			if(!map.containsKey(s)) {
				map.put(s, 1);
			}else {
				map.replace(s, map.get(s)+1);
			}
		}
		
		String ans = "";
		int cnt = 0;
		for(String s: map.keySet()) {
			int tmp =map.get(s);
			if(cnt <tmp) {
				ans = s;
				cnt = tmp;
			}
		}
		System.out.println(ans);
	}
}
