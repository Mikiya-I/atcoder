package algorithm;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
	//地点間の距離
	int distance[][];
	//地点数
	int point;
	int startPoint;
	int goalPoint;
	//出発地点から目的地までの最短経路の経由順
	int[] minRoute;
	//出発地点から各地点までの最短距離
	int[] minDistances;
	//その地点への最短経路が確定されているか
	boolean[] fixed;
	//パス
	Map<Integer,Set<Integer>> path;
	
	public Dijkstra(int[][] dist,int start,int goal) {
		Arrays.fill(minDistances, -1);
		distance = dist;
		startPoint = start;
		goalPoint = goal;
	}
		
	//ゴール地点まで
	public void toGoal() {
		PriorityQueue<Node> nodes = new PriorityQueue<Node>();
		//キューにスタート地点を追加する
		nodes.add(new Node(startPoint, 0));
		
		while(!nodes.isEmpty()) {
			//キュー内の最小値の地点
			Node current = nodes.poll();
			int tmpStartPoint = current.point;
			//既に確定済みのものに関してはスキップ
			if(fixed[tmpStartPoint])
				continue;
			fixed[startPoint]=true;
			//目的地が確定済みなら終わり
			if(fixed[goalPoint])
				break;
			//キューにスタート地点から繋がっている地点を入れる。入っているものに関しては更新
			for(int adjacent:path.get(startPoint)) {
				int tmpDist = distance[startPoint][tmpStartPoint]+distance[tmpStartPoint][adjacent];
				//未確定の地点の中で最短経路を更新したものか初めて見つかった地点
				if(!fixed[adjacent] && (minDistances[adjacent]>tmpDist || minDistances[adjacent] == -1)) {
					minDistances[adjacent] = tmpDist;
					nodes.add(new Node(adjacent, tmpDist));
				}
			}
			
		}
	}
	
	//行ける所まで
	public void calcAll() {
		PriorityQueue<Node> nodes = new PriorityQueue<Node>();
		//キューにスタート地点を追加する
		nodes.add(new Node(startPoint, 0));
		
		while(!nodes.isEmpty()) {
			//キュー内の最小値の地点
			Node current = nodes.poll();
			int tmpStartPoint = current.point;
			//既に確定済みのものに関してはスキップ
			if(fixed[tmpStartPoint])
				continue;
			fixed[startPoint]=true;
			//キューにスタート地点から繋がっている地点を入れる。入っているものに関しては更新
			for(int adjacent:path.get(startPoint)) {
				int tmpDist = distance[startPoint][tmpStartPoint]+distance[tmpStartPoint][adjacent];
				if(!fixed[adjacent] && minDistances[adjacent]>tmpDist ) {
					minDistances[adjacent] = tmpDist;
					nodes.add(new Node(adjacent, tmpDist));
				}
			}
		}
	}
}

//ノード
class Node implements Comparable<Node> {

  int point;
  long distanceFromStart;

  public Node(int t, long m) {
      point = t;
      distanceFromStart = m;
  }

  @Override
  public int compareTo(Node o) {
      int res = -1;
      if (this.distanceFromStart - o.distanceFromStart >= 0) {
          res = 1;
      }
      return res;
  }
}