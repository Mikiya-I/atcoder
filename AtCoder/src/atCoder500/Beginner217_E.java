package atCoder500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Beginner217_E {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
		//		slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		ArrayDeque<Integer> que2 = new ArrayDeque<Integer>();
		for(int i=0;i<Q;i++) {
			String[] strs = reader.readLine().split(" ");
			if(strs[0].equals("2")) {
				if(que.size()!= 0)
					sb.append(que.poll());
				else
					sb.append(que2.poll());
				sb.append("\n");
			}else if(strs[0].equals("1")){
				int x = Integer.parseInt(strs[1]);
				que2.add(x);
			}else  {
				while(que2.size() != 0)
					que.add(que2.pop());
			}
		}
		
		return sb.toString();
	}
}
