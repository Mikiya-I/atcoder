package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner144_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N =Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		
		strs= reader.readLine().split(" ");
		final int ROCK = Integer.parseInt(strs[0]);
		final int SCISERS = Integer.parseInt(strs[1]);
		final int PAPER = Integer.parseInt(strs[2]);
			
		char[] arr = reader.readLine().toCharArray();
		int[] KthCnt = new int[N];
		reader.close();
		for(int i=0;i<K;i++) {
			KthCnt[i]++;
		}
		for(int i=K;i<N;i++) {
			if(arr[i]==arr[i-K]) {
				KthCnt[i]=KthCnt[i-K]+1;
			}else {
				KthCnt[i]++;
			}
		}
		long ans =0;
		for(int i=0;i<N;i++) {
			char c = arr[i];
			switch (c){
			case 'r':
				ans += PAPER*(KthCnt[i]%2);
				break;
			case 's':
				ans += ROCK*(KthCnt[i]%2);
				break;
			default:
				ans += SCISERS*(KthCnt[i]%2);
				break;
			}
		}
		
		return ans;
	}
}
