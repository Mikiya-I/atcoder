package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Beginner223_D {

	public static void main(String[] args) throws IOException {
		//		long  ans = slove();
				slove();
//		System.out.println(slove2());
	}

	public static void slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		UnionFind223 uf = new UnionFind223(9);
		final int M = Integer.parseInt(reader.readLine());
		Map<Integer,Set<Integer>> path = new HashMap<Integer, Set<Integer>>();
		for(int i=0;i<10;i++) {
			path.put(i,new HashSet<Integer>());
		}
		for(int i=0;i<M;i++) {
			String[] strs = reader.readLine().split(" ");
			int u= Integer.parseInt(strs[0]);
			int v = Integer.parseInt(strs[1]);
			path.get(u).add(v);
			path.get(v).add(u);
			uf.unite(u, v);
		}
		int[] currentPos = new int[9];
		String[] strs =reader.readLine().split(" ");
		for(int i=1;i<9;i++) {
			currentPos[i] = Integer.parseInt(strs[i-1]);
		}
		reader.close();
		
		for(int i=1;i<9;i++) {
			int number = i;
			int position = currentPos[i];
			if(!uf.same(number,position)) {
				System.out.println(-1);
				return;
			}
		}
		
		
		
	}
}

class UnionFind223 {
	//親要素を保持する配列
    int[] parents;
    int[] rank;
    int[] size;
    
    public UnionFind223(int n) {
        this.parents = new int[n+1];
        this.rank = new int[n+1];
        this.size = new int[n+1];
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
