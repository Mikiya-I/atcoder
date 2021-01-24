package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Beginner188_SnukePrime {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		StringTokenizer token = new StringTokenizer(reader.readLine());

		int N = Integer.parseInt(token.nextToken());
		long C = Long.parseLong(token.nextToken());

		ArrayList<Pair> list = new ArrayList<Pair>();

		//何日目に料金が変化するか(以下イベント)をlistにする(開始日に料金追加,終了日の翌日に料金を引く(解役したためその分の料金がなくなる))
		for(int i=0;i<N;i++) {
			token = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			long c = Long.parseLong(token.nextToken());
			list.add(new Pair(a,c));
			list.add(new Pair(b+1, -c));
		}

		//日にち順にソート
		list.sort(Comparator.comparing(Pair::getEventDate));

		long sum=0;
		int currentDate=0;
		long currentFee =0;
		for(Pair current :list) {
			//日にちが変わった時に前回のイベントからの料金を合計
			if(current.eventDate!=currentDate) {
				sum += Math.min(C,currentFee ) * (current.eventDate-currentDate);
				currentDate = current.eventDate;
			}
			currentFee += current.cost;
		}

		System.out.println(sum);

	}
}

class Pair{
	int eventDate;
	long cost;

	public Pair(int a,long b) {
		eventDate =a;
		cost =b;
	}

	int getEventDate() {
		return eventDate;
	}
}