package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Beginner216_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		HashMap<String,HashSet<String>> map = new HashMap<String, HashSet<String>>();
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			if(!map.containsKey(strs[0]))
				map.put(strs[0], new HashSet<String>());
			if(map.get(strs[0]).contains(strs[1]))
				return "Yes";
			else
				map.get(strs[0]).add(strs[1]);
		}
		
		return "No";
		}
}
