package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner242_D {
	static int Q;
	static char[] arr;
	static long[] T,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		arr = reader.readLine().toCharArray();
		Q = Integer.parseInt(reader.readLine());
		T = new long[Q];
		K = new long[Q];
		for(int i=0;i<Q;i++) {
			String[] strs = reader.readLine().split(" ");
			T [i]= Long.parseLong(strs[0]);
			K[i] = Long.parseLong(strs[1]);
		}
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<Q;i++) {
			long t = T[i];
			long k = K[i];
			int startIdx;
			int cnt = 0;
			if(t < 64) {
				startIdx = (int) (k/Math.pow(2, t));
				k %= Math.pow(2, t);
				cnt = (int) t;
			}else {
				startIdx = 0;
				cnt = 64;
			}
			int[] bits = new int[cnt];
			for(int j=0;j<cnt;j++) {
				//ビットが立っている場所を特定
	    		if(((k>>j) & 1)==1)  {
	    			bits[j] = 1;
	    		}else {
	    			bits[j] = 0;
	    		}
			}
			char tmpChar = arr[startIdx];
			//桁分の繰り返し
	    	for(int j=cnt-1;0<=cnt;j++) {
	    		tmpChar = nextChar(tmpChar,bits[j]);
	    	}
	    	sb.append(tmpChar + "\n");
		}
		return sb.toString();
	}
	
	static char nextChar(char tmpC,int bit) {
		if(tmpC == 'A') {
			return bit==1?'C':'B';
		}else if(tmpC == 'B') {
			return bit==1?'A':'C';
		}else {
			return bit==1?'B':'A';
		}
	}

}