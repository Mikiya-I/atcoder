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
		StringBuilder sb = new StringBuilder();
		Deque<String> que = new ArrayDeque<String>();
		que.add(reader.readLine());
		final int Q = Integer.parseInt(reader.readLine());
		boolean reverse = false;
		for(int i=0;i<Q;i++) {
			String[] str = reader.readLine().split(" ");
			if(str.length==1) {
				reverse = !reverse;
			}else {
				//末尾に追加
				if((reverse && str[1].equals("1")) || (!reverse && str[1].equals("2"))) {
					que.add(str[2]);
				}else {
					que.addFirst(str[2]);
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
