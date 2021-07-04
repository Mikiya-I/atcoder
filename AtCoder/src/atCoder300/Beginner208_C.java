package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Beginner208_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		long ans = slove();
//		System.out.println(ans);
	}
 
	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		final long N = Integer.parseInt(strs[0]);
		final long K = Long.parseLong(strs[1]);
		long[] arr = new long[(int)N];
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
		}
		long[] forSort = arr.clone();
		Arrays.sort(forSort);
		long forAll = K/N;
		long mod = K%N;
		long border = forSort[(int)mod];
		for(int i=0;i<N;i++) {
			if(arr[i] < border) {
				sb.append(forAll+1);
			}else {
				sb.append(forAll);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
//		long ans =0;
//		return ans;
		}
}
