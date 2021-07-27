package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Beginner211_D {
	static ArrayList<ArrayList<Integer>> path;
	public static void main(String[] args) throws IOException {
//		long  ans = slove();
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long mod = (long) 1e+9;
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		path = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N+1;i++) {
			path.add(new ArrayList<Integer>());
		}
		//道をlistに入れる
		for(int i=0;i<M;i++) {
			strs= reader.readLine().split(" ");
			path.get(Integer.parseInt(strs[0])).add(Integer.parseInt(strs[1]));
			path.get(Integer.parseInt(strs[1])).add(Integer.parseInt(strs[0]));
		}
		ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		que.add(1);
		//そこまでに行くのに何回移動したか
		int[] disFrom1 = new int[N+1];
		Arrays.fill(disFrom1, -1);
		disFrom1[1] = 0;
		//そこに行けるルートの数
		int[] rootCnt = new int[N+1];
		rootCnt[1]++;
	    while(que.size()>0) {
	    	int tmp = que.pop();
	    	for(int i:path.get(tmp)) {
	    		//初めて見つかるルート
	    		if(disFrom1[i]==-1) {
	    			disFrom1[i]= disFrom1[tmp]+1;
	    			rootCnt[i] = rootCnt[tmp];
	    			que.add(i);
	    		//元々見つかっていたルート
	    		}else {
	    			//同じ道が複数回あるとダブる
	    			if(disFrom1[i]==disFrom1[tmp]+1) {
	    				rootCnt[i] = (int) ((long)(rootCnt[i] + (long)rootCnt[tmp])%mod);
	    			}
	    		}
	    	}
	    }
	    
		return rootCnt[N];
	}
}