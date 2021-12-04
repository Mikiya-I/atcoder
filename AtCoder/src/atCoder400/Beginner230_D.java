package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beginner230_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
//				slove();
		System.out.println(slove());
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		long ans = 1;
		final int N = Integer.parseInt(strs[0]);
		final long D = Integer.parseInt(strs[1]);
		List<LeftRight> list = new ArrayList<LeftRight>();
		for(int i=0;i<N;i++) {
			strs = reader.readLine().split(" ");
			LeftRight p = new LeftRight();
			p.left = Integer.parseInt(strs[0]);
			p.right = Integer.parseInt(strs[1]);
			list.add(p);
		}
		
		list.sort( ( a, b) -> a.right -b.right);
//		int tmpIdx = 0;
//		while(tmpIdx < N) {
//			//パンチする左端
//			long tmpPoint = list.get(tmpIdx).right;
//			while(tmpIdx < N) {
//				if(list.get(tmpIdx).left > tmpPoint + D-1) {
//					ans ++;
//					break;
//				}else {
//					tmpIdx ++;
//				}
//			}
//		}
		int tmpPoint = list.get(0).right;
		for(int i=0;i<N;i++) {
			if(list.get(i).left > tmpPoint + D -1) {
				tmpPoint = list.get(i).right;
				ans ++;
			}
		}
		return ans;
	}
}

class LeftRight{
	int left,right;
}
