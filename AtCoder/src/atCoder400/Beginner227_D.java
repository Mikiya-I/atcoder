package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Beginner227_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
				slove();
//		System.out.println(slove2());
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs = reader.readLine().split(" ");
		long ans = 0;
		final int N = Integer.parseInt(strs[0]);
		final int K = Integer.parseInt(strs[1]);
		
		long[] arr = new long[N];
		//何人の部署が何個あるか(降順)
		TreeMap<Long,Integer> map = new TreeMap<Long, Integer>(
					(s1, s2) -> s1<s2?1:-1
		);
		strs = reader.readLine().split(" ");
		for(int i=0;i<N;i++) {
			long l = Long.parseLong(strs[i]);
			arr[i] = l;
			if(!map.containsKey(l))
				map.put(l, 1);
			else
				map.remove(l, map.get(l)+1);
		}
		//今使っている部の人数
		PriorityQueue<Long> que = new PriorityQueue<Long>();
		for(int i=0;i<K;i++) {
			que.add(arr[N-i-1]);
		}
		int key = N-K-1;
		//使い終わった部の数
		int used = 0;
		Arrays.sort(arr);
		while(key >=K-1) {
			long min = que.peek();
			ans += min;
			PriorityQueue<Long> newQue = new PriorityQueue<Long>();
			while(que.size()>0) {
				long tmp = que.poll()-min;
				if(tmp>0)
					que.add(tmp);
				else {
					used++;
				}
			}
			for(int i=0;i<used;i++) {
				if(N-i-key-1 <K)
					break;
				newQue.add(arr[N-i-key-1]);
			}
			key+= used;
		}
		
//		System.out.println(sb.toString());
	}
}

