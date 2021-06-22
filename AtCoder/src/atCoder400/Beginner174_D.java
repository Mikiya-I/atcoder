package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner174_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		char[] arr = reader.readLine().toCharArray();
		int rCnt =0;
		for(char c:arr) {
			if(c=='R') {
				rCnt++;
			}
		}
		long ans =0;
		//先頭からrCnt番目までをRにすればいい
		for(int i=0;i<rCnt;i++) {
			if(arr[i]=='W') {
				ans++;
			}
		}
		return ans;
	}
}
