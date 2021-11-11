package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q001_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int L = Integer.parseInt(strs[1]);
		final int K = Integer.parseInt(reader.readLine());
		strs = reader.readLine().split(" ");
		reader.close();
		int[] eachLength = new int[N];
		int[] points = new int[N];
		points[0] = Integer.parseInt(strs[0]);
		eachLength[0] = points[0];
		
		for(int i=1;i<N;i++) {
			points[i] = Integer.parseInt(strs[i]);
			eachLength[i] = points[i]-points[i-1];
		}
//		eachLength[N-1]+=L-points[N-1];
		
		long ans = binarySearch(eachLength, K, L);
		
		return ans;
	}
	
	private static long binarySearch(int[] arr,int k,int total) {
		long ok = -1;
		long ng = total+1;
		while(ng - ok > 1) {
			long mid = (ok +ng)/2;
			if(checkPossible(arr,mid,k,total)) {
				ok=mid;
			}else {
				ng = mid;
			}
			
		}
		return ok;
	}
	
	private static boolean checkPossible(int[] arr,long length,int k,long total) {
		//無理なものはスキップ
		if(total/k < length)
			return false;
		//分けた回数
		int cnt =0;
		//判定中の区間の長さ
		int tmp =0;
		//使った長さの合計
		long used = 0;
		for(int i:arr) {
			//区間が指定した数値以上なら区切る
			if(tmp+i>=length && total-(tmp+i + used)>=length) {
				cnt++;
				used+= tmp+i;
				tmp=0;
			}
			else
				tmp+=i;
		}
		//k回以上区切れたか
		return cnt>=k;
	}
}
