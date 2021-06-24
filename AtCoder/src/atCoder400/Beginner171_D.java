package atCoder400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Beginner171_D {
	public static void main(String[] args) throws IOException {
		slove();
//		long  ans = slove();
//		System.out.println(ans);
	}
	
	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
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
			writer.write(((Long)sum).toString());
			writer.newLine();
		}
		writer.flush();
	}
}
