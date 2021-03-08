package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner194_SquaredError2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int  N = Integer.parseInt(reader.readLine());

		String strs[] = reader.readLine().split(" ");
		//全部で401パターンしかないからそれぞれの値の出現回数を保持
		long array[] = new long[401];

		for(int i=0;i<N;i++)
			//負の数は添え字にできないから+200する(後で引くから問題なし)
			array[Integer.parseInt(strs[i])+200]++;

		//2つの数のパターンを計算
		long ans =0;
		for(int i=0;i<401;i++) {
			//例によって省略用
			if(array[i] ==0)
				continue;
			for(int j=i;j<401;j++) {
				ans += (i-j)*(i-j)*array[i]*array[j];
			}
		}
		System.out.println(ans);
	}
}
