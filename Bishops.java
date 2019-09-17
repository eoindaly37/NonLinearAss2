package assignment2;

public class Bishops {
	public void bishopsSession(int n) {
		int size = n;
		int left = n;
		boolean[][] pos = new boolean[n][n];
		int[][] attack = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<size; j++) {
				pos[i][j] = false;
				attack[i][j] = 0;
			}
		}
		int last = -1;
	
		solveBishops(size,left,pos,attack,last);
	
	}
	
	public void solveBishops(int size, int left, boolean pos[][], int[][] attack,
								int last) {
		
		if(left==0) {
			bishopsPrint(pos, size);
		}
		else {
			for(int i = last+1; i < (size*size); i++) {
				int x = i % size;
				int y = i / size;
				
				if(attack[x][y] == 0) {
					
					// I. Evolve
					pos[x][y] = true;	
					fillAttack(attack, x, y, size, false);

					// II. Solve Recursively
					solveBishops(size, left-1, pos, attack, i);
					
					// III. Backtrack
					pos[x][y] = false;	
					fillAttack(attack, x, y, size, true);
				}
				
			}
			
		}

	}
	
	
	
	
	
	public void fillAttack(int attack[][], int x, int y, int size, boolean back) {
		// Local variable
		int myVal = 1;
		if (back == true)
			myVal = -1;
		
		
		// 1. Current Position
		attack[x][y] = attack[x][y] + myVal;
		
		
		int i=x+1;
		int j=y-1;
		//DIRECTION 1 - UP RIGHT
		while(i<size && j>=0) {
			attack[i][j] = attack[i][j] + myVal;
			i++;
			j--;
		}
		//DIRECTION 2 - DOWN RIGHT
		i=x+1;
		j=y+1;
		while(i<size && j<size) {
			attack[i][j] = attack[i][j] + myVal;
			i++;
			j++;
		}
		//DIRECTION 3 - DOWN LEFT
		i=x-1;
		j=y+1;
		while(i>=0 && j<size) {
			attack[i][j] = attack[i][j] + myVal;
			i--;
			j++;
		}
		//DIRECTION 4 - UP LEFT
		i=x-1;
		j=y-1;
		while(i>=0 && j>=0) {
			attack[i][j] = attack[i][j] + myVal;
			i--;
			j--;
		}
	}
	
	public String symbol(boolean bishop) {
		if(bishop==true) {
			return "B";
		}
		else {
			return "*";
		}
	}
	
	public void bishopsPrint(boolean pos[][], int size) {
		System.out.println("Solution for size " + size);
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print("  " + symbol(pos[i][j]) + "  ");
			}
			System.out.println();
		}
	}
}
