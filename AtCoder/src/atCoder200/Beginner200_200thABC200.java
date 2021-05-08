package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner200_200thABC200 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner200_200thABC200 This = new Beginner200_200thABC200();
		String ans =This.slove();
		System.out.println(ans);
	}

	public String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		
		String ans = String.valueOf(N);
		for(int i=0;i<K;i++) {
			if(Long.parseLong(ans)%200 != 0) {
				ans += "200";
			}else {
				ans = String.valueOf(Long.parseLong(ans)/200);
			}
		}
		
		return ans;
	}
}
