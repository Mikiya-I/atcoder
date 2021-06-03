package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner183_D {

	public static void main(String[] args) throws IOException {
		
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int W = Integer.parseInt(strs[1]);
		
		long[] arr = new long [200001];
		long quantity;
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			quantity = Long.parseLong(strs[2]);
			arr[ Integer.parseInt(strs[0]) ]+=quantity;
			arr[Integer.parseInt(strs[1])] -= quantity;
		}
		
		long sum= 0;
		for(int i= 0;i<200001;i++) {
			sum += arr[i];
			if(sum >W) {
				return "No";
			}
		}
		return "Yes";
	}
}
