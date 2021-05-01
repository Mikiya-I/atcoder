package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner199zone {

	public static void main(String[] args) throws IOException {
		double ans = slove();
		System.out.println(ans);
	}
	public static double slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int D = Integer.parseInt(strs[1]);
		final int H = Integer.parseInt(strs[2]);
		
		double ans = 0;
		for(int i= 0;i<N;i++) {
			String[] current = reader.readLine().split(" ");
			double d = Integer.parseInt(current[0])*1000;
			double h = Integer.parseInt(current[1])*1000;
			double hv = (H*1000-h);
			double dv = (D*1000-d);
			double m =hv/dv;
			double height = (h-m*d)/1000;
			ans = Math.max(ans, height);
		}
		
		return ans;
	}

}
