package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Beginner218_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//		slove();
		System.out.println(slove());
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		long ans = 0;
		TreeSet<Integer> xSet = new TreeSet<Integer>();
		HashMap<Integer,TreeSet<Integer>> grid  = new HashMap<Integer,TreeSet<Integer>>();
		for (int i = 0; i < N; i++) {
			String[] strs = reader.readLine().split(" ");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			
			if(grid.containsKey(x)) {
				grid.get(x).add(y);
			}else {
				grid.put(x, new TreeSet<Integer>(Arrays.asList(y) ) );
			}
			xSet.add(x);
		}
		
		for(int i:xSet) {
			if(grid.get(i) == null)
				grid.put(i, new TreeSet<Integer>());
		}
		ArrayList<Integer> xList = new ArrayList<Integer>(xSet);
		
		for(int i =0;i<xList.size()-1;i++) {
			TreeSet<Integer> set = grid.get(xList.get(i));
			for(int j:set) {
				for(int I = i+1;I<xList.size();I++) {
					TreeSet<Integer> set2 = grid.get(xList.get(I));
					for(int J:set2) {
						if ( j != J && grid.get(xList.get(I)).contains(j) && grid.get(xList.get(i)).contains(J))
							ans++;
					}
				}
			}
		}
		
			

		return ans/2;
	}

}
