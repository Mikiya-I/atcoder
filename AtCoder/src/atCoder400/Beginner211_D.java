package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Beginner211_D {
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int mod = (int) 1e9+7;
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		List<Integer>[] path = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			path[i] = new ArrayList<Integer>();
		}
		//道をlistに入れる
		for(int i=0;i<M;i++) {
			strs= reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			path[a].add(b);
			path[b].add(a);
		}
		//↑　どこかでバグってる
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(1);
		//そこまでに行くのに何回移動したか
		int[] dis = new int[N+1];
		//そこに行けるルートの数
		int[] rootCnt = new int[N+1];
		rootCnt[1]=1;
		
	    while(!que.isEmpty()) {
	    	int tmp = que.pop();
//	    	int tmp = que.poll();
//	    	for(int i:path.get(tmp)) {
	    	for(int i:path[tmp]) {
	    		//初めて見つかるルート
	    		if(dis[i]==0) {
	    			dis[i]= dis[tmp]+1;
	    			rootCnt[i] = rootCnt[tmp];
	    			que.add(i);
	    		//元々見つかっていたルート
	    		}else {
	    			if(dis[i]==dis[tmp]+1) {
	    				rootCnt[i]=(rootCnt[i]+rootCnt[tmp])%mod;
	    			}
	    		}
	    	}
	    }
		return rootCnt[N];
	}
}