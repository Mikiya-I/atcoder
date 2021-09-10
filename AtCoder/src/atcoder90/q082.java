package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class q082{
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final long L = Long.parseLong(strs[0]);
		final long R = Long.parseLong(strs[1]);
		reader.close();
		long e97 = (long)1e9+7;
		long ans = 0;
		int digits = 0;
		long min = L;
		while(Math.pow(10, digits+1) < L) {
			digits ++;
		}
		
		long max = min;
		while(Math.pow(10, digits+1) <= R) {
			min=Math.max ((long) Math.pow(10, digits), min);
			digits ++;
			max =( (long) Math.pow(10, digits)-1);
			long tmp = ((min%e97 + max%e97))%e97 * ((max- min +1)%e97)/2;
			tmp %= e97;
			tmp *= digits;
			tmp %= e97;
			ans += tmp;
			ans %= e97;
		}
		max = R;
		min = Math.max ((long) Math.pow(10, digits), min);
		long tmp = ((min%e97 + max%e97) %e97) * ((max- min +1)%e97)/2;
		tmp *= digits+1;
		tmp %= e97;
		ans += tmp;
		ans %= e97;
		
		return ans;
	}
	
}