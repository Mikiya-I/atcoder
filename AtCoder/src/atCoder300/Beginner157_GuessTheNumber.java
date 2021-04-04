package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beginner157_GuessTheNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Beginner157_GuessTheNumber This = new Beginner157_GuessTheNumber();
		int ans =This.slove();
		System.out.println(ans);
	}

	public int slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N  = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);

		int[] arr = new int[N];
		Arrays.fill(arr, -1);

		for(int i=0;i<M;i++) {
			String str[] = reader.readLine().split(" ");
			int index = Integer.parseInt(str[0])-1;
			int val = Integer.parseInt(str[1]);
			if(arr[index] != -1 && arr[index] != val)
				return -1;
			if(N !=1 && (index ==0 && val ==0))
				return -1;
			arr[index] =val;
		}

		for(int i= 0;i<N;i++) {
			if(arr[i] == -1) {
				if(i ==0 && arr.length != 1)
					arr[i] =1;
				else
					arr[i] =0;
			}
		}

		int ans =0;
		for(int i=0;i<N;i++) {
			ans += arr[i] *Math.pow(10, N-i-1);
		}
	return ans;
	}
}
