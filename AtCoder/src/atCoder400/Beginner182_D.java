package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner182_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		//その操作での移動距離(累積和)
		long[] sums = new long[N+1];
		//その動作の中で一番前になった瞬間にどれだけ進んでいたか
		long[] maxMove = new long[N+1];
		//動作終了時の地点
		long[] points = new long[N+1];
//		sums[0] = Long.parseLong(strs[0]);
//		maxMove[0] = Math.max(sums[0], 0);
//		points[0] = sums[0];
		for(int i=1;i<=N;i++) {
			long tmp = Long.parseLong(strs[i-1]);
			sums[i] = sums[i-1]+tmp;
			points[i] = points[i-1] + sums[i];
			maxMove[i]= Math.max(maxMove[i-1],sums[i]);
		}
		
		long ans =0;
		for(int i=1;i<=N;i++) {
			ans = Math.max(ans, points[i-1]+maxMove[i]);
		}
		return ans;
	}
}
