package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner230_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 slove();
//		System.out.println(slove());
	}

	public static void  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		char[] arr = s.toCharArray();
		reader.close();
//		int xCnt = 0;
//		int oCnt = 0;
//		int firstxCnt = 0;
//		for(int i=0;i<arr.length;i++) {
//			if(oCnt == 0 && arr[i] == 'x')
//				firstxCnt ++;
//			else {
//				if(arr[i] == 'o')
//					oCnt++;
//				else {
//					xCnt++;
//				}
//			}
//		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) {
			sb.append("oxx");
		}
		String T = sb.toString();
		if(T.contains(s)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
	}
}
