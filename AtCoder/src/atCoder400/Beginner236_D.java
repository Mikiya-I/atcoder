package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner236_D {
	static int N;
	static long[][] A;
	static long ans;
	static boolean[] used;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(slove());
	    return;
	}

	public static void input() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		A = new long[2*N][2*N];
		for(int i=0;i<2*N -1;i++) {
			String[] strs = reader.readLine().split(" ");
			for(int j=0;j<strs.length;j++) {
				A[i][i+j+1] = Integer.parseInt(strs[j]);
			}
		}
		reader.close();
	}

	//Aからi,jがともに被らないものを全探索
	//この時i<j
	public static long slove() throws IOException {
		used = new boolean[2*N];
		ans = 0;
		dfs(0,0,0);
		return ans;
	}
	
	static void dfs(int pairNo,int firstPerson,long sum) {
		//全員使った場合は最大値を更新
		if(pairNo==N) {
			ans = Math.max(ans, sum);
			return ;
		}
		//使われていたら次の人
		if(used[firstPerson]) {
			dfs(pairNo,firstPerson+1,sum);
		}else {
			used[firstPerson] = true;
			for(int i=firstPerson +1 ;i<(2*N);i++) {
				if(!used[i]) {
					used[i] = true;
					//1人目とペアを組み、次のペアを組み始める
					dfs(pairNo + 1,firstPerson +1,sum ^ A[firstPerson][i]);
					used[i] = false;
				}
			}
			used[firstPerson] = false;
		}
	}
}