package atCoder200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGameForTwo {


	public static void main( String[] args ) throws IOException{
	    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
	    String str = reader.readLine();
	    int n  = Integer.parseInt(str);

	    int AliceResult = 0;
	    int BobResult =0;

	    //配列として扱う場合
	    String[] strs = reader.readLine().split(" ");

	    ArrayList<Integer> allList = new ArrayList<>();

	    for(String a :strs) {
	    	int x =(int)Integer.parseInt(a);
	    	allList.add(x);
	    }

//		int elements = allList.size(); //要素数
//		int createListCount = elements/4; //4個の要素で
	    List<ArrayList<Integer>> sort = new ArrayList<ArrayList<Integer>>();

	    for(int i = 0;i<26;i++) {
	    	ArrayList<Integer> array= new ArrayList<>();
	    	sort.add(array);
	    }

	    for(int now : allList) {
	    	int i = now/4;
	    	sort.get(i).add(now);
	    }

	    //各listをソート
	    for(int i= 0;i<25;i++) {
	    	Collections.sort(sort.get(i));
	    }

	    List<Integer> sorted = new ArrayList<>();
	    for(List<Integer> now :sort ) {
	    	sorted.addAll(now);
	    }


	    for(int i = 0;i<=n-1;i++) {
	    	if(i%2==0) {
	    		AliceResult += sorted.get(n-i-1);
	    	}else {
	    		BobResult += sorted.get(n-i-1);
	    	}
	    }

	    System.out.println(AliceResult - BobResult);

	  }
}
