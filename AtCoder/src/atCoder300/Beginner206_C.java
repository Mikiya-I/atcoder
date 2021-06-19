package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
 
public class Beginner206_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		long[] arr = new long[N];
		HashMap<Long,Integer> map = new HashMap<Long ,Integer>();
		for(int i= 0;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
			if(map.containsKey(arr[i])) {
				map.replace(arr[i],map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		long ans =0;
		for(int i=0;i<N;i++) {
			int cnt = map.get(arr[i])-1;
			map.replace(arr[i], map.get(arr[i])-1);
			ans += (N-i-1)-cnt;
		}
		return ans;
		}
}