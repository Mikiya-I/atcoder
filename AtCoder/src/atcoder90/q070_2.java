package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q070_2 {
	
	static int N;
	static long[] x,y;
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		x = new long[N];
		y = new long[N];
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			x[i] = Long.parseLong(strs[0]);
			y[i] = Long.parseLong(strs[1]);
		}
		Arrays.sort(x);
		Arrays.sort(y);
		reader.close();
	}
	
	public static long slove() throws  IOException {
		long ans = 0;
		long xMedian = x[N/2];
		long yMedian = y[N/2];
		for(int i = 0;i<N;i++) {
			ans += Math.abs(x[i]-xMedian);
			ans += Math.abs(y[i] - yMedian);
		}
			
		return ans;
	}
}
