package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q016_2 {

	static int N;
	static int[] coins;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	static List<HashSet<Integer>> path;
	
	public static void main(String[] args) throws Exception, IOException {
		 input();
		 System.out.println(slove());
	}
	
	static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(reader.readLine());
		String[] strs = reader.readLine().split(" ");
		reader.close();
		coins = new int[3];
		for(int i=0;i<3;i++) {
			coins[i] = Integer.parseInt(strs[i]);
		}
		Arrays.sort(coins);
		
	}

	static long slove() throws IOException {
		int ans = Integer.MAX_VALUE;
		//ありうる一番高いコインの最大値
		int maxA = N/coins[2];
		for(int i=maxA; 0 <= i;i--) {
			//Aを使い終わった後で考えられる二番目に高いコインの最大値
			int remain = N-i*coins[2];
			int maxB = remain /coins[1];
			for(int j = maxB; 0<= j;j--) {
				if( (remain - j*coins[1]) % coins[0] ==0 ) {
					ans = Math.min(i +j + (remain - j*coins[1])/coins[0] ,ans);
				}
			}
		}
		
		return ans;
    }
	
}