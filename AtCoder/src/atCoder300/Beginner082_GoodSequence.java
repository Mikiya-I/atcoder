package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner082_GoodSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		
		String[] strs = reader.readLine().split(" ");
		int[] nums = new int[N];
		//ai <= N なら0に　それ以外ならNまで引く
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(nums);
		
		int ans = 0;
		int tmp = 0;
		int tmpCount = 0;
		for(int i= 0;i<N;i++) {
			if(tmp != nums[i] ) {
				if(tmpCount<tmp) {
					ans += tmpCount;
				}else {
					ans +=  tmpCount -tmp;
				}
				tmp=nums[i];
				tmpCount = 1;
			}else {
				tmpCount++;
			}
			if(i==N-1) {
				if(tmpCount<tmp) {
					ans += tmpCount;
				}else {
					ans +=  tmpCount -tmp;
				}
			}
		}
		return ans;
	}
}

