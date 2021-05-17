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
		int firstIndex = Integer.MAX_VALUE;
		int lastIndex = 0;
		//下界(ある集合の考えうる最小値=答えは100%この数値以上になる)
		int changeCnt =0;
		for(int i=0;i<N;i++) {
			if(s[i] != t[i]) {
				needChange[i] = true;
				firstIndex = Math.min(i, firstIndex);
				lastIndex = Math.max(lastIndex, i);
				changeCnt ++;
			}
			if(s[i]=='1') {
				sCnt++;
			}
			if((t[i] =='1')) {
				tCnt ++;
			}
		}
		//tとsの0,1の数が合わなければ無理
		if(tCnt!= sCnt) {
			return -1;
		}
		
		long ans=0;
		//先頭から順にそろえていく
//		for(int i=firstIndex;i<lastIndex;i++) {
//			if(s[i] !=t[i]) {
//				if(i==118) {
//					System.out.println();
//				}
//				int j= i+1;
//				if(s[i] == '1') {
//					while(s[i] == s[j] && s[j] == t[j]) {
//						j++;
//					}
//					ans++;
//				}else {
//					while(s[i] != s[j]) {
//						j++;
//					}
//					ans += j-i;
//				}
//				char tmp = s[i];
//				s[i] = s[j];
//				s[j] = tmp;
//			}
//		}
		//後ろから
		for(int i=lastIndex;i>firstIndex;i--) {
			if(s[i] !=t[i]) {
				int j= i-1;
				if(s[i] == '1') {
					while(s[i] == s[j] && s[j] == t[j]) {
						j--;
					}
					ans++;
				}else {
					while(s[i] != s[j]) {
						j--;
					}
					ans += i-j;
				}
				char tmp = s[i];
				s[i] = s[j];
				s[j] = tmp;
			}
		}
		
		return ans;
	}
}
