package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner180_D {

	public static void main(String[] args) throws IOException {
		
		long ans = slove();
		System.out.println(ans);
	}
 
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long x = Long.parseLong(strs[0]);
		long y = Long.parseLong(strs[1]);
		long  a = Long .parseLong(strs[2]);
		long b = Long.parseLong(strs[3]);
		long ans = (y-x)/b;
		if((x-y)%b == 0) {
			ans --;
		}
		int i=0;
		//オーバーフロー対策 && yを超えないように
		while((double)a*x<=2e18 && a*x<y) {
			x*=a;
			i++;
			long tmp = i+(y-x)/b;
			//bで割り切れた場合は-1
			if((y-x)%b ==0) {
				tmp--;
			}
			ans = Math.max(ans, tmp);
		}
//		long difference = y-x-1;
//		long ans =0;
//		int aCnt = 0;
//		long tmpY = y;
//		tmpY/=a;
//		while(tmpY > x) {
//			aCnt++;
//			tmpY /= a;
//		}
//		
//		for(int i=aCnt; i>=0;i--) {
//			long tmp = i;
//			long tmp2 =  (long) (y-x*Math.pow(a, i));
//			tmp += tmp2 /b;
//			if(tmp2%b==0)
//				tmp --;
//			ans = Math.max(ans, tmp);
//		}
//		ans = Math.max(ans, difference/b);
//		return ans;
		
//		while((double)a*x<=2e18 && a*x<=x+b && a*x<y){
//			x*=a;
//			ans++;
//		}
//		ans+=(y-1-x)/b;
		return ans;
	}
}
