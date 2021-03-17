package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner164_MultipleOf2019 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] n = reader.readLine().toCharArray();
		int length = n.length;
		int[] mods = new int[2019];//余りの数の格納用(0~2018)
		mods[0]++;//一つも取り除かない(場合は0として扱う)

		int mod = 0;
		int num = 0 ;//??
		int pot = 1;//??
		long ans = 0;

		for (int i = length-1; i>=0; i--) {
			int current = n[i] - '0';
			num += current * pot;
			mod = num%2019;
			mods[mod]++;
			pot*=10;
			pot%= 2019;
		}
		for(int i:mods)
			ans += i*(i-1)/2;

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