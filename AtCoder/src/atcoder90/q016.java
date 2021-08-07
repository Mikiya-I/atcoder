package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q016 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long N = Integer.parseInt(reader.readLine());
		
		String[] strs = reader.readLine().split(" ");
		reader.close();
		long[] Coins = new long[3];
		for(int i=0;i<3;i++) {
			Coins[i] = Integer.parseInt(strs[i]);		
		}
		Arrays.sort(Coins);
		long ans = Integer.MAX_VALUE;
		for(int i=0;i<10000;i++) {
			int j=0;
			while(N >=i*Coins[2]+j*Coins[1]){
				long remain= N-i*Coins[2] - j*Coins[1];
				if(remain%Coins[0]==0) {
					ans = Math.min(ans, remain/Coins[0]+i+j);
				}
				j++;
			}
		}
		
		return ans;
	}
}
