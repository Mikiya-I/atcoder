package atCoder400;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Beginner157_D {
	public static void main(String[] args) throws IOException {
		slove();
//		String  ans = slove();
//		System.out.println(ans);
	}
	
	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringBuilder sb = new StringBuilder();
		Deque<Character> que = new ArrayDeque<Character>();
		char[]arr = reader.readLine().toCharArray();
		for(char c:arr) {
			que.add(c);
		}
		final int Q = Integer.parseInt(reader.readLine());
		boolean reverse = false;
		for(int i=0;i<Q;i++) {
			String[] str = reader.readLine().split(" ");
			if(str[0].equals("1")) {
				reverse = !reverse;
			}else {
				char c = str[2].charAt(0);
				//末尾に追加
				if(str[1].equals("1")) {
					if(!reverse) {
						que.addFirst(c);
					}else{
						que.add(c);
					}
				}else {
					if(!reverse) {
						que.add(c);
					}else {
						que.addFirst(c);
					}
				}
			}
		}
		if(reverse) {
			while(que.size()>0) {
				writer.append(que.pollLast());
			}
		}else {
			while(que.size()>0) {
				writer.append(que.poll());
			}
		}
		writer.flush();
//		return sb.toString();
	}
}
