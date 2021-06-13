package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner205_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int A = Integer.parseInt(strs[0]);
		final int B = Integer.parseInt(strs[1]);
		final int C = Integer.parseInt(strs[2]);
		int absA = Math.abs(A);
		int absB = Math.abs(B);
		
		if(A==B) {
			return "=";
		}
		if(C%2==1) {
			if(A<0 && B < 0) {
				return absA >absB?"<":">";
			}else if(A>B) {
				return ">";
			}else if(A<B) {
				return "<";
			}
		}else {
			if(absA == absB) {
				return "=";
			}else {
				return absA > absB ? ">":"<";
			}
		}
		
		return "";
		}
}