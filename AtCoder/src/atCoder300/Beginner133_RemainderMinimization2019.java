package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner133_RemainderMinimization2019 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans =slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
//		BufferedReader reader = 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String[] data = br.readLine().split(" ");
	    final long L = Integer.parseInt(data[0]);
	    final long R = Integer.parseInt(data[1]);
	    
	    //0ケース
	    if(L==0 || R/2019-L/2019>0) {
	    	return 0;
	    }
	    
	    long smallMod =  L%2019;
	    long largeMod = R%2019;
	    int ans = 2019;
	    for(int i= (int) smallMod;i<largeMod;i++) {
	    	for(int j=i+1;j<=largeMod;j++) {
	    		ans = Math.min(ans, (j*i)%2019);
	    	}
	    }
	    
	    return ans;
	}
}
