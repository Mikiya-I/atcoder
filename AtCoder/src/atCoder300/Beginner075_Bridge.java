package atCoder300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner075_Bridge {

	public static void main(String[] args) throws NumberFormatException, IOException {

		long ans = slove();
		System.out.println(ans);
	}

	public static long  slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = reader.readLine().split(" ");
		final int N = Integer.parseInt(strs[0]);
		final int M = Integer.parseInt(strs[1]);

		//M本の辺を保持
		int[][] edge = new int[M][2];
		for(int i= 0;i<M;i++) {
			String str[] = reader.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			edge[i][0] = a;
			edge[i][1] = b;
		}
		int ans = 0;
		//全ての辺を計算
		for(int i = 0; i < M; i++) {
			UnionFindTree uf = new UnionFindTree(N);
			//全ての辺を計算
			for(int j = 0; j < M; j++) {
				//i番目の辺だけカウントしない
				if (j != i) {
				uf.unite(edge[j][0], edge[j][1]);
				}
			}
			//i番目の辺をカウントしなかったことによって孤立する木ができたらその辺は橋
			if (!uf.same(edge[i][0], edge[i][1])){
				ans++;
			}
		}
		return ans ;
	}

}

class UnionFindTree {
	//親要素を保持する配列
    int[] parents;
    int[] rank;
    int[] size;
    public UnionFindTree(int n) {
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