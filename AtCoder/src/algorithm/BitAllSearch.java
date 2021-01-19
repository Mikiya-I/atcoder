package algorithm;

public class BitAllSearch {
	
	//
	int bitAllSearch(int N) {

		//最大値計算用
	    int max = 0;
	    //ループ回数
	    int loop = 1<<N;
	    //全てのケース
	    for(int i = 0;i<loop;i++) {

	    	//桁分の繰り返し
	    	for(int j=0;j<N;j++) {

	    		//ビットが立っている場所を特定
	    		if(((i>>j) & 1)==1)  {

	    			//諸々処理


	    		}

	    	}
	    	max ++;
	    }
	    return max;
	}

}
