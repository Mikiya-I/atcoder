package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner143_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		long[] nums = new long[1001];
		for(int i=0;i<N;i++) {
			nums[Integer.parseInt(strs[i])]++;
		}
		long ans =0;
		for(int i=1;i<1001;i++) {
			if(nums[i]==0)
				continue;
			if(nums[i]>2) 
				//正三角形
				ans+= nums[i]*(nums[i]-1)*(nums[i]-2)/6;
			for(int j=i+1;j<1001;j++) {
				if(nums[j]==0) 
					continue;
				if(nums[j]!=0&&i*2>j)
					//jを底にした二等辺
					ans += nums[i]*(nums[i]-1)*nums[j]/2;
				if(nums[j]>1)
					//iを底にした二等辺
					ans += nums[j]*(nums[j]-1)*nums[i]/2;
				for(int k=j+1;k<i+j && k< 1001;k++) {
					//全て違う辺
					ans+= nums[i]*nums[j]*nums[k];
				}
			}
		}
		
		return ans;
	}
}
