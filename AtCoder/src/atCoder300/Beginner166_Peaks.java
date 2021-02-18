package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner166_Peaks {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	   final int N = Integer.parseInt(token.nextToken());
	   final int M = Integer.parseInt(token.nextToken());

	   token = new StringTokenizer(reader.readLine());
	   int[] heights = new int[N];

	   //高さの配列
	   for(int i=0;i<N;i++)
		   heights[i] = Integer.parseInt(token.nextToken());

	   //判定用の配列
	   int[] max = new int[N];

	   for(int i=0;i<M;i++) {
		   String[] str = reader.readLine().split(" ");
		   int a = Integer.parseInt(str[0])-1;
		   int b = Integer.parseInt(str[1])-1;

		   //判定の配列に元の高さと繋がっている灯台の高さの最大値を代入
		   max[a] = Math.max(heights[b], max[a]);
		   max[b] = Math.max(heights[a], max[b]);
	   }

	   int ans =0;
	   for(int i= 0;i<N;i++) {
		   if(heights[i] > max[i])
			   ans++;
	   }
	   System.out.println(ans);


//outOfMemory発生
/*
	   //道のパターン
	   boolean[][] road = new boolean[N][N];
	   for(int i=0;i< M;i++) {
		   token = new StringTokenizer(reader.readLine());
		   int a = Integer.parseInt(token.nextToken())-1;
		   int b = Integer.parseInt(token.nextToken())-1;
		   road[a][b] = true;
		   road[b][a] = true;
	   }

	   int ans = 0;
	   //全探索
	   for(int i=0;i<N;i++) {//基準の展望台
		   boolean ok = true;
		   //道が繋がっていて短い場合は条件に一致しない
		   for(int j = 0;j<N;j++) {//比較する展望台
			   if(road[i][j]) {
				   if(heights[i] <= heights[j]) {
					   ok =false;
					   break;
				   }
			   }
		   }
		   if(ok)
			   ans++;
	   }
*/
	}
}
