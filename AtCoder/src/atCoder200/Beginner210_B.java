package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner210_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String[] strs = reader.readLine().split(" ");
		int N= Integer.parseInt(reader.readLine());
		char[] arr = reader.readLine().toCharArray();
		int i=0;
		while(arr[i] != '1') {
			i++;
		}
		if(i%2==0) {
			return "Takahashi";
		}else {
			return "Aoki";
		}
	}
}
