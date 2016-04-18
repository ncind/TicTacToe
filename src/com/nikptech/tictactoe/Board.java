package com.nikptech.tictactoe;

// The Board class models the game board
public class Board { //save as Board.java
	
	//Named constants for the dimensions
	public static final int ROWS = 3;
	public static final int COLS = 3;
	
	//package access
	Cell[][] cells; // a board composes of ROWS-by-COLS instances
	
	// The current Seed's row and column
	int currentRow;
	int currentCol;
	
	//Constructor to initialize the game board
	public Board(){
		cells = new Cell[ROWS][COLS]; // allocating the array
		for(int row = 0; row < ROWS; ++row){
			for(int col = 0; col < COLS; ++col){
				cells[row][col] = new Cell(row,col); // allocate element of the array
			}
			
		}
	}
	
	//Initialize (or re-init) the contents of the game board
	public void init(){
		for(int row = 0; row < ROWS; ++row){
			for(int col = 0; col < COLS; ++col){
				cells[row][col].clear(); // clear all the cells content
			}
			
		}
	}
	
	//Return true if it is a draw (i.e., no more empty cell) 
	public boolean isDraw(){
		for(int row = 0; row < ROWS; ++row){
			for(int col = 0; col < COLS; ++col){
				if(cells[row][col].content == Seed.EMPTY){
					return false; // an emoty cell is found - Its Not a Draw - Exit
				}
			}
			
		}
		
		return true; // no empty cell - Its a draw
	}
	
	// Return true if the player with "theSeed" has won after placing at (currentRow, currentCol)
	public boolean hasWon(Seed theSeed){
		return (cells[currentRow][0].content == theSeed && cells[currentRow][1].content == theSeed && cells[currentRow][2].content == theSeed // 3 in the row
				|| cells[0][currentCol].content == theSeed && cells[1][currentCol].content == theSeed && cells[2][currentCol].content == theSeed // 3 in the column
				|| currentRow == currentCol && cells[0][0].content == theSeed && cells[1][1].content == theSeed && cells[2][2].content == theSeed // 3 in the diagnol
				|| currentRow + currentCol == 2 && cells[0][2].content == theSeed && cells[1][1].content == theSeed && cells[2][0].content == theSeed // 3 in the opposite diagnol
				);
	}
	
	//Paint Itself
	public void paint(){
		for(int row = 0; row < ROWS; ++row){
			for(int col = 0; col < COLS; ++col){
				cells[row][col].paint(); // each cell paints itself
				if(col < COLS - 1){
					System.out.println("|");
				}
				System.out.println();
				if(row < ROWS - 1){
					System.out.println("-----------------");
				}
				}
			}
	}

}
