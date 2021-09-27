package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner220_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
				slove();
//		System.out.println(slove2());
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long mod = 998244353;
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
		int[] beforeCnt = new int[10];
		int[] tmpCnt = new int[10];
		int x= Integer.parseInt(strs[0]);
		int y= Integer.parseInt(strs[1]);
		tmpCnt[ (x+y)%10] ++;
		tmpCnt[ (x*y)%10] ++;
		for(int i=2;i<N;i++) {
			y= Integer.parseInt(strs[i]);
			beforeCnt = tmpCnt.clone();
			Arrays.fill(tmpCnt, 0);
			for(int j=0;j<10;j++) {
				if(beforeCnt[j]==0)
					continue;
				int f =  (j+y)%10;
				int g = (j*y)%10;
				tmpCnt[f] += beforeCnt[j] ;
				tmpCnt[f] %= mod;
				tmpCnt[g] += beforeCnt[j];
				tmpCnt[g] %= mod;
			}
		}
		
		for(int ans: tmpCnt)
			System.out.println(ans);
	}
}
