package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beginner191_CircleLatticePoints {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		//小数だと誤差が出る
		long x = (long) (Double.parseDouble(token.nextToken())*1000);
		long y = (long) (Double.parseDouble(token.nextToken())*1000);
		long r = (long) (Double.parseDouble(token.nextToken())*1000);

		long xx = (x-r)/1000*1000;
		long X = (r+x)/1000*1000;

		int ans = 0;
		for(long i = xx;i<=X;i+=1000) {
			double R = Math.pow(r,2);
			double yy = Math.pow(Math.abs(i)-x,2);
			double XY =Math.sqrt(R-yy);
			ans += Math.abs(2*XY/1000);
			if(Math.abs(y%1000) <= Math.abs(XY%1000)) {
				ans++;
			}
		}

		System.out.println(ans);
	}
}