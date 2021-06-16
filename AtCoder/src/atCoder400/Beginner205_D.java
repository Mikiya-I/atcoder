package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Beginner205_D {
	static long[] nums;
	static HashMap<Integer, Integer> nextNums;
	public static void main(String[] args) throws IOException {
		
		String ans = slove2();
		System.out.println(ans);
	}
	
	public static String slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] strs = reader.readLine().split(" ");
		final int N =Integer.parseInt(strs[0]);
		final int Q = Integer.parseInt(strs[1]);
		String[] strs2 = reader.readLine().split(" ");
		nums = new long[N+1];
		for(int i=0;i<N;i++) {
			nums[i] = Long.parseLong(strs2[i]);
		}
		nums[N] =(long)1e18+1;
		Arrays.sort(nums);
		//numsのi番目の要素までに何個の数が見つかっているか(累積和)
		long[][] interval = new long[N + 1][2];
        interval[0][0] = 0;
        interval[0][1] = nums[0] - 1;
        for (int i = 0; i < N; i++) {
            interval[i + 1][0] = nums[i] - interval[i][1];
            interval[i + 1][1] = nums[i + 1] - nums[i] - 1 + interval[i][1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            long K = Long.parseLong(reader.readLine());
            int l = 0;
            int r = N;
            //二分探索木で
            while (l < r) {
                int m = l + r >> 1;
                if (interval[m][1] < K) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            long ans = interval[l][0] + K;
            sb.append(ans+"\n");
        }
		return sb.toString();
	}
 
//	public static String  slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		final String[] strs = reader.readLine().split(" ");
//		final int N =Integer.parseInt(strs[0]);
//		final int Q = Integer.parseInt(strs[1]);
//		String[] strs2 = reader.readLine().split(" ");
//		nums = new long[N];
//		for(int i=0;i<N;i++) {
//			nums[i] = Long.parseLong(strs2[i]);
//		}
//		Arrays.sort(nums);
//		StringBuilder sb = new StringBuilder();
//		//numsのi番目の要素までに何個の数が見つかっているか(累積和)
//		long[][] interval = new long[N + 1][2];
//        interval[0][0] = 0;
//        interval[0][1] = nums[0] - 1;
//        for (int i = 0; i < N; i++) {
//            interval[i + 1][0] = nums[i] - interval[i][1];
//            interval[i + 1][1] = nums[i + 1] - nums[i] - 1 + interval[i][1];
//        }
//        //Kを読み込み&ソート
//        long[] K = new long[Q];
//        //Kの順番を保持
//        HashMap<Long,Integer> kOrder = new  HashMap<Long,Integer>();
//        for(int i=0;i<Q;i++) {
//        	K[i] = Long.parseLong(strs[i]);
//        	kOrder.put(K[i], i);
//        }
//        long[] origin = K.clone();
//        Arrays.sort(K);
//        for(int i=0;i<N;i++) {
//        	sb.append();
//        }
//        
//		return sb.toString();
//	}
	
//	public static String  slove() throws IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		final String[] strs = reader.readLine().split(" ");
//		final int N =Integer.parseInt(strs[0]);
//		final int Q = Integer.parseInt(strs[1]);
//		String[] strs2 = reader.readLine().split(" ");
//		nums = new long[N];
//		for(int i=0;i<N;i++) {
//			nums[i] = Long.parseLong(strs2[i]);
//		}
//		Arrays.sort(nums);
//		StringBuilder sb = new StringBuilder();
//		long[] find = new long[Q];
//		for(int i=0;i<Q;i++ ) {
//			find[i] = Long.parseLong(reader.readLine());
//		}
//		//何番目の項目が何番目にスタートするか
//		long[] notFoundStart = new long[N];
//		for(int i= 0,j=0;i<N;i++) {
//			if(j != nums[i]) {
//				
//			}
//			nums[i] = j;
//		}
//		for(int i= 0;i<Q;i++) {
//			//開始位置をどう決めるか?
//			sb.append(findVal(find[i],0)+"\n");
//		}
//		return sb.toString();
//	}
	public static long findVal(long val,int index) {
		for(int i=index;i<nums.length;i++) {
			if(nums[i] <= val) {
				val ++;
			}else if(nums[i] > val) {
				break;
			}
		}
		return val;
	}
}
