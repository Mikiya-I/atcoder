package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class q034 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static int slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int n = Integer.parseInt(strs[0]);	
		int k = Integer.parseInt(strs[1]);
		strs = reader.readLine().split(" ");
		reader.close();
		
		int ans =0;
//		int startIdx = 0;
		//size = 数値の数
		HashMap<Integer,Integer> numCnt = new HashMap<>();
		//size = 連続した数
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for( int i=0;i<n;i++ ) {
			int tmp = Integer.parseInt(strs[i]);
			que.add(tmp);
			if(!numCnt.containsKey(tmp))
				numCnt.put(tmp, 1);
			else
				numCnt.replace(tmp, numCnt.get(tmp)+1);
			
			while(numCnt.size() > k) {
				int remove = que.pop();
				if(numCnt.get(remove) == 1)
					numCnt.remove(remove);
				else
					numCnt.replace(remove, numCnt.get(remove)-1);
			}
			
			ans = Math.max(ans, que.size());
		}
		
		return ans;
	}
}
