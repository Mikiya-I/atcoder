package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Beginner237_D {
	static int N;
	static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		System.out.println(slove());
	}
	public static void input() throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		arr = reader.readLine().toCharArray();
		reader.close();
	}

	public static String slove() throws IOException {
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> que  = new ArrayDeque<Integer>();
		que.add(N);
		for(int i= N-1;i>= 0;i--) {
			if(arr[i]== 'L') {
				que.add(i);
			}else {
				que.addFirst(i);
			}
		}
		while(que.size()>0) {
			sb.append(que.poll()+ " ");
		}
		return sb.toString();
	}
	
	

}