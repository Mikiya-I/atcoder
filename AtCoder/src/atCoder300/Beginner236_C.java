
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Beginner236_C {
	static int N,M;
	static String[] s;
	static HashSet<String> t;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		s = reader.readLine().split(" ");
		t = new HashSet<String>();
		strs = reader.readLine().split(" ");
		for(int i=0;i<M;i++) {
			t.add(strs[i]);
		}
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			if(t.contains(s[i])) {
				sb.append("Yes");
			}else {
				sb.append("No");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	

}