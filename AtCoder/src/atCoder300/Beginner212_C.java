package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
 
public class Beginner212_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
//		 slove();
//		long ans = slove();
		System.out.println(slove3());
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
//		int[] arrN = new int[N];
//		int[] arrM = new int[M];
		HashSet<Integer> setN = new HashSet<>();
		HashSet<Integer> setM = new HashSet<>();
		strs  = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
//			arrN[i] = Integer.parseInt(strs[i]);
			setN.add(Integer.parseInt(strs[i]));
		}
		
		strs = reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<M;i++) {
//			arrM[i] = Integer.parseInt(strs[i]);
			setM.add(Integer.parseInt(strs[i]));
		}
		Integer[] arrN = new Integer[setN.size()];
		setN.toArray(arrN);
		Integer[] arrM = new Integer[setM.size()];
		setM.toArray(arrM);
		Arrays.sort(arrN);
		Arrays.sort(arrM);
		long ans = Long.MAX_VALUE;
		int startIndex= 0;
		for(int i=0;i<arrN.length;i++) {
			for(int j=startIndex;j<arrM.length;j++) {
				int tmp = arrN[i] - arrM[j];
				if(Math.abs(tmp)< ans ) {
					ans = Math.abs(tmp);
				}else if(tmp <-1) {
					break;
				}else {
					startIndex=j;
				}
			}
		}
		
		
		return ans;
	}
	
	public static long  slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		int[] arrN = new int[N];
		int[] arrM = new int[M];
		strs  = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arrN[i] = Integer.parseInt(strs[i]);
		}
		
		strs = reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<M;i++) {
			arrM[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arrN);
		Arrays.sort(arrM);
		long ans = Long.MAX_VALUE;
		int x= 0;
		int y=0;
		while((x<N) && (y<M)) {
			ans = Math.min(ans, Math.abs(arrN[x]-arrM[y]));
			//小さい方のindexを追加する
			if(arrN[x] > arrM[y])
				y++;
			else
				x++;
		}
		
		return ans;
	}
	
	public static long  slove3() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		int[] arrN = new int[N];
		int[] arrM = new int[M];
		strs  = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arrN[i] = Integer.parseInt(strs[i]);
		}
		
		strs = reader.readLine().split(" ");
		reader.close();
		for(int i=0;i<M;i++) {
			arrM[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(arrN);
		Arrays.sort(arrM);
		long ans = Long.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int left = -1;
			int right = M;
			while(right-left >1) {
				int mid= (left+right)/2;
				if(arrM[mid] >arrN[i]) {
					right = mid;
				}else if(arrM[mid]<arrN[i]){
					left = mid;
				}else {
					return 0;
				}
			}
			long tmp;
			if(right == M) {
				tmp = Math.abs(arrN[i]-arrM[left]);
			}else if(left == -1) {
				tmp = Math.abs(arrN[i]-arrM[right]);
			}else{
				tmp = Math.min(Math.abs(arrN[i]-arrM[left]),Math.abs(arrN[i] - arrM[right]));
			}
			ans = Math.min(ans, tmp);
		}
		
		return ans;
	}
}
