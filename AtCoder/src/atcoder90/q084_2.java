package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q084_2 {
	static int N,oCnt;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		input();
//		test();
		System.out.println(slove());
	}
	
	static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();
		arr = new boolean[N];
		oCnt = 0;
		for(int i=0;i<N;i++) {
			arr[i] = s[i]=='o';
			if(arr[i])
				oCnt++;
		}
		reader.close();
	}
	
	public static long slove() throws  IOException {
		//Lを固定し、条件を満たす一番小さいRを探す
		int[] oIdxes = new int[oCnt];
		int[] xIdxes = new int[N-oCnt];
		if(oIdxes.length * xIdxes.length == 0) {
			return 0;
		}
		int oIdx = 0;
		int xIdx = 0;
		for(int i=0;i<N;i++) {
			if(arr[i]) {
				oIdxes[oIdx] = i;
				oIdx ++;
			}else {
				xIdxes[xIdx]=i;
				xIdx++;
			}
		}
		long ans =0;
		int oTmpIdx = 0;
		int xTmpIdx =0;
		for(int i=0;i<N;i++) {
			//Lがoの場合
			if(arr[i]) {
				while(xIdxes[xTmpIdx]< i || xTmpIdx< xIdxes[ N-oCnt]) {
					xTmpIdx ++;
				}if() {
					
				}
			}
			//Lがxの場合
			else {
				
			}
		}
		
		return ans;
	}
	
}
