package atCoder300;

import java.io.IOException;
import java.util.Random;


public class AAATest {

	public static void main(String[] args) throws Exception {
		Random rand = new Random();
		Beginner196_Doubled test = new Beginner196_Doubled();
		while(true) {
			long R = (long) (Math.abs(rand.nextLong())%1e12);
			String str = String.valueOf(R);
			try {
				long ans =test.slove(str);
				int ans2 = test.slove2(str);
				if(ans != ans2) {
					System.out.println(str);
					System.out.println(ans);
					System.out.println(ans2);
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(str);
			}
		}
	}
}


