package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner200_RingosFavoriteNumbers2 {

//	public static void main(String[] args) throws NumberFormatException, IOException {
////		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////		final int n = Integer.parseInt(reader.readLine());
////		String[] strs = reader.readLine().split(" ");
//		for(int cnt=0;cnt<10000;cnt++) {
//			Random rand = new Random();
//			int n = rand.nextInt(20)+10;
//			int[] nums = new int[n];
//			int[] mods = new int[200];
//			for(int i=0;i<n;i++) {
//				nums[i] = rand.nextInt((int)1e9);
//				mods[nums[i]%200]++;
//			}
//			int ans = slove(mods);
//			int ans2 = slove2(nums);
//			
//			if(ans != ans2 ) {
//				System.out.println("this");
//			}
//		}
//		System.out.println("not found");
////		System.out.println(ans);
//	}
//
//	public static int  slove(int[] mods) throws IOException {
////		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////		final int n = Integer.parseInt(reader.readLine());
////		String[] strs = reader.readLine().split(" ");
//		
////		int[] nums = new int[n];
////		int[] mods = new int[200];
////		for(int i=0;i<n;i++) {
////			nums[i] = Integer.parseInt(strs[i]);
////			mods[nums[i]%200]++;
////		}
//		int ans = 0;
//
//		//200の余りの個数の組み合わせ
//		for(int i=0;i<200;i++) {
//			if(mods[i]>1) {
//				ans += mods[i]*(mods[i]-1)/2;
//			}
//		}
//		
//		return ans;
//	}
//	
//	public static int  slove2(int  nums[]) {
//		int ans =0;
//		for(int i=0;i<nums.length;i++) {
//		for(int j=i+1;j<nums.length;j++) {
//			if(Math.abs(nums[i]-nums[j])%200 == 0) {
//				ans ++;
//			}
//		}
//	}
//		return ans;
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		
		long[] nums = new long[n];
		long[] mods = new long[200];
		for(int i=0;i<n;i++) {
			nums[i] = Long.parseLong(strs[i]);
			mods[(int) (nums[i]%200)]++;
		}
		long ans = 0;
//		for(int i=0;i<n;i++) {
//			for(int j=i+1;j<n;j++) {
//				if(Math.abs(nums[i]-nums[j])%200 == 0) {
//					ans ++;
//				}
//			}
//		}
		//200の余りの個数の組み合わせ
		for(int i=0;i<200;i++) {
			if(mods[i]>1) {
				ans += mods[i]*(mods[i]-1)/2;
			}
		}
		
		return ans;
	}
}
