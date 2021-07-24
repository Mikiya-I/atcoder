package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner211_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String[] strs = reader.readLine().split(" ");
		boolean[] arr = new boolean[4];
		for(int i=0;i<4;i++) {
			switch(reader.readLine()) {
			case "H":
				arr[0] = true;
				break;
			case "2B":
				arr[1] = true;
				break;
			case "3B":
				arr[2]=true;
				break;
			default:
				arr[3]=true;
				break;
			}
		}
		
		for(boolean b:arr) {
			if(!b) {
				return "No";
			}
		}
		return "Yes";
	}
}
