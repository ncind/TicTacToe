
package com.nikptech.tictactoe;

import java.util.Scanner;


// The main class for Tic Tac Toe (Object Oriented Console Game ; Non Graphics Version) ; This class acts as the overall controller of the game
public class GameMain {

	private Board board; // The game board
	private GameState currentState; // The current state of the game (of enum GameState)
	private Seed currentPlayer; // the current play (of enum Seed)
	
	private static Scanner in = new Scanner(System.in); // input Scanner
	
	// Constructor to Setup the Game
	public GameMain(){
		board = new Board(); // Allocate the game board
		
		initGame();// Initialize the Game Board and current Status
		
		do{
			playerMove(currentPlayer); //update the content, currentRow and currentCol
			board.paint(); // ask the board to paint itself
			updateGame(currentPlayer); //update currentState
			
			//Print message if game-over
			if(currentState == GameState.CROSS_WON){System.out.println("'X' won! Bye !");}
			else if(currentState == GameState.NOUGHT_WON){System.out.println("'O' won! Bye !");}
			else if(currentState == GameState.DRAW){System.out.println("It's a draw, Bye !");}
			
			//Switch
			//Player
			
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
			
		}while(currentState == GameState.PLAYING); // repeat until the game is completed
		
		
	}
	
	
	// Initialize the Game Board contents and the current states
	public void initGame(){
		board.init(); // Clears the board contents
		currentPlayer = Seed.CROSS; // CROSS plays first
		currentState = GameState.PLAYING; // ready to play
	}
	
	// The player with "theSeed" makes one move, with input validation. Update Cell's content, Board's currentRow and currentCol 
	public void playerMove(Seed theSeed){
		boolean validInput = false; // for validating input
		do{
			if(theSeed == Seed.CROSS){System.out.println("Player 'X', enter your move (row[1-3] column[1-3]):");} else
			{System.out.println("Player 'O', enter your move (row[1-3] column[1-3]):");}
			
			int row = in.nextInt() - 1;
			int col = in.nextInt() - 1;
			if(row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS && board.cells[row][col].content == Seed.EMPTY){
				board.cells[row][col].content = theSeed;
				board.currentRow = row;
				board.currentCol = col;
				validInput = true; //input okay, exit loop
			} else{
				System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again... ");
			}
			
		} while (!validInput); // repeat until input is valid
		
	}
	
	//Update the currentState of the game, after the player with "theSeed" has moved
	public void updateGame(Seed theSeed){
		if(board.hasWon(theSeed)){ //check for win
			currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
		} else if (board.isDraw()){ // Check for draw
			currentState = GameState.DRAW;
		}
		// Otherwise, no change to the current state (still GameState.PLAYING)
	}
	
	// Start the game
	public static void main(String[] args) {
		
		new GameMain();

	}

}
