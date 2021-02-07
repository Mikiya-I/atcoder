package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Beginner128_Switches2 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int M = Integer.parseInt(token.nextToken());

	    boolean[][] lights = new boolean[M][N];//各電球に繋がっているスイッチ
	    int[] lightsOn = new int[M];//点灯条件

	    for(int i=0;i<M;i++) {
	    	token = new StringTokenizer(reader.readLine());
	    	int k = Integer.parseInt(token.nextToken());
	    	for(int j= 0;j<k;j++) {
	    		lights[i][Integer.parseInt(token.nextToken())-1] = true;
	    	}
	    }

	    token = new StringTokenizer(reader.readLine());
	    for(int i=0;i<M;i++) {
	    	lightsOn[i] = Integer.parseInt(token.nextToken());
	    }

	    int ans = 0;
	    for(int i =0;i< (1<<N);i++) {
	    	boolean ok = true;
	    	boolean pattern[] = new boolean[N];
	    	for(int j=0;j<N;j++) {
	    		if(((i>>j)&1) ==1) {
	    			pattern[j] =true;
	    		}
	    	}
	    	//全ての電球のパターン
	    	for(int l= 0;l<M;l++) {
	    		int cal =0;
	    		//スイッチの状態(電球に繋がっている 且つ パターンでついている電球の数)
	    		for(int k=0;k<N;k++) {
	    			if(lights[l][k]&& pattern[k])
	    				cal++;
	    		}
	    		//パターンに矛盾が生じたら棄却
	    		if(cal%2 != lightsOn[l]) {
	    			ok=false;
	    			break;
	    		}
	    	}
	    	if(ok)
	    		ans++;
	    }
	    System.out.println(ans);
	}

}
