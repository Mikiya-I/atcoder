package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class One_SAT {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String str = reader.readLine();
		int n = Integer.parseInt(str);

		HashSet<String> hasNot=new HashSet<String>();
		HashSet<String> has = new HashSet<String>();

		for(int i=0;i<n;i++) {
			String current=reader.readLine();
			if(current.startsWith("!")) {
				has.add(current);
			}else {
				hasNot.add(current);
			}
		}

		if(hasNot.size()==0||has.size()==0) {
			System.out.println("satisfiable");
			return;
		}

		ArrayList<String> list = new ArrayList<String>(hasNot);
		ArrayList<String> notList = new ArrayList<String>(has);

		Collections.sort(list);
		Collections.sort(notList);
		
		int nextStart =0;

		for(String current:list) {
			for(int index=nextStart;index<notList.size(); ) {

				if(current.equals(notList.get(index).substring(1))) {
					System.out.println(current);
					return;
				}

				//not側の文字が後になったら判定打ち切り&打ち切った時点でのindexを取得し次はそこから始める
				if(current.compareTo(notList.get(index).substring(1))<0) {
					nextStart = index;
					break;
				}
				index ++;
			}
		}
		System.out.println("satisfiable");
	}

}
