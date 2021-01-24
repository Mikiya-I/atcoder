package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WalkingTakahashi {


	  public static void main( String[] args ) throws IOException{

	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

	    //配列として扱う場合
	    String[] ints = StringUtils.split(reader.readLine()," ");

	    long x = Math.abs(Long.parseLong(ints[0]));
	    long k = Long.parseLong(ints[1]);
	    long d = Long.parseLong(ints[2]);

	    long a = x/d;
    	long b = Math.abs(x-d*a);//正の値で考えられる最小値

	    if(k<=a) {
	    	System.out.println(x-d*k);
	    	return;
	    }else{
	    	long c = Math.abs(b-d);//負の値の最大値
	    	if(b==c) {
	    		System.out.println(b);
	    		return;
	    	}
	    	long min = b<=c?b:c;
//	    	minがBの時、(k-a)/2余りが0 minがCの時、(k-a-1)/2の余りが1の時(最小はCだがCで止まれない場合)　Bを出力
	    	if((min==b&&(k-a)%2==0)||(min==c&&(k-a-1)%2==1)) {
	    		System.out.println(b);
	    		return;
	    	}else {
	    		System.out.println(c);
	    		return;
	    	}
	    }

	  }
}









	/**
	 * 文字列操作に関するユーティリティクラス
	 *
	 * Copyright (c) 2015 javasampleokiba
	 *
	 * This source code is released under the MIT License.
	 * http://opensource.org/licenses/mit-license.php
	 */
		class StringUtils {

	    /**
	     * 文字列を指定された文字列で分割します。
	     *
	     * @param str          分割対象の文字列
	     * @param delimiter    分割する文字列
	     * @return 分割された文字列配列
	     */
	    public static String[] split(String str, String delimiter) {
	        return split(str, delimiter, 0);
	    }

	    /**
	     * 文字列を指定された文字列で分割します。
	     *
	     * @param str          分割対象の文字列
	     * @param delimiter    分割する文字列
	     * @param limit        最大分割数 (0を指定した場合は可能な限りすべて分割し、負の値を指定した場合は文字列の後方から分割します)
	     * @return 分割された文字列配列
	     */
	    public static String[] split(String str, String delimiter, int limit) {
	        List<String> result = new ArrayList<String>();
	        int delimiterLen = delimiter.length();
	        if (limit == 0) limit = str.length();

	        if (limit > 0) {
	            int start = 0;
	            int end = 0;
	            for (int i = 1; i < limit; i++) {
	                end = str.indexOf(delimiter, start);
	                if (end < 0) break;
	                result.add(str.substring(start, end));
	                start = end + delimiterLen;
	            }
	            result.add(str.substring(start));

	        } else {
	            int start = 0;
	            int end = str.length();
	            for (int i = -1; i > limit; i--) {
	                start = str.lastIndexOf(delimiter, end - 1);
	                if (start < 0) break;
	                result.add(str.substring(start + delimiterLen, end));
	                end = start;
	            }
	            result.add(str.substring(0, end));
	        }
	        return result.toArray(new String[0]);
	    }

	    /**
	     * 文字列を指定された文字列でint型配列に分割します。
	     *
	     * @param str          分割対象の文字列
	     * @param delimiter    分割する文字列
	     * @return 分割されたint型配列
	     */
	    public static int[] splitToInt(String str, String delimiter) {
	        return splitToInt(str, delimiter, 10);
	    }

	    /**
	     * 文字列を指定された文字列でint型配列に分割します。
	     * 基数を指定することで10進数以外の数値文字列も分割できます。
	     *
	     * @param str          分割対象の文字列
	     * @param delimiter    分割する文字列
	     * @param radix        基数
	     * @return 分割されたint型配列
	     */
	    public static int[] splitToInt(String str, String delimiter, int radix) {
	        String[] strs = split(str, delimiter);
	        int[] result = new int[strs.length];
	        for (int i = 0; i < result.length; i++) {
	            result[i] = Integer.parseInt(strs[i], radix);
	        }
	        return result;
	    }
	}


