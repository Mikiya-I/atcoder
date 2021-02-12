package atCoder300;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner167_SkillUp {

	public static void main(String[] args) throws Exception {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	   final int N = Integer.parseInt(token.nextToken());
	   final int M = Integer.parseInt(token.nextToken());
	   final int X = Integer.parseInt(token.nextToken());

	   int[][] c = new int[N][M+1];

	   for(int i = 0;i<N;i++) {
		   token = new StringTokenizer(reader.readLine());
		   c[i][0] = Integer.parseInt(token.nextToken());
		   for(int j= 1;j<=M;j++) {
			   c[i][j] = Integer.parseInt(token.nextToken());
		   }
	   }

	   boolean findPattern = false;
	   int ans = Integer.MAX_VALUE;
	   for(int i= 0;i < 1<<N;i++) {
		   int current = 0;
		   boolean match = true;
		   int[] skillSum = new int[M];
		   for(int j = 0;j<N;j++) {
			   //bitが立っている本を購入
			   if( (i>>j &1) ==1) {
				   current += c[j][0];
				   for(int k = 1;k<=M;k++) {
					   skillSum[k-1] += c[j][k];
				   }
			   }
		   }
		   //全てのスキルが条件を満たしているか判定
		   for(int sum :skillSum) {
			   if(sum <X) {
				   match = false;
				   break;
			   }
		   }
		   if(match && current < ans) {
			   findPattern = true;
			   ans = current;
		   }
	   }
	   System.out.println(findPattern?ans:-1);
	}
}
