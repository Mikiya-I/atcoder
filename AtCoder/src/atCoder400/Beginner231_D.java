package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Beginner231_D {
	static int[][] path;
	static ArrayDeque<Integer> que ;
	static boolean[] used;
	
	static Map<Integer,Set<Integer>> map ;

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
//				slove();
		System.out.println(slove());
	}

	public static String slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		map = new HashMap<>();
		for(int i= 0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			if(!map.containsKey(a)) {
				map.put(a, new HashSet<Integer>());
			}
			map.get(a).add(b);
			
			if(!map.containsKey(b)) {
				map.put(b ,new HashSet<Integer>());
			}
			map.get(b).add(a);
		}
		
		//2つの条件を持つ要素の数
		int cntTwo = 0;
		HashSet<Integer> startPoint = new HashSet<Integer>();
		for(int key:map.keySet()) {
			int tmp = map.get(key).size();
			if(tmp > 2) {
				return "No";
			}else if(tmp==2){
				cntTwo++;
			}else if(tmp==1) {
				startPoint .add(key);
			}
		}
//		if(cntTwo > N-2)
//			return "No";
		
		used = new  boolean[N+1];
		que = new ArrayDeque<Integer>();
		
		for(int i:startPoint) {
			que.add(i);
			dfs();
		}
		for(int i=1;i<N+1;i++) {
			if(!used[i] && map.get(i) != null)
				return "No";
		}
		
		return "Yes";
	}
	static void dfs() {
		while(que.size()>0) {
			int tmp=que.pop();
			used[tmp]=true;
			for(int i: map.get(tmp)) {
				if(!used[i]) {
					que.add(i);
					dfs();
				}
			}
		}
	}
	
	public static String slove2() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);
		UnionFind231 uf = new UnionFind231(N);
		for(int i= 0;i<M;i++) {
			strs = reader.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			uf.unite(a, b);
			
		}
		
		HashSet<Integer> treeCnt = new  HashSet<Integer>();
		for(int i=0;i<=N;i++) {
			if(uf.parents[i] != i) {
				treeCnt.add(uf.parents[i]);
			}
			if(uf.neighbors[i]>2)
				return "No";
		}
		
		
		return "Yes";
	}
}

class UnionFind231 {
	//親要素を保持する配列
    int[] parents;
    int[] rank;
    int[] size;
    //直接繋がっている要素の数
    int[] neighbors;
    
    public UnionFind231(int n) {
        this.parents = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];
        this.neighbors = new int[n+1];
        //初期値は自身が根&サイズ(繋がっている要素の数)とランク(木の高さ)は1
        for(int i=0;i<=n;i++){
            parents[i] = i;
            rank[i] =1;
            size[i] = 1;
        }
    }

    //要素の根を求める
    public int root(int x){
       while(parents[x] != x)
    	   x = parents[x];
       return x;
    }

    //xとyの木を結合
    boolean unite(int x, int y) {
    	int rootX = root(x);
    	int rootY = root(y);
    	//そもそも同じ木だったら何もしない
    	if(rootX == rootY )
    		return false;
    	//直接繋がっている要素を追加
    	neighbors[x]++;
    	neighbors[y]++;
    	
    	//結合(ランクが大きい方に小さい方を繋げる)
    	if(rank[rootX] > rank[rootY]) {
    		parents[rootY] = rootX;
    		size [rootX] += size[rootY];
    	}else {
    		if (rank[rootX] == rank[rootY])
    			rank[rootY]++;
			parents[rootX] = rootY;
			size[rootY] += size[rootX];
    	}
    	return true;
    }

    //要素x,yが同じグループに属するかどうかの判定
    boolean  same(int x ,int y) {
    	int rootX = root(x);
    	int rootY = root(y);
    	return rootX == rootY;
    }

    //サイズの取得
    int getSize(int x) {
    	return size[parents[x]];
    }
	
}


