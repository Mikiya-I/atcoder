package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner098_Attention {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long ans = slove();
		System.out.println(ans);
	}

	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		String str = reader.readLine();
		char[] c = str.toCharArray();
		
		int[] changeCount = new int[N];
		int first =0;
		for(int i=1;i<N;i++) {
			if(c[i]=='E') {
				first ++;
			}
		}
		changeCount[0]=first;
		int min = first;
		for(int i=1;i<N;i++) {
			//西を向いているのをリーダーにしたらそのまま、東を向いているのをリーダーにしたら-1
			changeCount[i]=c[i]=='W'?changeCount[i-1]:changeCount[i-1]-1;
			if(c[i-1]=='W') {
				changeCount[i]++;
			}
			min= Math.min(min, changeCount[i]);
		}
		
		return min;
	}
}
