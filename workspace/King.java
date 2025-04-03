
//Mr. M
//03/20/24
//This class represents the King piece in our chess game. It is able to move exactly one square in any direction and controls those squares.
//All functionality associated with checks is religated to the class Board. (You'll have to implement that part yourself!).
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class King extends Piece {
	// constructor
	public King(boolean isWhite, String img_file) {
		super(isWhite, img_file);
	}

	// Pre-condition: b is a non-null board that contains some squares. The
	// currentSquare is non-null and present in the board.
	// Post-condition: Returns all legally accessable squares by this piece. In the
	// event that no squares are accessable returns an empty list.
	@Override
	public ArrayList<Square> getLegalMoves(Board b, Square currentSquare) {
		ArrayList<Square> legalMoves = new ArrayList<>();
		Square[][] board = b.getSquareArray();
		int row = currentSquare.getRow();
		int col = currentSquare.getCol();
		
		//left
		if (col > 0) {
			if (!board[row][col-1].isOccupied() || board[row][col -1].getOccupyingPiece().getColor() != this.getColor()) {
				legalMoves.add(board[row][col-1]);
			}
			//left up
			if (row > 0) {
				if (!board[row -1 ][col -1].isOccupied()
						|| board[row - 1][col - 1].getOccupyingPiece().getColor() != this.getColor()) {
					legalMoves.add(board[row - 1][col - 1]);
				}
			}
			//left down
			if (row < board.length-1) {
				if (!board[row+1][col-1].isOccupied()
						|| board[row+1][col-1].getOccupyingPiece().getColor() != this.getColor()) {
					legalMoves.add(board[row+1][col-1]);
				}
			}
		}
		//up
		if (row > 0) {
			if (!board[row-1][col].isOccupied() || board[row-1][col].getOccupyingPiece().getColor() != this.getColor()) {
				legalMoves.add(board[row - 1][col]);
			}
		}
		//down
		if (row < board.length - 1) {
			if (!board[row +1][col].isOccupied()
					|| board[row+1][col].getOccupyingPiece().getColor() != this.getColor()) {
				legalMoves.add(board[row+1][col]);
			}
		}
		//right
		if (col < board[row].length-1) {
			if (!board[row][col+1].isOccupied() || board[row][col+1].getOccupyingPiece().getColor() != this.getColor()) {
				legalMoves.add(board[row][col+1]);
			}
			//right up
			if (row > 0) {

				if (!board[row-1][col+ 1].isOccupied()
						|| board[row-1][col+1].getOccupyingPiece().getColor() != this.getColor()) {
					legalMoves.add(board[row-1][col+1]);
				}
			}
			//right down
			if (row < board.length -1) {
				if (!board[row+1][col + 1].isOccupied()
						|| board[row + 1][col + 1].getOccupyingPiece().getColor() != this.getColor()) {
					legalMoves.add(board[row + 1][col + 1]);
				}

			}
		}

		return legalMoves;

	}

	@Override
	public String toString() {

		return "A " + super.toString() + " king";
	}

	// Checks each of the 8 squares surrounding the king and adds the square to a
	// list of controlled squares if it is within the bounds of the board. Finally,
	// it returns the list of controlled squares as an array.
	@Override
	public ArrayList<Square> getControlledSquares(Square[][] board, Square currentSquare) {
		ArrayList<Square> controlledSquares = new ArrayList<Square>();

		// Determine the row and column of the current square
		int row = currentSquare.getRow();
		int col = currentSquare.getCol();

		// Check each of the 8 squares surrounding the king
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				// Skip the square the king is currently on
				if (i == 0 && j == 0) {
					continue;
				}

				// Check if the square is within the bounds of the board
				if (row + i >= 0 && row + i < board.length && col + j >= 0 && col + j < board[row].length) {
					// Add the square to the list of controlled squares
					controlledSquares.add(board[row + i][col + j]);
				}
			}
		}

		return controlledSquares;
	}

}
