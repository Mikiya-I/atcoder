package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner232_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] s = reader.readLine().toCharArray();
		char[] t = reader.readLine().toCharArray();
		if(s.length==1){
			System.out.println("Yes");
			return ;
		}
		
		int dif=s[0] - t[0];
		for(int i=0;i<s.length;i++) {
			if(t[i]+dif <=122 && t[i]+dif >96)
				t[i] += dif;
			else if (t[i]+dif > 122) {
				t[i] = (char) (96+ t[i]+dif -122);
			}else {
				t[i] = (char) (122 - (96-t[i]-dif));
			}
		}
		if(!String.valueOf(t).equals(String.valueOf(s))) {
			System.out.println("No");
			return;
		}
//		int[] difS = new int[s.length];
//		int[] difT = new int[t.length];
//		for(int i = 1;i<s.length;i++) {
//			difS[i] = s[i] - s[i-1];
//			difT[i] = t[i] - t[i-1];
//		}
//		
//		for(int i=0;i<s.length;i++) {
//			if(difS[i] != difT[i]) {
//				System.out.println("No");
//				return;
//			}
//		}
		System.out.println("Yes");
	}
}
