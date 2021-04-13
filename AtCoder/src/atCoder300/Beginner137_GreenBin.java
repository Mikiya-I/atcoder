package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Beginner137_GreenBin {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans =slove();
		System.out.println(ans);
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			char[] c = reader.readLine().toCharArray();
			Arrays.sort(c);
			String str = new String(c);
			Integer tmp = map.get(str);
			if(tmp==null)
				map.put(str, 1);
			else 
				map.put(str, ++tmp);
		}
		long ans =0;
		for(Map.Entry<String, Integer> current:map.entrySet()) {
			if(current.getValue() >1) {
				long cal = current.getValue();
				ans += (cal*--cal)/2;
			}
		}
		
		return ans;
	}
}
