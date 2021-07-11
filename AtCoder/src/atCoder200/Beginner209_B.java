package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner209_B {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove());
	}

	public static String  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N= Integer.parseInt(strs[0]);
		int X = Integer.parseInt(strs[1]);
		strs= reader.readLine().split(" ");
		reader.close();
		long tmp=0;
		for(int i=0;i<N;i++) {
			tmp+= Integer.parseInt(strs[i])-i%2;
			if(tmp>X) {
				return "No";
			}
		}
		return "Yes";
		}
}
