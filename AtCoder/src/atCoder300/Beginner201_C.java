package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner201_C {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String S = reader.readLine();
		int useNum=0;
		int unknown = 0;
		//1 = 使用, 2=不明
		int[] nums = new int[10];
		
		//0=含まれる 1=含まれない 2=不明
		for(int i=0;i<10;i++) {
			char c = S.charAt(i);
			if(c=='o') {
				useNum++;
				nums[i]=1;
			}else if(c=='?'){
				unknown++;
				nums[i]=2;
			}
		}
		if(useNum>4) {
			return 0;
		}else if( useNum ==4) {
			return 24;
		}
//		else {
//			int pattern = (useNum+unknown+1)/2;
//			
//		}
		int ans = 0;
		label:for(int i=0;i<10000;i++) {
			String tmp = String.format("%04d", i);
			boolean match= true;
			boolean[] used = new boolean[10];
			for(char c: tmp.toCharArray()) {
				if(nums[c-'0']==0) {
					match = false;
					break;
				}
				used[c-'0'] = true;
			}
			if(match) {
				for(int j= 0;j<10;j++) {
					if(nums[j]==1 && !used[j]) {
						continue label;
					}
				}
				ans ++;
			}
		}
		
		return ans;
	}
}
