package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner194_SquaredError {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());

		String strs[] = reader.readLine().split(" ");
		long array[] = new long[N];
		long sum[] = new long[N];//累積和
		long array2[] = new long[N];//2乗の配列
		long sum2[] = new long[N];//2乗の累積和
		long first = Long.parseLong(strs[0]);
		array[0] = first;
		array2[0] = first*first;
		sum[0] = first;
		sum2[0]= first*first;
		for(int i=1;i<N;i++) {
			long tmp = Long.parseLong(strs[i]);
			array[i] = Long.parseLong(strs[i]);
			array2[i] = tmp*tmp;
			sum[i] = sum[i-1]+tmp;
			sum2[i]= sum2[i-1]+tmp*tmp;
		}

		long ans =0;
		for(int i=0;i<N-1;i++) {
			long param1 = array2[i]*(N-i-1);
			long param2 = 2*array[i]*(sum[N-1]-sum[i]);
			long param3 = sum2[N-1]-sum2[i];
			ans+= param1-param2+param3;
		}
		System.out.println(ans);
	}

}
