package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner216_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(reader.readLine());
//		if(N<=120) {
//			for(int i=0;i<N;i++) {
//				sb.append("A");
//			}
//		}else {
			while(N>0) {
				if(N%2 == 0) {
					N/=2;
					sb.append("B");
				}else {
					N -= 1;
					sb.append("A");
				}
			}
//		}
		String ans = sb.reverse().toString();
		
		
		return ans;
		}
}
