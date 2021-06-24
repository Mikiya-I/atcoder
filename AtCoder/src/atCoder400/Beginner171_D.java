package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner171_D {
	public static void main(String[] args) throws IOException {
//		slove();
		String  ans = slove();
		System.out.println(ans);
	}
	
	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N =Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		long[] arr = new long[100001];
		long sum =0;
		int tmp;
		for(int i=0;i<N;i++) {
			tmp = Integer.parseInt(strs[i]);
			arr[tmp]++;
			sum+= tmp;
		}
		int Q = Integer.parseInt(reader.readLine());
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			long b = Integer.parseInt(strs[0]);
			long c = Integer.parseInt(strs[1]);
			sum -=arr[(int)b]*b;
			sum+=c*(arr[(int)b]);
			arr[(int)c] += arr[(int) b];
			arr[(int)b] =0;
			sb.append(sum);
			sb.append("\n");
		}
		return sb.toString();
	}
}
