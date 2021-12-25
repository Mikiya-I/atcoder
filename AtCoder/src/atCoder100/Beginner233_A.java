package atCoder100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner233_A {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = reader.readLine().split(" ");
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		
		int ans = 0;
		if(y<= x) {
			System.out.println(ans);
			return ;
		}
		ans += (y-x)/10;
		if((y-x)%10 != 0)
			ans++;
		System.out.println(ans);
	}
}
