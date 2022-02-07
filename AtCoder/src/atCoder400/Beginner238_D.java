package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner238_D {
	static int T;
	static long[] a,s;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(reader.readLine());
		a = new long[T];
		s = new long[T];
		for(int i=0;i<T;i++) {
			String[] strs = reader.readLine().split(" ");
			a[i] = Long.parseLong(strs[0]);
			s[i] = Long.parseLong(strs[1]);
		}
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			if(checkOK(a[i], s[i])) {
				sb.append("Yes");
			}else {
				sb.append("No");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	static boolean checkOK(long a,long s) {
		if(2*a > s)
			return false;
		long remain = s -a*2;
//		long a2 = 2*a;
		return (remain&a) == 0;
		
	}
	
	

}