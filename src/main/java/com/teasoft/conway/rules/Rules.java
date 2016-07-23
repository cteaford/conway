package com.teasoft.conway.rules;



public class Rules{

	public static boolean isLiveCellLessThanTwoNeighbors(int live, int dead, boolean isAlive){
		return isAlive == true && live < 2;
	} 

	public static boolean isLiveCellMoreThanThreeNeighbors(int live, int dead, boolean isAlive){
		return isAlive == true && live > 3;
	}

	public static boolean isDeadCellThreeNeighbors(int live, int dead, boolean isAlive){
		return isAlive == false && live == 3;
	}
	
}