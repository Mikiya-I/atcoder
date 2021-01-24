package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square869120Contest {

	public static void main(String[] args) throws IOException {

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int[] A = new int[N];
	    int B[] = new int[N];
	    long c =0;//AからBにかかる時間の合計(全てのルートの共通部分)

	    for(int i=0;i<N;i++) {
	    	token = new StringTokenizer(reader.readLine());

	    	A[i] = Integer.parseInt(token.nextToken());
	    	B[i] = Integer.parseInt(token.nextToken());
	    	c+= B[i] - A[i];

	    }

	    //Aの最小とBの最小を求める
	    long aSide = Long.MAX_VALUE;
	    long bSide = Long.MAX_VALUE;
	    //最小はいずれかのA/Bと同じ位置
	    for(int i=0;i<N;i++) {
	    	//入口からaまでの時間を全探索
	    	long current =0;
	    	for(int a:A) {
	    		current += Math.abs(A[i]-a);
	    	}
	    	if(aSide>current) aSide =current;

	    	//出口からbまでの時間を全探索
	    	current = 0;
	    	for(int b:B) {
	    		current += Math.abs(B[i]-b);
	    	}
	    	if(bSide>current) bSide = current;
	    }

	    System.out.println(c+aSide+bSide);
	}

}
