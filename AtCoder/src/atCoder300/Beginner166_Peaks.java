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
	   System.out.println(ans);
	}
}
