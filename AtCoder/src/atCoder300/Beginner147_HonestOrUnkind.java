package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Beginner147_HonestOrUnkind {

	public static void main(String[] args) throws IOException {

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    int N = Integer.parseInt(reader.readLine());
	    ArrayList<List<Pair>> list = new ArrayList<List<Pair>>();
	    //N人のA個の証言をリスト化
	    for(int i =0;i<N;i++) {
	    	List<Pair> smallList = new ArrayList<Pair>();
	    	int A = Integer.parseInt(reader.readLine());
	    	for(int j =0;j<A;j++) {
	    		Pair p = new Pair();
	    		StringTokenizer token = new StringTokenizer(reader.readLine());
	    		p.x =Integer.parseInt(token.nextToken());
	    		p.y = Integer.parseInt(token.nextToken());
	    		smallList.add(p);
	    	}
	    	list.add(smallList);
	    }

	    //最大値計算用
	    int max = 0;
	    //ループ回数
	    int loop = 1<<N;
	    //全てのケース
	    for(int i = 0;i<loop;i++) {
	    	int count = 0;
	    	boolean honest = true;
	    	//人数分の繰り返し
	    	for(int j=0;j<N;j++) {
	    		//ビットが立っている人を特定
	    		if(((i>>j) & 1)==1)  {
	    			//証言をチェック
	    			List<Pair> currentList = list.get(j);
		    		for(Pair now :currentList) {
		    			//証言に矛盾があれば現時点の人は正直ではない
		    			if((i >> now.x-1 & 1) != now.y) {
		    				honest = false;
		    				break;
		    			}
		    		}
		    		//矛盾が無ければカウンタ＋
		    		if(honest) {
		    			count ++;
		    		}else {
		    			break;
		    		}
	    		}

	    	}
	    	//パターンに矛盾がなかった場合
	    	if(honest) {
	    		max = Math.max(count, max);
	    	}
	    }

	    System.out.println(max);

	}

}

class Pair{
	int x;
	int y;
}