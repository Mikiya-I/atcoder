package atcoder90;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q002_2 {
	public static void main(String[] args) throws IOException {
//		slove();
		System.out.println(slove());
	}
	
	public static String slove() throws  IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(reader.readLine());
		PriorityQueue<String> ans = new PriorityQueue<String>();
//		List<String> ans = new ArrayList<String>();
		reader.close();
		//奇数だったら出力無し
		if(N%2 == 1) {
			return "";
		}
		//2のN乗通り
		int loop = 1<<N;
		for(int i=1;i<loop;i++) {
			//bitが立っている場所がNの半分ではない場合はスキップ
			if(Integer.bitCount(i) != N/2)
				continue;
			String str = generateString(i, N);
			if(isPair(str))
				ans.add(str);
		}
//		for(String s:ans)
//			sb.append(s + "\n");
		while(ans.size() >0)
			sb.append(ans.poll() + "\n");
		
		return sb.toString();
	}
	static String generateString(int tmp,int N) {
		char[] str = new char[N];
		for(int i=0;i<N;i++) {
			if(((tmp>>i)&1) == 1)
				str[i]= '(';
			else
				str[i]=')';
		}
		return String.valueOf(str);
	}
	
	static boolean isPair(String str) {
		int left= 0;
		int right = 0;
		for(char c:str.toCharArray()) {
			if(c=='(')
				left ++;
			else if(left > right)
				right++;
		}
		return left == right;
	}
}
