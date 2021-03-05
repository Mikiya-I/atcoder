package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner185_DuodecimFerra {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final long N = Integer.parseInt(reader.readLine())-1;
		reader.close();
		boolean[] eleven= new boolean[12];
		//n-1個から11個を求める
		long  n = 1;
		for(int i=0;i<11;i++) {
			n *=N-i;
			for(int j=1;j<12;j++) {
				//オーバーフロー対策(割りながらかけていく)
				if(!eleven[j] && n%j ==0) {
					n/=j;
					eleven[j] = true;
				}
			}
		}
		System.out.println(n);
	}
}
