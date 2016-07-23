package com.teasoft.conway;

import java.util.Scanner;
import com.teasoft.conway.rules.Rules;

public class Main {

	private static final int GRID_SIZE = 6;
	private static final char LIVE_CELL = 'O';
	private static final char DEAD_CELL = '.';

	public static void main(String[] args){		
		char[][] newRows = new char[GRID_SIZE][];		
		char[][] rows = getGrid();		
		newRows = gridCopy(rows);
		performLifeCycle(rows, newRows);
		printOutput(newRows);
	}

	private static void performLifeCycle(char[][] rows, char[][] newRows){
		for(int i = 0;i < GRID_SIZE; i++){
			for(int j = 0; j < 8; j ++){
				int live = getLiveNeighbors(j, i, rows);
				int dead = 8 - live;
				if(Rules.isLiveCellLessThanTwoNeighbors(live, dead, rows[i][j] == LIVE_CELL) ||
					Rules.isLiveCellMoreThanThreeNeighbors(live, dead, rows[i][j] == LIVE_CELL) ||
					Rules.isDeadCellThreeNeighbors(live, dead, rows[i][j] == LIVE_CELL)){
					change(j, i, newRows);
				}
			}
		}
	}

	private static char[][] getGrid(){
		Scanner in = new Scanner(System.in);
		char[][] rows = new char[GRID_SIZE][];
		int row = 0;
		System.out.println("Enter Grid: ");
		while(row < GRID_SIZE){					
			rows[row] = in.nextLine().toCharArray();
			row++;
		}
		return rows;
	}

	private static void printOutput(char[][] newRows){
		System.out.print("\n\n\n");
		for(int i = 0; i < 6; i++){
			System.out.print("\n"); 
			for(int j = 0; j < 8; j++){
				System.out.print(newRows[i][j]);
			}
		}
		System.out.print("\n\n\n");
	}

	private static int getLiveNeighbors(int x, int y, char[][] grid){
		int neighbors = 0;

		//This is the coordinates for looping around a cell
		int[] yCoord = new int[] {-1,-1,-1,0,1,1,1,0};
		int[] xCoord = new int[] {-1,0,1,1,1,0,-1,-1};


		for(int loopSize = 0; loopSize < 8; loopSize++){			
			try{
				char c = grid[y + yCoord[loopSize]][x + xCoord[loopSize]];
				if( c == LIVE_CELL){
					neighbors++;
				}
			}catch(ArrayIndexOutOfBoundsException e){/*This just means we're on an edge*/}
		} 
		return neighbors;		
	}

	private static void change(int x, int y, char[][] grid){
		if(grid[y][x] == LIVE_CELL){
			grid[y][x] = DEAD_CELL;
		}else{
			grid[y][x] = LIVE_CELL;
		}

	}

	private static char[][] gridCopy(char[][] input){
		char[][] output = new char[input.length][];
		for(int i = 0; i < input.length; i++){
			output[i] = input[i].clone();
		}
		return output;
	}
}






