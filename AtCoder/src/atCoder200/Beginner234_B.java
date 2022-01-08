package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner234_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i=0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			x[i] = Integer.parseInt(strs[0]);
			y[i] = Integer.parseInt(strs[1]);
		}
		double max = 0;
		for(int i=0;i<N-1;i++) {
			int x1 = x[i];
			int y1 = y[i];
			for(int j=i+1;j<N;j++) {
				int x2 = x[j];
				int y2 = y[j];
				max = Math.max(max, calcDistance(x1, y1, x2, y2));
			}
		}
		System.out.println(max);
	}
	
	static double calcDistance(int x1, int y1 ,int x2, int y2) {
		int xDist = Math.abs(x1 - x2);
		int yDist = Math.abs(y1 - y2);
		double dist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
		
		return dist;
	}
}
