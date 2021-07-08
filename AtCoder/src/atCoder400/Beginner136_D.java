package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner136_D {
	public static void main(String[] args) throws IOException {
//		slove();
		int[]  ans = slove();
		for(int i:ans) {
			System.out.print(i + " ");
		}
//		System.out.println(ans);
	}
	
	public static int[] slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		char[] s = reader.readLine().toCharArray();
		int[] cntOnSpace = new int[s.length];
		//LRの繰り返しになる前に消費する移動数(Rを基準とする)
		int[] beforeLoopCnt = new int[s.length];
		//前の文字
		char beforeChar =  ' ';
		for(int i=0;i<s.length;i++) {
			if(s[i]=='R') {
				if(beforeChar != 'R') {
					int index = i+1;
					while(s[index] != 'L') {
						index++;
					}
					beforeChar='R';
					beforeLoopCnt[i] = index-i-1;
				}else {
					beforeLoopCnt[i] = beforeLoopCnt[i-1]-1;
				}
			}else {
				if(s[i] == 'L') {
					if(beforeChar != 'L') {
						int index = i-1;
						while(s[index] != 'R') {
							index--;
						}
						beforeChar='L';
						beforeLoopCnt[i]=i-index;
					}else {
						beforeLoopCnt[i] = beforeLoopCnt[i-1]+1;
					}
				}
			}
		}
		for(int i=0;i<s.length;i++) {
			if(s[i]=='R') {
				cntOnSpace[i+beforeLoopCnt[i]+beforeLoopCnt[i]%2]++;
			}else {
				cntOnSpace[i-beforeLoopCnt[i]+ beforeLoopCnt[i] %2]++;
			}
		}
		return cntOnSpace;
	}
	
	public static long powMod(long x,int pow,int mod) {
		long ans = x%mod;
		for(int i=0;i<pow-1;i++) {
			ans *= x;
			ans %= mod;
		}
		return ans;
	}
}
