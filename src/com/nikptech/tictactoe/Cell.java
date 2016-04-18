package com.nikptech.tictactoe;

// The Cell class models each individual cell of the game board
public class Cell {

	// Package Access
	public Seed content; // Content of this cell of type Seed. Takes a value of
							// Seed.EMPTY, Seed.CROSS or Seed.NOUGHT

	// row and column of this cell
	int row;
	int col;

	// Construtor to initialize this cell
	public Cell(int row, int col) {

		// assign the input row anc col
		this.row = row;
		this.col = col;
		this.clear(); // Clear the content
	}

	// Clear the cell content to Empty
	public void clear() {
		content = Seed.EMPTY;
	}

	// Paint Itself
	public void paint() {
		switch (content) {
		case CROSS:
			System.out.println("X");
			break;
		case NOUGHT: 
			System.out.println("O");
			break;
		case EMPTY:
			System.out.println(" ");
			break;

		}

	}

}
