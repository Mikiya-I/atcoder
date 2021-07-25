package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner211_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		long mod = (long) (1e9+7);
		char[] str = reader.readLine().toCharArray();
		reader.close();
		int[][] dp = new int[str.length][8];
		
	}
}
