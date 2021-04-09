package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner165_ManyRequirements {
	static long[] fac;
	static int[] num;
	static int max = 0;
	static int N;
	static int M;
	static int Q;
	static int[] a, b, c, d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		Q = Integer.parseInt(strs[2]);

		num = new int[N + 1];
		a = new int[Q];
		b = new int[Q];
		c = new int[Q];
		d = new int[Q];
		for (int i = 0; i < Q; i++) {
			String s[] = reader.readLine().split(" ");
			a[i] = Integer.parseInt(s[0]);
			b[i] = Integer.parseInt(s[1]);
			c[i] = Integer.parseInt(s[2]);
			d[i] = Integer.parseInt(s[3]);
		}
		num[1] = 1;

		dfs(2, 1);
		System.out.println(max);
	}

	//幅優先全探索
	public static void dfs(int index,int now) {
		//最後の値を変え終わった
		if(index > N) {
			int sum = 0;
			//Q個の条件を計算
			for(int i=0;i<Q ;i++) {
				if(num[b[i]]-num[a[i]] == c[i])
					sum+= d[i];
			}
			if(sum > max) 
				max =sum;
				return;
		}
		//index番目の値を変更
		for(int j= now ;j <= M;j++) {
			num[index]=j;
			dfs(index+1,j);
		}
	}
}
