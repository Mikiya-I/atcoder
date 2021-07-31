package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner212_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] c = reader.readLine().toCharArray();
		int[] arr = new int[4];
		for(int i=0;i<4;i++) {
			arr[i] = c[i]-48;
		}
		
		if(arr[0]==arr[1]&& arr[1]==arr[2]&&arr[2]==arr[3]) {
			return "Weak";
		}
		int cnt =0;
		for(int i=1;i<4;i++) {
			if(arr[i] == arr[i-1]+1 || (arr[i]==0 && arr[i-1]==9)) {
				cnt++;
			}
		}
		if(cnt ==3)
			return "Weak";
		else
			return "Strong";
	}
}
