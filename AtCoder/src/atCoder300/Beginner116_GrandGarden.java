package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner116_GrandGarden {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(slove());
		
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		int[] height = new int[N];
		int max= 0;
		for(int i= 0;i<N;i++) {
			height[i]= Integer.parseInt(strs[i]);
			max = Math.max(max, height[i]);
		}
		int ans = 0;
		for(int n=0;n<=max;n++) {
			boolean find =false;
			for(int i=0;i<N;i++) {
				if(!find && height[i]<=n  ){
					continue;
				}
				if(!find &&  height[i]>n ){
					find =true;
				}
				if((find&&(height[i]<=n||i==N-1) )|| (height[i]>n&&i==N-1)) {
					ans++;
					find = false;
				}
			}
		}
		return ans;
	}
}
