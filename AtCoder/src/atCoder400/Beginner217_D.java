package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beginner217_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//		slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		int L = Integer.parseInt(strs[0]);
		int Q = Integer.parseInt(strs[1]);
		List<Integer> position = new ArrayList<Integer>();
		position.add(0);
		position.add(L);
//		boolean isAdded = false;
		for(int i=0;i<Q;i++) {
			strs = reader.readLine().split(" ");
			int x = Integer.parseInt(strs[1]);
			if(strs[0].equals("2")) {
				if(position.size() == 2) {
					sb.append(L);
				}else {
//					if (isAdded) {
//						Collections.sort(position);
//						isAdded = false;
//					}
					int idx = binarySearch(position, x);
					sb.append(position.get(idx)  - position.get(idx-1));
				}
				sb.append("\n");
			}else {
				int idx = binarySearch(position, x);
				if(position.get(idx)==x)
					continue;
				position.add(idx,x);
//				isAdded = true;
			}
		}
		
		return sb.toString();
	}
	
	private static int binarySearch(List<Integer> list, int x) {
		//left x未満　right x以上
		int left = 0;
		int right = list.size()-1;
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
