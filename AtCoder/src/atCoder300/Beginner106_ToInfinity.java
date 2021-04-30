package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner106_ToInfinity {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ans = slove();
		System.out.println(ans);
	}

	public static int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] S = reader.readLine().toCharArray();
		long K = Long.parseLong(reader.readLine());
		
		int i=0;
		while(K>0) {
			if(S[i] == '1') {
				K--;
			}else {
//				K-= (long)(S[i] - '0')*(1e15*5+1);
				i++;
				break;
			}
			i++;
		}
		
//		return (int)S[i-1]-'0';
		return (int)S[i-1]-'0';
	}
}