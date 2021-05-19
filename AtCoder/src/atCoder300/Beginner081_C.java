package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner081_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long  ans = slove();
		System.out.println(ans);
	}

	
    public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ") ;
		final int  N = Integer.parseInt(strs[0]);
		final int K =  Integer.parseInt(strs[1]);
		
		int[] a = new int [N+1];
		strs= reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<N;i++) {
			a[Integer.parseInt(strs[i])-1]++;
		}
		int numCnt =N;
		for(int i= 0;i<N;i++) {
			if(a[i] == 0){
				numCnt --;
			}
		}
		Arrays.sort(a);
		int ans = 0;
		//数字を減らす場合
		if(numCnt >K) {
			//少ないものから書き換える
			for(int i = N-numCnt+1 ;N-i >= K;i++) {
				ans +=a[i];
			}
		}
		
		return ans;
    }
}
