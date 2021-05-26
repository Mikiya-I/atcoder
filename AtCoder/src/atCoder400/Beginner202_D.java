package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner202_D {

	public static void main(String[] args) throws IOException {
		
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] strs = reader.readLine().split(" ");
		final long A = Integer.parseInt(strs[0]);
		final long B = Integer.parseInt(strs[1]);
		long K = Long.parseLong(strs[2]);
		
		int bCnt =0;
		int aCnt =0;
		char[] c = new char[(int) (A+B)];

		int i = 0;
		while(B > bCnt && A >aCnt) {
			//通り数
			long total = calTotal(A-aCnt+B-bCnt,A-aCnt,B-bCnt);
			//先頭文字がaである通りの数
			long pattern = total*(A-aCnt)/(A-aCnt+B-bCnt);
			if(K > pattern) {
				c[i] ='b';
				bCnt++;
				K -= pattern;
			}else {
				c[i] ='a';
				aCnt++;
			}
			i++;
		}
		if(B == bCnt) {
			while(i<A+B) {
				c[i] ='a';
				i++;
			}
		}else {
			while(i<A+B) {
				c[i] ='b';
				i++;
			}
		}
		
		return new String(c);
	}
	
	public static long calTotal(long x,long y,long z) {
		long val =1;
		long max = Math.max(y, z);
		long min = Math.min(y, z);
		long start = max+1;
		long divide = 2;
		while ( x >= start) {
			val *= start++;
			if(val%divide == 0 && divide<=min) {
				val /= divide++;
			}
		}
		return val;
	}
}
