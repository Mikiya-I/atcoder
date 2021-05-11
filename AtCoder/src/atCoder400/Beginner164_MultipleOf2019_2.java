package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner164_MultipleOf2019_2 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] S = reader.readLine().toCharArray();
		int[] mods2019 = new int[2019];
		mods2019[0] ++;
		long ans = 0;
		int mod = 0;
		int pow =1;
		for(int i=0;i<S.length;i++) {
			//桁が増えると時間が掛かる
//			mod += powMod((S[S.length-1-i]-'0'),10,i,2019);
			mod += (S[S.length-1-i]-'0') * pow;
			mod%= 2019;
			mods2019[mod]++;
			pow *=10;
			pow %= 2019;
		}
		
		for(int c : mods2019) {
			ans += c*(c-1)/2;
		}
		return ans;
	}
	
//	public static int powMod(int x,int base, int pow, int mod) {
//		for(int i=0;i<pow;i++) {
//			x*=base;
//			x %= mod;
//		}
//		return x;
//	}
}
