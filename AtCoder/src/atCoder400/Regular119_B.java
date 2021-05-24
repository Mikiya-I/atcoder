package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Regular119_B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		final String S = reader.readLine();
		final String T = reader.readLine();
		reader.close();
		
		if(S.equals(T)) {
			return 0;
		}
		char[] s = S.toCharArray();
		char[] t = T.toCharArray();
		boolean[] needChange = new boolean[N];
		//↓1の数(合わなければ無理)
		int sCnt = 0;
		int tCnt =0;
		int[] s0 = new int[N];
		int [] t0 = new int[N];
		for(int i=0;i<N;i++) {
			if(s[i]=='0') {
				s0[sCnt] = i;
				sCnt++;
			}
			if(t[i]=='0') {
				t0[tCnt] = i;
				tCnt++;
			}
		}
		//tとsの0,1の数が合わなければ無理
		if(tCnt!= sCnt) {
			return -1;
		}
		
		long ans=0;
		for(int i=0;i<sCnt;i++) {
			if(s0[i] != t0[i]) {
				ans++;
			}
		}
		//後ろから
//		for(int i=lastIndex;i>firstIndex;i--) {
//			if(s[i] !=t[i]) {
//				int j= i-1;
//				if(s[i] == '1') {
//					while(s[i] == s[j] && s[j] == t[j]) {
//						j--;
//					}
//					ans++;
//				}else {
//					while(s[i] != s[j]) {
//						j--;
//					}
//					ans += i-j;
//				}
//				char tmp = s[i];
//				s[i] = s[j];
//				s[j] = tmp;
//			}
//		}
		
		return ans;
	}
}
