package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Beginner128_Switches {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

	    int N = Integer.parseInt(token.nextToken());
	    int M = Integer.parseInt(token.nextToken());

	    int [][] light = new int[M][N];

	    //m行分読み込む
	    for(int i=0;i<M;i++) {
	    	token = new StringTokenizer(reader.readLine());
	    	int K = Integer.parseInt(token.nextToken());
	    	//k列分読み込む
	    	for(int j=0;j<K;j++) {
	    		light[i][Integer.parseInt(token.nextToken())-1] = 1;//必要なスイッチのインデックスに1を代入
	    		//1,3の場合10100という配列になる
	    	}
	    }

	    int[] p = new int[M];
	    token = new StringTokenizer(reader.readLine());
	    for(int i =0;i<M;i++) {
	    	p[i] = Integer.parseInt(token.nextToken());
	    }

	    int ans = 0;
	    int loop = 1<<N; //2のN乗計算する
	    // bit全探索
	    for (int bit = 0; bit < loop; bit++) {
	      boolean ok = true;
	      //M行分繰り返す(電球の個数分)
	      for (int i = 0; i < light.length; i++) {
	        int count = 0;
	        //ｋ列分繰り返す
	        for (int j = 0; j < light[i].length; j++) {
	         //そのパターンで押されている電球iのスイッチの個数をカウントする
	          if (light[i][j] == 1) {
	        	//その時点で何個のスイッチが押されているか(現時点のパターンで押されているか)
	        	int aaa = bit>>j;
	            if ((1 & aaa) == 1) count++;
	          }
	        }
	        if (count % 2 != p[i]) {
	          ok = false;
	          break;
	        }
	      }
	      //全部の電球がついていれば+1
	      if (ok) ans++;
	    }

	    // 出力
	    System.out.println(ans);
	}

}
