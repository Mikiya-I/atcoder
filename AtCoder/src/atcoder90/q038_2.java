package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q038_2 {

	static long A,B;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
//		 System.out.println(slove());
		 slove();
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		A = Long.parseLong(strs[0]);
		B = Long.parseLong(strs[1]);
		reader.close();
	}

	static void slove() throws IOException {
		long gcd = gcd(A,B);
		if( (long)1e18/B<A/gcd) {
			System.out.println("Large");
		}else {
			//先に割らないとオーバーフローする
			System.out.println(A/gcd*B);
		}
    }
	
	static long gcd(long x,long y) {
		if(x==0) {
			return y;
		}
		if(y==0) {
			return x;
		}
		long max = Math.max(x, y);
		long min = Math.min(x, y);
		long mod = max%min;
		while(mod>0) {
			max=min;
			min=mod;
			mod=max%min;
		}
		
		return min;
	}
}