package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Beginner164_MultipleOf2019 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] n = reader.readLine().toCharArray();
		int length = n.length;
		int [] mods = new int[2019];//余りの数の格納用(0~2018)
		mods[0]++;//一つも取り除かない(場合は0として扱う)

		int mod=0;
		for(int i=length-1;0<=i;i--) {
			int current= n[i]-'0';

			mods[mod]++;
		}


		long ans =0;
		for(int  i:mods) {
			if(i<1)
				ans+=i*(i-1)/2;
		}
//		int[] mods = new int[2019]; // there are 2019 possible mods, we have to accout for each one of them
//        int number = 0;
//        long ans = 0;
//        for (int i=n-1; i>=0; i--){
//            int curr = s.charAt(i)-'0';
//            number = (number+curr*pot)%mod; // Taking a mod wouldn't effect our answer, since all we are working with is mods, not the acual val
//            ans += mods[number];
//            if (number == 0){
//                ans++;
//            }
//            mods[number]++;
//            pot = (pot*10)%mod;
//        }

		System.out.println(ans);
	}
}