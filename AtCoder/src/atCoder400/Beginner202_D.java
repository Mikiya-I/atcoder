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
		//↓二分探索の応用(aとbが同じ数じゃないと無理)
//		long left = -1;
//		long right = calTotal(A+B,A,B)+1;
//		long mid = (left + right) /2;
//		int i= 0;
//		while(B > bCnt && A >aCnt) {
//			if(K > mid) {
//				c[i] ='b';
//				bCnt++;
//				left = mid;
//			}else {
//				c[i] ='a';
//				aCnt++;
//				right  = mid;
//			}
//			mid =  (left + right) /2;
//			i++;
//		}
//		if(B == bCnt) {
//			while(i<A+B) {
//				c[i] ='a';
//				i++;
//			}
//		}else {
//			while(i<A+B) {
//				c[i] ='b';
//				i++;
//			}
//		}
		int i = 0;
		while(B > bCnt && A >aCnt) {
			//通り数
			long total = calTotal(A-aCnt+B-bCnt,A-aCnt,B-bCnt);
			//先頭文字がaである通りの数
			long pattern = total/(A-aCnt+B-bCnt)*(A-aCnt);
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
	
	//ここの修正
	public static long calTotal(long x,long y,long z) {
		long val =1;
		
		while ( x >1) {
			
			val *= x--;
			if(val %y ==0 && y>1) {
				val /=y;
				y--;
			}
			if(val%z == 0 && z>1) {
				val /= z;
				z--;
			}
		}
		return val;
	}
}
