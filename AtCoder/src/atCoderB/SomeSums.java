package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SomeSums{
  public static void main( String[] args ) throws IOException{
    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
    String[] strs = reader.readLine().split(" ");

    int n = Integer.parseInt(strs[0]);
    int a = Integer.parseInt(strs[1]);
    int b = Integer.parseInt(strs[2]);

    int result = 0;

    for(int i = 0;i<=n;i++) {
//    	int current=i;
    	int sum=0;
//		List<Integer> num = new ArrayList<Integer>();

    	//数値を桁ごとに分解
//    	while(current>0) {
//    		num.add(current%10);
//    		current = current/10;
//    	}
		for(int k = i;k>0;k/=10) {
			sum += k%10;
		}

    	//各桁の合計
//    	for(int x :num) {
//    		sum+=x;
//    	}
//
    	if(a<=sum&&sum<=b) {
    		result += i;
    	}
    }

    System.out.println(result);
  }
}
