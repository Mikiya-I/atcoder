package atCoder400;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beginner206_D {
	public static void main(String[] args) throws IOException {
		
		long  ans = slove();
		System.out.println(ans);
	}
	
	public static long slove() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int N =Integer.parseInt(reader.readLine());
		final String[] strs = reader.readLine().split(" ");
		int[] arr = new int[N];
		int max=0;
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(strs[i]);
			max=Math.max(max, arr[i]);
		}
		
		long ans =0;
		UnionFind206 uf = new UnionFind206(max+1);
		for(int i=0;i<N/2;i++) {
			uf.unite(arr[i],arr[N-i-1]);
		}
		for(int i=0;i<max+1;i++) {
			if(uf.parents[i]==i) {
				ans += uf.getSize(i)-1;
			}
		}
		return ans;
	}
}

	class UnionFind206 {
	//親要素を保持する配列
    int[] parents;
    int[] rank;
    int[] size;
    
    public UnionFind206(int n) {
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
