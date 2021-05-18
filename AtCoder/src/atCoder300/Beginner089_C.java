package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner089_C {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans = slove();
		System.out.println(ans);
	}

	
    public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		long[] march = new long [5];
		for(int i=0;i<N;i++) {
			char c = reader.readLine().charAt(0);
			if(c=='M') {
				march[0] ++;
			}else if(c == 'A') {
				march[1]++;
			}else if ( c == 'R') {
				march[2]++;
			}else if ( c== 'C') {
				march[3]++;
			}else if(c == 'H'){
				march[4]++;
			}
		}
		long ans =0;
		for(int i= 0;i<3;i++) {
			for(int j = i+1;j<4;j++) {
				for (int k = j+1;k<5;k++) {
					ans += march[i] * march[j]  * march[k];
				}
			}
		}
		
		return ans;
    }
}
