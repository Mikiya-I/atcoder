package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner151_WelcomeToAtCoder {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		String ans = slove();
		System.out.println(ans);
	}
 
	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		
		boolean[] ac = new boolean[N+1];
		int[] wa = new int[N+1];
		for(int i=0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int questionNo = Integer.parseInt(strs[0]);
			//その問題でacを出していないときだけスコアに変化
			if(!ac[questionNo] ) {
				if(strs[1].equals("AC")) {
					ac[questionNo]=true;
				}else {
					wa[questionNo]++;
				}
			}
		}
		
		int acCount =0;
		int waCount=0;
		for(int i=0;i<N+1;i++) {
			if(ac[i]) {
				acCount++;
				waCount+= wa[i];
			}
		}
		
		return acCount+" "+waCount;
	}
}
