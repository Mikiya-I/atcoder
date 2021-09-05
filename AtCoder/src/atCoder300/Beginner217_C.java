package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner217_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int  N = Integer.parseInt(reader.readLine());
		int[] arr = new int[N];
		String[] strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
//			arr[i] = Integer.parseInt(strs[i]);
			arr[Integer.parseInt(strs[i])-1]=  i+1;
		}
		for(int i : arr)
			sb.append(i + " ");
		
		return sb.toString();
		}
}
