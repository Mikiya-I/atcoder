package atCoderC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner054_OneStrokePath {
	static int ans =0;

	public static void main(String[] args) throws IOException {

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N =Integer.parseInt(token.nextToken());
	    int M = Integer.parseInt(token.nextToken());

	    int point[] = new int[N];
	    for(int i=0 ; i<N;i++) {
	    	point[i] = i+1;
	    }

	    boolean canStartFromOne = false;

	    int[][] edge = new int[N][N];
	    boolean used[] = new boolean[N];

	    for(int i=0;i<M;i++) {
	    	token = new StringTokenizer(reader.readLine());
	    	int a = Integer.parseInt(token.nextToken())-1;
	    	int b = Integer.parseInt(token.nextToken())-1;

	    	edge[a][b] = 1;
	    	edge[b][a] = 1;

	    	if(a==1 || b==1) canStartFromOne =true;
	    }

	    if(!canStartFromOne) {
	    	System.out.println(0);
	    	return;
	    }

	    used[0] = true;
	    dfs(0, 0, edge, used);
	    System.out.println(ans);


	}

	//深さ優先探索
	static void dfs(int point,int nextPoint,int[][] edge,boolean[] used) {
		//最後まで行ったら+1
		if(nextPoint == edge.length-1) {
			ans ++;
		}
		//現在の頂点から繋がっている頂点を探す
		for(int i= 0,length = edge.length; i<length;i++) {
			//現在の頂点から線が繋がっていて使っていない頂点で再起呼び出し、該当する頂点が無ければ再起元に戻る
			if(edge[point][i] ==1 && !used[i]) {
				used[i] = true;
				dfs(i,nextPoint+1,edge,used);
				used[i]=false;
			}
		}
	}

}


