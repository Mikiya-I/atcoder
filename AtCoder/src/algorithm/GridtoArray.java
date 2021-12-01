package algorithm;

class GridtoArray {
	private long[] gridToArray(long[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		int size = height * width;
		long[] arr = new long[size];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				int idx = i*width + j;
				arr[idx] = grid[i][j];
			}
		}
		return arr;
	}
	
	//グリッドを元にした一次配列において任意の要素から周りの要素を取得
	private void around(long[] arr, int height, int width, int node) {
		//↑、←、↓、→　の順
		int[] differences1 = {-1,0,1,0};
		int [] differences2 = {0,-1,0,1} ;
		for(int i=0;i<3;i++) {
			//行
			int tmpRow = node/width + differences1[i];
			int tmpColumn = node%width + differences2[i];
			//行番号が-1かheightの値になれば端(隣ではない)
			if(tmpRow != -1 && tmpRow == height) {
				//列番号が-1かwidth-1の値になれば端
				if( tmpColumn != -1 && tmpColumn != width-1) {
					System.out.println("node");
				}
			}
		}
	}
}
