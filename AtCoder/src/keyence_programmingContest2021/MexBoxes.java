package keyence_programmingContest2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MexBoxes {

	public static void main(String[] args) throws IOException {


	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int K = Integer.parseInt(token.nextToken());

	    int[] a = new int[N];
	    token = new StringTokenizer(reader.readLine());
	    for(int i= 0;i<N;i++) {
	    	a[i] = Integer.parseInt(token.nextToken());
	    }
	    reader.close();

	    Arrays.sort(a);

	    if(a[0] != 0) {
	    	System.out.println(0);
	    	return;
	    }

	    long result = 0;
	    int leftBox = K;
	    int arrayStart =0;
	    for(int i=0;i<N;i++) {
	    	for(int j =0;arrayStart<N ;j++,arrayStart++) {
	    		//ボール番号が変わった時
	    		if(a[arrayStart] != i) {
	    			//全ての箱に入りきらなかった場合
	    			if(j<leftBox) {
		    			result += (leftBox-j)*i;//ボールが入らなかった箱の値を加算
		    			leftBox = j;//ボールが入った箱だけ残る
	    			}
	    			break;
	    			//最後まで行った時
	    		}else if(arrayStart == N-1) {
	    			result += i*leftBox;
	    			//ボールが足りなかった場合
	    			if(j+1<leftBox) {
	    				result += j+1;//ボールを入れた箱の分だけ加算
	    			}
	    			//ボールが全ての箱に入った場合
	    			else {
	    				result += leftBox;//残りの箱の分だけ加算(残りの箱の数値は最後のボール番号+1になるため)
	    			}

	    			leftBox = 0;
	    		}
	    	}
	    	if(leftBox <=0) {
	    		break;
	    	}
	    }
	    System.out.println(result);
	}

}
