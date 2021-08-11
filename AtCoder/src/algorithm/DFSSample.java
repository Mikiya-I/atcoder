package algorithm;

import java.util.ArrayDeque;

public class DFSSample {
	//メソッド内でインスタンス化するとすぐにstackOverFlowになる
	//staticにしてインスタンスを1つにしておく
	static int[][] path;
	static ArrayDeque<Integer> que ;
	static boolean[] used;
	void dfs() {
		while(que.size()>0) {
			int tmp=que.pop();
			used[tmp]=true;
			for(int i: path[tmp]) {
				if(!used[i]) {
					que.add(i);
					dfs();
				}
			}
		}
	}
}
