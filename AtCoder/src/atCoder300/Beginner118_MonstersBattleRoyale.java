package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner118_MonstersBattleRoyale {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] nums = reader.readLine().split(" ");
		reader.close();
		int[] arr = new int[N ];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(nums[i]);
			min = Math.min(min, arr[i]);
		}
		
		int ans = 0;
		for(int i=0;i<N;i++) {
			ans=gcd(ans,arr[i]);
		}
		return ans;
	}
	
	static int gcd(int x,int y) {
		if(x==0) {
			return y;
		}
		if(y==0) {
			return x;
		}
		int max = x>=y?x:y;
		int min = y<=x?y:x;
		int mod = max%min;
		while(mod>0) {
			max=min;
			min=mod;
			mod=max%min;
		}
		
		return min;
	}
}
