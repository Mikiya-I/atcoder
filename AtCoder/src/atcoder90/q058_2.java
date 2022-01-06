package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class q058_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static long slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		long n = Long.parseLong(strs[0]);
		long K = Long.parseLong(strs[1]);
		reader.close();
		int cnt = 0;
		boolean[] used = new boolean[100001];
		ArrayDeque<Long> que = new ArrayDeque<Long>();
		//K回行うかループに入ったら終了
		while(cnt <K) {
			n = buttonA(n);
			if(used[(int) n])
				break;
			que.add(n);
			used[(int) n] = true;
			cnt ++;
		}
		//K回行った場合は最後の要素を返す
		if(cnt == K)
			return que.getLast();
		
		//ループに入るまでの回数を数える(残ったqueのsizeがループ部分の大きさ)
		while(que.size()>0) {
			if(n == que.peek())
				break;
			else {
				que.pop();
				K--;
			}
		}
		long remain = K%que.size();
		if(remain == 0) {
			return que.getLast();
		}
		for(int i=0;i<remain-1;i++) {
			que.pop();
		}
		
		return que.pop();
	}
	
	static long buttonA(long x) {
		long y = 0;
		long originX = x;
		while(x>0) {
			y += x%10;
			x/= 10;
		}
		return (originX+y)%100000;
	}
}
