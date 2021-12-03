
package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner230_C {
	static long N,A,B,P,Q,R,S;
	static long maxK1,minK1,maxK2,minK2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
//		slove2();
		//		long ans = slove();

		System.out.println(slove());
	}

	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Long.parseLong(strs[0]);
		A = Long.parseLong(strs[1]);
		B = Long.parseLong(strs[2]);
		strs = reader.readLine().split(" ");
		P = Long.parseLong(strs[0]);
		Q = Long.parseLong(strs[1]);
		R = Long.parseLong(strs[2]);
		S = Long.parseLong(strs[3]);
		
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		maxK1 = Math.max(1-A, 1-B);
		minK1 = Math.min(N-A, N-B);
		maxK2 = Math.max(1-A, B-N);
		minK2 = Math.min(N-A, B-1);

		for(long i = P ;i <= Q ;i++) {
			for(long j= R ;j <= S ;j++) {
				if(checkPainted(i, j)) {
					sb.append("#");
				}else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString() ;
	}
	
//	private static  boolean checkPainted(long i,long j) {
////		long max = Math.max(maxK1+A, minK1+A);
////		long min = Math.min(, max)
//		long maxk1 = Math.max(, j)
//		if( (maxK1 + A <= i && i <= minK1 + A) && (maxK1 + B <= j && j <= minK1 + B) ) {
//			return true;
//		}else if ( (maxK2 + A <= i && i <= minK2 + A) && (B-maxK2 <= j && j <= B-minK2) ) {
//			return true;
//		}
//		return false;
//	}
	private static  boolean checkPainted(long i,long j) {
//		long max = Math.max(maxK1+A, minK1+A);
//		long min = Math.min(, max)
		long tmpk = i-A;
		if( (tmpk == j-B ) && (maxK1 <= tmpk && tmpk <= minK1) ) {
			return true;
		}else{
			if( (j+ tmpk == B ) && (maxK2 <= tmpk && tmpk <= minK2) )
				return true;
		}
		return false;
	}

}