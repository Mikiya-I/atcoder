package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner160_TravelingSalesmanAroundLake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = reader.readLine().split(" ")	;
		final int K = Integer.parseInt(strs[0]);
		final int  N = Integer.parseInt(strs[1]);
		strs =reader.readLine().split(" ");
		int[] houses = new int[N];
		reader.close();
		int maxDistance = 0;
		houses[0] = Integer.parseInt(strs[0]);
		for(int i=1;i<N;i++) {
			houses[i] = Integer.parseInt(strs[i]);
			maxDistance = Math.max(maxDistance, houses[i]-houses[i-1]);
		}
		maxDistance =Math.max(maxDistance, Math.min(houses[N-1]- houses[0], K-houses[N-1]+houses[0]));
		
		return K-maxDistance;
	}
}
