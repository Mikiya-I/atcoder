package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Beginner167_D {
	public static void main(String[] args) throws IOException {
//		slove();
		long  ans = slove();
		System.out.println(ans);
//		System.out.println(isPrime());
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N =Integer.parseInt(strs[0]);
		long K = Long.parseLong(strs[1]);
		int[] arr = new int[(int) (2e5+1)];
		strs = reader.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(strs[i-1]);
		}
		long ans =0;
		//一度使われた町が出てきたらループになる
		HashSet<Integer> used = new HashSet<Integer>();
		int tmp =1;
		//ループの最後までのサイズ
		int totalSize = 1;
		used.add(1);
		while(!used.contains(arr[tmp])) {
			used.add(tmp);
			tmp = arr[tmp];
			totalSize ++;
		}
		int loopStart = arr[tmp];
		tmp =1;
		int beforeLoopSize=0;
		while(tmp != loopStart) {
			tmp = arr[tmp];
			beforeLoopSize++;
		}
		if(K<=beforeLoopSize) {
			tmp =1;
//			return arr[(int) K];
			for(int i=0;i<K;i++) {
				tmp=arr[tmp];
			}
		}
		K-=beforeLoopSize;
		int mod = (int) (K%(totalSize-beforeLoopSize));
		for(int i=0;i<mod;i++) {
			tmp = arr[tmp];
		}
		return tmp;
	}
}
