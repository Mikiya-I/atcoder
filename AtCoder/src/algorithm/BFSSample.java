package algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class BFSSample {
	static ArrayDeque<Integer> que = new ArrayDeque<Integer>();
	static boolean[] used ;
	 void bfs(ArrayList<ArrayList<Integer>> path) {
		 ArrayDeque<Integer> que = new ArrayDeque<Integer>();
		    int[] dis = new int[100];
		    Arrays.fill(dis, -1);
		    que.push(1);
		    dis[1] = 0;
		    while(!que.isEmpty()){
		        int t = que.pop();
//		        que.pop();
		        for(int x: path.get(t)) { 
		        	if(dis[x] == -1) {
			            dis[x] = dis[t] + 1;
			            que.push(x);
		        	}
		        }
		    }
	 }
}
