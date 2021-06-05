package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner181_D {

	public static void main(String[] args) throws IOException {
		
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = reader.readLine().toCharArray();
		int[] nums = new int[10];
		for(char c:arr) {
			nums[c-'0']++;
		}
		//下3桁が8の倍数になれば8の倍数(1000の倍数は8の倍数にできるため)
		if(arr.length==1 && nums[8]==1) {
			return "Yes";
		}
		if(arr.length==2) {
			for(int i= 16;i<100;i+=8) {
				int ten = i/10;
				int one = i%10;
				//重複防止のため一度使った値は一旦-1する
				if(nums[ten]--!= 0 && nums[one] != 0) {
					return "Yes";
				}
				//終わったら戻す
				nums[ten]++;
			}
		}
		if(arr.length>=3) {
			for(int i= 104;i<1000;i+=8) {
				int hundred = i/100;
				int ten = (i%100)/10;
				int one = i%10;
				//重複防止用に使った値は-1
				if(nums[hundred]-- != 0 & nums[ten]--!= 0 && nums[one] != 0) {
					return "Yes";
				}
				//判定が終わったら戻す
				nums[hundred]++;
				nums[ten]++;
			}
		}
		
		return "No";
	}
}
