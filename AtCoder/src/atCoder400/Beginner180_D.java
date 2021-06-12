package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner180_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long x = Long.parseLong(strs[0]);
		long y = Long.parseLong(strs[1]);
		long  a = Long .parseLong(strs[2]);
		long b = Long.parseLong(strs[3]);
		
		long difference = y-x;
		long ans =0;
		int aCnt = 0;
		long tmpY = y;
		while(tmpY >= a) {
			tmpY /= a;
			aCnt++;
		}
		
		for(int i=aCnt; i>=0;i--) {
			long tmp = i;
			long tmp2 =  (long) (y-x*Math.pow(a, i))-1;
			tmp += tmp2 /b;
			ans = Math.max(ans, tmp);
		}
		ans = Math.max(ans, difference/b);
		return ans;
	}
}
