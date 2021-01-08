package atCoderB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Begginer120_K_thCommonDivisor {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    String strs[] = reader.readLine().split(" ");
	    int A = Integer.parseInt(strs[0]);
	    int B = Integer.parseInt(strs[1]);
	    int K = Integer.parseInt(strs[2]);

	    int ans = 0;


//	    ユークリッドの互除法で最大公約数を求める
	    boolean canDevide = false;
	    int maxDevisor = 1;
	    int big =A>=B?A:B;
	    int small = B<A?B:A;

	    while(!canDevide) {
	    	int mod = big%small;
	    	if(mod == 0) {
	    		maxDevisor = small;
	    		break;
	    	}
	    	big = small;
	    	small = mod;
	    }

//	    最大公約数を小さい数で割っていく
	    int k=0;
	    for(int i=1;i<=maxDevisor;i++) {
	    	if(maxDevisor%i==0) {
	    		k++;
	    		if(k==K) {
	    			ans =maxDevisor/i;
	    			break;
	    		}
	    	}
	    }


	    System.out.println(ans);
	}

}
