package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Square869120Contest4_BuildingsAreColorful {

	public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int K = Integer.parseInt(token.nextToken());


	    token = new StringTokenizer(reader.readLine());
	    int[] building = new int[N];

	    for(int i=0;i<N;i++) {
	    	building[i]  = Integer.parseInt(token.nextToken());
	    }

	    long ans =Long.MAX_VALUE;
	    //bit全探索(max2の15乗)
	    for(int i=1,pattern = 1<<N;i<pattern;i++) {

	    	//一番右の建物は必ず目に入るから立っていないものはスキップ
	    	if(i%2==0) continue;

	    	//立っているbitがk個じゃないものはスキップ
	    	if(Integer.bitCount(i)!=K) continue;

	    	long sum = 0;
	    	//bitが立っているところ
	    	for(int j=1,base = building[0];i>>j > 0;j++) {
	    		if(((i>>j)&1) ==1 ) {
	    			//建物がその時点での最高値より低い場合(高さを挙げる必要がある場合)
	    			if(building[j] <= base) {
	    				sum += ++base - building[j];
	    			}
	    		}
	    		//最高値はビットの有無に関係なく更新
	    		base = Math.max(base, building[j]);
	    	}
	    	if(sum < ans ) ans = sum;
	    }
	    System.out.println(ans);
	}

}
