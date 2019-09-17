package assignment2;

import java.util.Arrays;

public class PaperRollCuttingBottomUp {
	
	
	public static void rollSession(int rollLength) {
		
		float[] prices = new float[rollLength+2];
		prices[1] = (float) 1.2;
		prices[2] = (float) 3.0;
		prices[3] = (float) 5.8;
		prices[5] = (float) 10.1;

		boolean[] a = new boolean[rollLength+2];
		a[0] = true;
		a[1] = true;
		a[2] = true;
		a[3] = true;
		a[5] = true;

		float[] r = new float[rollLength+1];
		int[] s = new int[rollLength+1];

		rollSolve(rollLength, prices, a, r, s);

		rollExplain(rollLength, r ,s);

	}

	public static void rollSolve(int rollLength, float prices[], boolean a[],
									float r[], int s[]) {
		r[0] = 0;
		for(int j=1; j<=rollLength; j++) {
			float q = -1;
			for(int i=1;i<=j;i++) {
				if(a[i]==true) {
					if(q<prices[i]+r[j-i]) {
						q = prices[i] + r[j-i];
						s[j] = i;
					}
				}
			}
			r[j] = q;
		}
	}
	
	public static void rollExplain(int rollLength, float r[], int s[]) {
		System.out.println("------Arrays-------");
		System.out.println("optimalPrices="+Arrays.toString(r));
		System.out.println("cuts="+Arrays.toString(s));
		
		System.out.println("\n------Explanation------");
		System.out.println("Best price is €" + r[rollLength] + " for a roll of length " + rollLength);
		
		int length = rollLength;
		int total = 0;
		System.out.println("\nPieces cut:");
		while(length>0) {
			int newcut = s[length];
			total += newcut;
			System.out.println("A roll of length " + newcut + " is cut with price €" + r[newcut]);
			System.out.println("New total length accumulated = " + total);
			length -= newcut;
		}
		
	}
}
