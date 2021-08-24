package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q020 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long a = Long.parseLong(strs[0]);
		long b = Long.parseLong(strs[1]);
		long c= Long.parseLong(strs[2]);
		
		long tmp = 1;
		for(int i=0;i<b;i++) {
			if(a/c< tmp  ) {
				return "Yes";
			}
			tmp*= c;
		}
		return "No";
	}
}
