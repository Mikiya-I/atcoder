package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Beginner207_C{
	public static void main(String[] args) throws NumberFormatException, IOException {
		 
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(reader.readLine());
		double[][] arr = new double[N][2];
//		long[][] arr = new long[N][3];
		for(int i= 0;i<N;i++) {
			String[] strs = reader.readLine().split(" ");
			int t = Integer.parseInt(strs[0]);
			if(t==1) {
				arr[i][0] = Double.parseDouble(strs[1]);
				arr[i][1] = Double.parseDouble(strs[2]);
			}else if(t==2) {
				arr[i][0] = Double.parseDouble(strs[1]);
				arr[i][1] = Double.parseDouble(strs[2])-0.5;
			}else if(t==3) {
				arr[i][0] = Double.parseDouble(strs[1])+0.5;
				arr[i][1] = Double.parseDouble(strs[2]);
			}else {
				arr[i][0] = Double.parseDouble(strs[1])+0.5;
				arr[i][1] = Double.parseDouble(strs[2])-0.5;
			}
//			arr[i][0] = t;
//			arr[i][1] =Long.parseLong(strs[1]);
//			arr[i][2] = Long.parseLong(strs[2]);
		}
		long ans =0;
		for(int i=0;i<N;i++) {
			double iMin = arr[i][0];
			double iMax = arr[i][1];
			for(int j=i+1;j<N;j++) {
				double jMin = arr[j][0];
				double jMax = arr[j][1];
//				if((iMin<= jMax && iMin >= jMin ) ||  (iMax >= jMin && iMax <= jMax )) {
				if(Math.max(iMin, jMin) <= Math.min(iMax, jMax)) {
					ans++;
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			long iMin = arr[i][1];
//			if(arr[i][0] >2) {
//				iMin++;
//			}
//			long iMax = arr[i][2];
//			if(arr[i][0]%2 ==0) {
//				iMax--;
//			}
//			for(int j=i+1;j<N;j++) {
//				long jMin = arr[j][1];
//				if(arr[j][0] >2) {
//					jMin++;
//				}
//				long jMax = arr[j][2];
//				if(arr[i][0]%2 ==0) {
//					jMax--;
//				}
//				if((iMin<= jMax && iMin >= jMin ) ||  (iMax >= jMin && iMax <= jMax )) {
//					ans++;
//				}
//			}
//		}
		return ans;
		}
}
