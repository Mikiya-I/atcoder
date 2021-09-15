package algorithm;

public class GridRotateSample {
	
	boolean[][] rotate(boolean[][] grid){
		int originWidth= grid[0].length, originHeight = grid.length;
		boolean[][] result = new boolean[originWidth][originHeight];
		for(int i=0;i<originHeight;i++) {
			for(int j=0;j<originWidth;j++) {
				result[originWidth-1-j][i]= grid[i][j];
			}
		}
		return result;
	}

}
