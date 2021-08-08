package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
 
public class Beginner213_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		int H = Integer.parseInt(strs[0]);
		int W = Integer.parseInt(strs[1]);
		int N = Integer.parseInt(strs[2]);
		
//		int[] row = new int[N];
		HashSet<Integer> row = new HashSet<>();
//		int[] column = new int[N];
		HashSet<Integer> column = new HashSet<Integer>();
		int[][] cards = new int[N][2];
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			cards[i][0] = Integer.parseInt(strs[0]);
			cards[i][1] = Integer.parseInt(strs[1]);
//			row[i] = Integer.parseInt(strs[0]);
//			column[i] = Integer.parseInt(strs[1]);
			row.add(cards[i][0]);
			column.add(cards[i][1]);
		}
//		Arrays.sort(row);
//		Arrays.sort(column);
		ArrayList<Integer> row2 = new ArrayList<>(row);
		ArrayList<Integer> column2 =new ArrayList<Integer>(column);
		Collections.sort(row2);
		Collections.sort(column2);
		for(int i=0;i<N;i++) {
			int  a = binarySearch(row2, cards[i][0])+1;
			int b = binarySearch(column2, cards[i][1])+1;
			sb.append(a+" " + b +"\n");
		}
		
		return sb.toString();
	}
		private static int binarySearch(List<Integer> list, int x) {
				int left = -1;
				int right = list.size();
				while(right-left >1) {
					int mid= (left+right)/2;
					if(list.get(mid) >=x) {
						right = mid;
					}else {
						left = mid;
					}
				}
			return right;
		}
}
