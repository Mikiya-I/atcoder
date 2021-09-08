package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q076 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		long[] arr = new long[N];
		//累積和
		long[] sums = new long[N];
		String[] strs = reader.readLine().split(" ");
		reader.close();
		long total= 0;
		for(int i=0;i<N;i++) {
			arr[i] = Long.parseLong(strs[i]);
			total += arr[i];
			sums[i] = total;
		}
		if(total%10 != 0)
			return "No";
		
		long ten = total/10;
		int tmpIndex = -1;
		long tmpTotal = 0;
		for(int i=0;i<N;i++) {
			if(tmpIndex < i)
				tmpTotal += arr[i];
			while( tmpTotal< ten) {
				if(tmpIndex == -1 || tmpIndex < i) 
					tmpIndex = i+1;
				else
					tmpIndex ++;
				tmpTotal += arr[tmpIndex%N];
			}
			if(tmpTotal == ten)
				return "Yes";
			tmpTotal -= arr[i];
		}
		
		return "No";
	}
}
