package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class q028 {
	
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		final int N = Integer.parseInt(reader.readLine());
		TreeMap<Integer,TreeMap<Integer,Integer>>  event = new TreeMap<Integer, TreeMap<Integer, Integer>>();
		
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int x1 = Integer.parseInt(strs[i]);
			int y1 = Integer.parseInt(strs[i]);
			int x2 = Integer.parseInt(strs[i]);
			int y2 = Integer.parseInt(strs[i]);
			if(!event.containsKey(y1)) {
				event.put(y1,new TreeMap<Integer,Integer>());
			}
			if(!event.get(y1).containsKey(x1)) {
				event.get(y1).put(x1, 1);
			}else {
//				event.get(y1).put(x1, event.get(strs));
			}
		}
		
		return sb.toString();
	}
}
