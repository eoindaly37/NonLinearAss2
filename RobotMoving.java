package assignment2;

public class RobotMoving {
	
	public void RobotMovingSession() {
		float[][] matrix = new float[5][5];
		String[][] solutions = new String[5][5];
		float right = (float) 1.1;
		float down = (float) 1.3;
		float diag = (float) 2.5;
		
		solve(matrix, solutions, right, down, diag);
		printGrid(matrix, solutions, right, down, diag);
		
	}
	public static void solve(float matrix[][], String solutions[][], float right, float down, float diag) {
		matrix[0][0] = 0;
		solutions[0][0] = "-";
		for(int j=1; j<5; j++) {
			matrix[0][j] = matrix[0][j-1] + down;
			solutions[0][j] = "b";
		}
		for(int i=1; i<5; i++) {
			matrix[i][0] = matrix[i-1][0] + right;
			solutions[i][0] = "r";
			for(int j=1; j<5; j++){
				float a = matrix[i-1][j-1] + diag;
				float b = matrix[i][j-1] + down;
				float c = matrix[i-1][j] + right;
				if(a<b&&a<c) {
					matrix[i][j] = a;
					solutions[i][j] = "d";
				}
				if(b<a&&b<c) {
					matrix[i][j] = b;
					solutions[i][j] = "b";
				}
				else {
					matrix[i][j] = c;
					solutions[i][j] = "r";
				}
			}
		}
	}
	public static void printGrid(float matrix[][], String solutions[][], float right,
									float down, float diag) {
		for(int i=0; i<5; i++) {
			for(int j=0;j<5; j++) {
				System.out.print(" " + matrix[j][i] + "  ");
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j=0;j<5; j++) {
				System.out.print(" " + solutions[j][i] + "  ");
			}
			System.out.println();
		}
		System.out.println("-----------------EXPLAINATION------------------");
		System.out.println("Total cost from (0,0) to (4,4) is " + matrix[4][4]);
		float cost = 0;
		int x = 4;
		int y = 4;
		System.out.println("Starting at (4,4):");
		while(cost<matrix[4][4]) {
			if(solutions[x][y].equals("r")) {
				x--;
				cost += right;
				System.out.println("Moved right from (" + x + "," + y + ") with a cost of €" + right);
				System.out.println("Cost Accumulated: €" + cost);
			}
			else if(solutions[x][y].equals("b")) {
				y--;
				cost += down;
				System.out.println("Moved down from (" + x + ","+ y + ") with a cost of €" + down);
				System.out.println("Cost Accumulated: €" + cost);
			}
		}
		
	}
	
}
