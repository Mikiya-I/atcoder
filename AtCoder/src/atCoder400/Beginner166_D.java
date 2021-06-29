package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner166_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long[]  ans = slove();
		System.out.println(ans[0]+" "+ans[1]);
//		System.out.println(isPrime());
	}
	
	public static long[] slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int X =Integer.parseInt(reader.readLine());
		
		long ans[] = new long[2];
		long a = possibleMax(X);
		long b= a-1;
		while(Math.pow(a, 5)-Math.pow(b, 5) !=X) {
			while(Math.pow(a, 5)-Math.pow(b, 5) <=X) {
				if(Math.pow(a, 5)-Math.pow(b, 5) ==X) {
					ans[0] =  a;
					ans[1] =b;
					return ans;
				}
				b--;
			}
			a--;
			b= a-1;
		}
		ans[0] = a;
		ans[1] =b;
		return ans;
	}
	
	//Xの時の考えられる最大値を計算
	public static long possibleMax(long x) {
		//A^5 - (A-1)^5がxを超えない値
		long left = 0;
		long right =10000;
		while(right - left > 1) {
			long mid = (right+left)/2;
			if(5*Math.pow(mid, 4)-10*Math.pow(mid, 3)+10*Math.pow(mid, 2)-5*mid+1 >x) {
				right = mid;
			}else {
				left = mid;
			}
		}
		return left;
	}
	
}
