package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Beginner229_D {
	static char[] s;
	static int K;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
//		slove();
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		s = reader.readLine().toCharArray();
		K = Integer.parseInt(reader.readLine());
		reader.close();
	}

	public static int slove() throws IOException {
		int ans = 0;
		ArrayDeque<Character> que = new ArrayDeque<Character>();
		int dotCnt = 0;
		//追加する要素のindex
		int tmpIdx = 0;
		while(dotCnt <= K && tmpIdx<s.length) {
			if(s[tmpIdx] == '.') {
				if(dotCnt ==K) {
					break;
				}
				dotCnt++;
			}
			que.add(s[tmpIdx]);
			tmpIdx++;
		}
		ans = que.size();
		for(int i=0;i<s.length && tmpIdx<s.length;i++) {
			tmpIdx = Math.max(tmpIdx, i);
			if(que.size()> 0) {
				if(que.poll() == '.')
					dotCnt --;
			}
			while(tmpIdx<s.length && dotCnt <= K) {
				if(s[tmpIdx] == '.') {
					if(dotCnt == K) {
						break;
					}
					dotCnt++;
				}
				que.add(s[tmpIdx]);
				tmpIdx++;
			}
			ans = Math.max(ans, que.size());
			}
		
		return ans;
	}
}

