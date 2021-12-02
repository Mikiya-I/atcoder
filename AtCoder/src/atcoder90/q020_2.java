package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q020_2 {

	static long a,b,c;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	static List<HashSet<Integer>> path;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		String[] strs = reader.readLine().split(" ");
		a = Long.parseLong(strs[0]);
		b = Long.parseLong(strs[1]);
		c = Long.parseLong(strs[2]);
	}

	static String slove() throws IOException {
		long tmp = 1;
		for(int i=0;i<b;i++) {
			if(a / c < tmp)
				return "Yes";
			tmp *=c;
		}
		return "No";
    }
	
}