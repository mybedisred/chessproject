//David Saiontz
//Knight
//Moves in an L shape, it's literally a knight from normal chess idk. 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Knight extends Piece{
    
    
    public Knight(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }
    
    public String toString() {
    	if (super.getColor()) {
    		return "A white Knight";
    	}
    	return "A black Knight";
    }
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
  //Functions the same as a knight in the base game, moves 2 in one direction then 1 in another direction, it does jump.
    //Precondition: a 2d array with a starting square that is in the array and null
    //Postcondition: Returns controlled squares for the piece, a controlled square is another square in the board that is following the movement pattern explained above
    public ArrayList<Square> getControlledSquares(Square[][] board, Square currentSquare) {
    	int y = currentSquare.getRow();
    	int x = currentSquare.getCol();
    	ArrayList<Square> legalMoves = new ArrayList<Square>();
		
    	if (y-2>=0 && x-1>=0) {
    		legalMoves.add(board[y-2][x-1]);
    	}
    	if (y-1>=0 && x-2>=0) {
    		legalMoves.add(board[y-1][x-2]);
    	}
    	if (y-2>=0 && x+1<=7) {
    		legalMoves.add(board[y-2][x+1]);	
    	}
    	if (y-1>=0 && x+2<=7) {
    		legalMoves.add(board[y-1][x+2]);
    	}
    	if (y+2<=7 && x+1<=7) {
    		legalMoves.add(board[y+2][x+1]);	
    	}
    	if (y+1<=7 && x+2<=7) {
    		legalMoves.add(board[y+1][x+2]);
    	}
    	if (y+2<=7 && x-1>=0) {
    		legalMoves.add(board[y+2][x-1]);
    	}
    	if (y+1<=7 && x-2>=0) {
    		legalMoves.add(board[y+1][x-2]);
    	}
    	
    	return legalMoves;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    //Functions the same as a knight in the base game, moves 2 in one direction then 1 in another direction, it does jump.
    //Precondition: a filled out 8x8 chess board with a starting square that is in the board ArrayList and null
    //Postcondition: Returns all legal moves for the piece, a legal move is another square in the board that is unoccupied or occupied by a differently colored piece, following the movement pattern explained above
    public ArrayList<Square> getLegalMoves(Board b, Square currentSquare){
    	int y = currentSquare.getRow();
    	int x = currentSquare.getCol();
    	ArrayList<Square> legalMoves = new ArrayList<Square>();
    	if (b.getPawnCounter()>=1){
		if (y-2>=0 && x-1>=0) {
    		if (b.getSquareArray()[y-2][x-1].getOccupyingPiece() == null || b.getSquareArray()[y-2][x-1].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y-2][x-1]);
    		}
    	}
    	if (y-1>=0 && x-2>=0) {
    		if (b.getSquareArray()[y-1][x-2].getOccupyingPiece() == null || b.getSquareArray()[y-1][x-2].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y-1][x-2]);
    		}
    	}
    	if (y-2>=0 && x+1<=7) {
    		if (b.getSquareArray()[y-2][x+1].getOccupyingPiece() == null || b.getSquareArray()[y-2][x+1].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y-2][x+1]);
    		}
    	}
    	if (y-1>=0 && x+2<=7) {
    		if (b.getSquareArray()[y-1][x+2].getOccupyingPiece() == null || b.getSquareArray()[y-1][x+2].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y-1][x+2]);
    		}
    	}
    	if (y+2<=7 && x+1<=7) {
    		if (b.getSquareArray()[y+2][x+1].getOccupyingPiece() == null || b.getSquareArray()[y+2][x+1].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y+2][x+1]);
    		}
    	}
    	if (y+1<=7 && x+2<=7) {
    		if (b.getSquareArray()[y+1][x+2].getOccupyingPiece() == null || b.getSquareArray()[y+1][x+2].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y+1][x+2]);
    		}
    	}
    	if (y+2<=7 && x-1>=0) {
    		if (b.getSquareArray()[y+2][x-1].getOccupyingPiece() == null || b.getSquareArray()[y+2][x-1].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y+2][x-1]);
    		}
    	}
    	if (y+1<=7 && x-2>=0) {
    		if (b.getSquareArray()[y+1][x-2].getOccupyingPiece() == null || b.getSquareArray()[y+1][x-2].getOccupyingPiece().getColor() != currentSquare.getOccupyingPiece().getColor()) {
    			legalMoves.add(b.getSquareArray()[y+1][x-2]);
    		}
    	}
    	
    	return legalMoves;
    }
	else{
		return legalMoves;
	}
	}

}