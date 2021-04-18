package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner122_GeTAC {

	public static void main(String[] args) throws NumberFormatException, IOException {
		slove();
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] num = reader.readLine().split(" ");
		final int N = Integer.parseInt(num[0]);
		final int Q = Integer.parseInt(num[1]);
		String str = reader.readLine();
		char[] charArray = str.toCharArray();
		//累積和
		int[] acCount = new int[N];
		for(int i= 1;i<N;i++) {
			if(charArray[i-1]=='A' && charArray[i]== 'C') {
				acCount[i]= acCount[i-1]+1;
			}else {
				acCount[i]=acCount[i-1];
			}
		}
		
		for(int i= 0;i<Q;i++) {
			String[] s = reader.readLine().split(" ");
			int l = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);
			System.out.println(acCount[r-1]-acCount[l-1]);
		}
		reader.close();
	}
}
