package atCoderC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Otoshidama {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		String[] strs = reader.readLine().split(" ");

		int n = Integer.parseInt(strs[0]);
		int y = Integer.parseInt(strs[1]);

		y /=1000;

		if(y>10*n) {
			System.out.println("-1 -1 -1");
			return;
		}

		int yen1000 = 0;
		int yen5000 = 0;
		int yen10000= 0;

		int x = y-n;
		boolean ok=false;

		for(int i=0;i<=n;i++) {
			if((x - 9*i)%4 ==0) {
				yen10000 =i;
				yen5000 = (x-9*i)/4;
				yen1000 = n-yen10000-yen5000;
				if(yen1000 >=0 && yen5000 >=0) {
					ok=true;
					break;
				}
			}
		}

		if(!ok) {
			System.out.println("-1 -1 -1");
			return;
		}

		System.out.println(yen10000+" "+yen5000+" "+yen1000);
	}

}
